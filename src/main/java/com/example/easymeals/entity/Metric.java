package com.example.easymeals.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Metric {

    private Double amount;
    private String unitLong;
    private String unitShort;

}
