package com.cz.demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class Inventory {
    private int cash;
    private int coins;
    private Map<String, Integer> items = new HashMap<>();

}