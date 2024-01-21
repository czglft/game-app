package com.cz.demo.domain.matchers;

import com.cz.demo.domain.Campaign;
import com.cz.demo.domain.CampaignMatchersSpecs;
import com.cz.demo.domain.ListMatcherSpec;
import com.cz.demo.domain.PlayerProfile;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ListExcludeProfileMatcherTest {
    @Test
    public void testMatchPlayerWithCampaign_CountryAndItemsDoNotMatch() {
        ListExcludeProfileMatcher matcher = new ListExcludeProfileMatcher();

        // Example player profile
        PlayerProfile playerProfile = new PlayerProfile();
        playerProfile.setCountry("US");

        // Example campaign with matchers
        Campaign campaign = new Campaign();
        CampaignMatchersSpecs matchersSpecs = new CampaignMatchersSpecs();
        ListMatcherSpec doesNotHaveMatchers = new ListMatcherSpec();
        doesNotHaveMatchers.getCountry().add("US");
        doesNotHaveMatchers.getItems().add("item_1");
        campaign.setMatchers(matchersSpecs);
        matchersSpecs.setDoesNotHave(doesNotHaveMatchers);

        boolean result = matcher.matchPlayerWithCampaign(playerProfile, campaign);

        assertFalse(result);
    }

    @Test
    public void testMatchPlayerWithCampaign_CountryAndItemsMatch() {
        ListExcludeProfileMatcher matcher = new ListExcludeProfileMatcher();

        // Example player profile
        PlayerProfile playerProfile = new PlayerProfile();
        playerProfile.setCountry("CA");

        // Example campaign with matchers
        Campaign campaign = new Campaign();
        CampaignMatchersSpecs matchersSpecs = new CampaignMatchersSpecs();
        ListMatcherSpec doesNotHaveMatchers = new ListMatcherSpec();
        doesNotHaveMatchers.getCountry().add("US");
        doesNotHaveMatchers.getItems().add("item_1");
        campaign.setMatchers(matchersSpecs);
        matchersSpecs.setDoesNotHave(doesNotHaveMatchers);

        boolean result = matcher.matchPlayerWithCampaign(playerProfile, campaign);

        assertTrue(result);
    }

    @Test
    public void testMatchPlayerWithCampaign_ItemsIncludedInExclusionList() {
        ListExcludeProfileMatcher matcher = new ListExcludeProfileMatcher();

        // Example player profile
        PlayerProfile playerProfile = new PlayerProfile();
        Map<String, Integer> inventoryItems = new HashMap<>();
        inventoryItems.put("item_1", 1);
        inventoryItems.put("item_2", 2);
        playerProfile.getInventory().setItems(inventoryItems);

        // Example campaign with matchers
        Campaign campaign = new Campaign();
        CampaignMatchersSpecs matchersSpecs = new CampaignMatchersSpecs();
        ListMatcherSpec doesNotHaveMatchers = new ListMatcherSpec();
        doesNotHaveMatchers.getItems().add("item_1");
        campaign.setMatchers(matchersSpecs);
        matchersSpecs.setDoesNotHave(doesNotHaveMatchers);

        boolean result = matcher.matchPlayerWithCampaign(playerProfile, campaign);

        assertFalse(result);
    }
}