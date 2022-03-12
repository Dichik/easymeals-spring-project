package com.example.easymeals.dataprovider.dto;

import com.univocity.parsers.annotations.Parsed;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDto {

    @Parsed(field = "name")
    private String name;

    @Parsed(field = "amountId")
    private Double amountId;

    @Parsed(field = "consistency")
    private String consistency;

    @Parsed(field = "units")
    private String units;

    private Boolean itemInBasket;

}
