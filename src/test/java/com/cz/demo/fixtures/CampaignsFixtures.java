package com.cz.demo.fixtures;

import com.cz.demo.domain.Campaign;
import com.cz.demo.domain.CampaignLevelMatcherSpec;
import com.cz.demo.domain.CampaignMatchersSpecs;
import com.cz.demo.domain.ListMatcherSpec;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Set;

public class CampaignsFixtures {
    public static Campaign generateSampleCampaign() {
        return generateSampleCampaignWithLevelsRange(1,100);
    }

    public static Campaign generateSampleCampaignWithLevelsRange(int minLevel, int maxLevel) {
        Campaign campaign = new Campaign();
        CampaignMatchersSpecs matcherSpecifications = mockMatcherSpecs(minLevel, maxLevel);
        campaign.setMatchers(matcherSpecifications);
        setOtherProperties(campaign);
        return campaign;
    }

    private static void setOtherProperties(Campaign campaign) {
        campaign.setName("MOCK_CAMPAIGN_NAME");
        campaign.setGame("MOCK_GAME_NAME");
        campaign.setEnabled(true);
        campaign.setPriority(10.5);
        campaign.setStartDate(ZonedDateTime.now());
        campaign.setEndDate(ZonedDateTime.now().plusDays(10));
        campaign.setLastUpdated(LocalDateTime.now().toString());
    }

    private static CampaignMatchersSpecs mockMatcherSpecs(int minLevel, int maxLevel) {
        CampaignMatchersSpecs matcherSpecifications = new CampaignMatchersSpecs();
        CampaignLevelMatcherSpec levelMatcherSpec = new CampaignLevelMatcherSpec(minLevel, maxLevel);
        ListMatcherSpec includeSpecs = new ListMatcherSpec();
        includeSpecs.setCountry(Set.of("US", "RO", "CA"));
        includeSpecs.setItems(Set.of("item_1"));
        ListMatcherSpec excludeSpecs = new ListMatcherSpec();
        excludeSpecs.setItems(Set.of("item_4"));
        matcherSpecifications.setHas(includeSpecs);
        matcherSpecifications.setDoesNotHave(excludeSpecs);
        matcherSpecifications.setLevel(levelMatcherSpec);
        return matcherSpecifications;
    }


}
