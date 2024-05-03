package com.ms.cuponcompra.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BodyDto {

    @JsonAlias("id")
    private String id;

    @JsonAlias("price")
    private Double price;

    @JsonAlias("category_id")
    private String categoryId;

    @JsonAlias("title")
    private String title;

    @JsonAlias("site_id")
    private String site_id;
}
