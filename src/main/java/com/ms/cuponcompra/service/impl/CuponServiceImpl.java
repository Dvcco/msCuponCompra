package com.ms.cuponcompra.service.impl;

import com.ms.cuponcompra.dto.CuponRequest;
import com.ms.cuponcompra.dto.CuponResponse;
import com.ms.cuponcompra.dto.ItemsResponse;
import com.ms.cuponcompra.exception.ExcepcionCuponCompra;
import com.ms.cuponcompra.service.CuponService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

import static com.ms.cuponcompra.utils.Constantes.*;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Service
@AllArgsConstructor
public class CuponServiceImpl implements CuponService {

    private final WebClient webClient;
    @Override
    public Mono<CuponResponse> getCouponDetails(CuponRequest request, String token) {
        Double couponAmount = request.getAmount();
        return getItemDetails(request, token)
                .flatMapMany(Flux::fromIterable)
                .collectList()
                .map(items -> {
                    List<String> couponItems = items.stream()
                            .filter(item -> item.getBody().getPrice() <= couponAmount)
                            .map(item -> item.getBody().getId())
                            .collect(Collectors.toList());
                    double totalCouponValue = items.stream()
                            .filter(item -> couponItems.contains(item.getBody().getId()))
                            .mapToDouble(item -> item.getBody().getPrice())
                            .sum();
                    if (totalCouponValue > couponAmount) {
                        String errorMessage = String.format(CUPON_SUPERA_PRECIO, couponAmount);
                        throw new ExcepcionCuponCompra(COD_001, HttpStatus.BAD_REQUEST, errorMessage);
                    }
                    return new CuponResponse(couponItems, totalCouponValue);
                });
    }
    @Override
    public Mono<List<ItemsResponse>> getItemDetails(CuponRequest request, String token) {
        List<String> itemsIds = request.getItem_ids();
        String items = String.join(COMA, itemsIds);
        String attributes = String.join(COMA, ATTRIBUTE_ID, ATTRIBUTE_PRICE, ATTRIBUTE_CATEGORY_ID, ATTRIBUTE_TITLE, ATTRIBUTE_SITE_ID);
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(PATH_GET_CUPON)
                        .queryParam(IDS, items)
                        .queryParam(ATTRIBUTES, attributes)
                        .build())
                .header(AUTHORIZATION, BEARER + token)
                .retrieve()
                .bodyToFlux(ItemsResponse.class)
                .collectList();
    }
}
