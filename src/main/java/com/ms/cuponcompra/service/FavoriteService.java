package com.ms.cuponcompra.service;

import com.ms.cuponcompra.dto.FavoriteResponse;
import com.ms.cuponcompra.dto.FavoriteRequest;
import reactor.core.publisher.Flux;

public interface FavoriteService {
    Flux<FavoriteResponse> getFavorite(FavoriteRequest request, String token);
}
