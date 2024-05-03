package com.ms.cuponcompra.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CuponRequest {

    private List<String> item_ids;

    private Double amount;

    @JsonIgnore
    private String token;
}
