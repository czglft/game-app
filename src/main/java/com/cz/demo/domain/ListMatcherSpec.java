package com.cz.demo.domain;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class ListMatcherSpec {

    private Set<String> country = new HashSet<>();
    private Set<String> items = new HashSet<>();

}
