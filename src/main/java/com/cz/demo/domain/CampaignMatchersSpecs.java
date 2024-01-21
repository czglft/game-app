package com.cz.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CampaignMatchersSpecs {
    private CampaignLevelMatcherSpec level;
    private ListMatcherSpec has;
    private ListMatcherSpec doesNotHave;

}
