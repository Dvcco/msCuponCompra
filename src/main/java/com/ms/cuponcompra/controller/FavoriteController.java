package com.ms.cuponcompra.controller;

import com.ms.cuponcompra.dto.FavoriteRequest;
import com.ms.cuponcompra.dto.FavoriteResponse;
import com.ms.cuponcompra.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/challenge/mercadolibre")
@CrossOrigin(origins = "*")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @GetMapping("/coupon/stats")
    public Flux<FavoriteResponse> getFavorite(@RequestParam List<String> items, @RequestParam String fechaInicial, @RequestParam String fechaFinal, @RequestHeader String authToken) {
        FavoriteRequest request = new FavoriteRequest();
        request.setItems(items);
        request.setFechaInicial(fechaInicial);
        request.setFechaFinal(fechaFinal);
        return favoriteService.getFavorite(request, authToken);
    }
}
