package com.cz.demo.service;

import com.cz.demo.domain.Campaign;
import com.cz.demo.domain.CampaignLevelMatcherSpec;
import com.cz.demo.domain.CampaignMatchersSpecs;
import com.cz.demo.domain.ListMatcherSpec;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Set;

@Service
public class CampaignMockedService implements CampaignService {

    public static final String MOCK_GAME_NAME = "mygame";
    public static final String MOCK_CAMPAIGN_NAME = "mycampaign";
    public static final int MOCK_CAMPAIGN_MIN_LEVEL = 1;
    public static final int MOCK_CAMPAIGN_MAX_LEVEL = 4;

    @Override
    public Campaign getCurrentCampaignData() {
        // Mocked implementation, replace with actual logic to fetch current campaign data
        CampaignMatchersSpecs matcherSpecifications = mockMatcherSpecs();

        Campaign campaign = new Campaign();
        campaign.setName(MOCK_CAMPAIGN_NAME);
        campaign.setGame(MOCK_GAME_NAME);
        campaign.setEnabled(true);
        campaign.setPriority(10.5);
        campaign.setStartDate(ZonedDateTime.now());
        campaign.setEndDate(ZonedDateTime.now().plusDays(10));
        campaign.setLastUpdated(LocalDateTime.now().toString());
        campaign.setMatchers(matcherSpecifications);
        return campaign;
    }

    private  CampaignMatchersSpecs mockMatcherSpecs() {
        CampaignMatchersSpecs matcherSpecifications = new CampaignMatchersSpecs();
        CampaignLevelMatcherSpec levelMatcherSpec = new CampaignLevelMatcherSpec(MOCK_CAMPAIGN_MIN_LEVEL, MOCK_CAMPAIGN_MAX_LEVEL);
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
