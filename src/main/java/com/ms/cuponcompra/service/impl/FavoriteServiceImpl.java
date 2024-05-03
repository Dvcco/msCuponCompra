package com.ms.cuponcompra.service.impl;

import com.ms.cuponcompra.dto.FavoriteRequest;
import com.ms.cuponcompra.dto.FavoriteResponse;
import com.ms.cuponcompra.dto.VisitDetail;
import com.ms.cuponcompra.service.FavoriteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;

import static com.ms.cuponcompra.utils.Constantes.*;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Service
@AllArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {

    private final WebClient webClient;
    @Override
    public Flux<FavoriteResponse> getFavorite(FavoriteRequest request, String token){
        List<String> itemsIds = request.getItems();
        String fechaInicial = request.getFechaInicial();
        String fechaFinal = request.getFechaFinal();
        String attributes = String.join(COMA, ATTRIBUTE_ITEM_ID, ATTRIBUTE_VISITS);
        Flux<String> itemsFlux = Flux.fromIterable(itemsIds);
        return itemsFlux.flatMap(itemId -> getFavoriteForItemId(itemId, attributes, fechaInicial, fechaFinal, token))
                .sort((fav1, fav2) -> {
                    List<VisitDetail> visitsDetail1 = fav1.getVisitsDetail();
                    List<VisitDetail> visitsDetail2 = fav2.getVisitsDetail();
                    if (visitsDetail1.isEmpty() || visitsDetail2.isEmpty()) {
                        return 0;
                    }
                    Integer quantity1 = visitsDetail1.get(0).getQuantity();
                    Integer quantity2 = visitsDetail2.get(0).getQuantity();
                    return Integer.compare(quantity2, quantity1);
                });
    }

    private Flux<FavoriteResponse> getFavoriteForItemId(String itemId, String attributes, String fechaInicial, String fechaFinal, String token) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(PATH_GET_FAVORITE)
                        .queryParam(IDS, itemId)
                        .queryParam(ATTRIBUTE_DATE_FROM, fechaInicial)
                        .queryParam(ATTRIBUTE_DATE_TO, fechaFinal)
                        .queryParam(ATTRIBUTES, attributes)
                        .build())
                .header(AUTHORIZATION, BEARER + token)
                .retrieve()
                .bodyToFlux(FavoriteResponse.class);
    }
}
