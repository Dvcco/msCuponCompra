package com.ms.cuponcompra.controller;

import com.ms.cuponcompra.dto.CuponRequest;
import com.ms.cuponcompra.dto.CuponResponse;
import com.ms.cuponcompra.dto.ItemsResponse;
import com.ms.cuponcompra.service.CuponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/challenge/mercadolibre")
@CrossOrigin(origins = "*")
public class CuponController {

    @Autowired
    private CuponService cuponService;

    @PostMapping("/coupon")
    public Mono<CuponResponse> getCouponDetails(@RequestBody CuponRequest request, @RequestHeader String authToken) {
        return cuponService.getCouponDetails(request, authToken);
    }

    @PostMapping("/items")
    public Mono<List<ItemsResponse>> getItemDetails(@RequestBody CuponRequest request, @RequestHeader String authToken) {
        return cuponService.getItemDetails(request, authToken);
    }
}
