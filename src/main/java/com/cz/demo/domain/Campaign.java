package com.cz.demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
public class Campaign {

    private String game;
    private String name;
    private double priority;
    private CampaignMatchersSpecs matchers;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private boolean enabled;
    private String lastUpdated;


}
