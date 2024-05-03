package com.ms.cuponcompra.service;

import com.ms.cuponcompra.dto.CuponRequest;
import com.ms.cuponcompra.dto.CuponResponse;
import com.ms.cuponcompra.dto.ItemsResponse;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CuponService {

    Mono<List<ItemsResponse>> getItemDetails(CuponRequest request, String token);
    Mono<CuponResponse> getCouponDetails(CuponRequest request, String token) ;
}
