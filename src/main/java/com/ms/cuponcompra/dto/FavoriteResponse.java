package com.ms.cuponcompra.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FavoriteResponse {

    @JsonProperty("id")
    @JsonAlias("item_id")
    private String id;

    @JsonProperty("visits_detail")
    private List<VisitDetail> visitsDetail;
}
