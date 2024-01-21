package com.cz.demo.domain.matchers;

import com.cz.demo.domain.*;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ListIncludeProfileMatcherTest {

    @Test
    public void testMatchPlayerWithCampaign_CountryAndItemsMatch() {
        ListIncludeProfileMatcher matcher = new ListIncludeProfileMatcher();

        // Example player profile
        PlayerProfile playerProfile = new PlayerProfile();
        playerProfile.setCountry("US");
        Inventory inventory = new Inventory();
        inventory.setItems(Map.of("item_1", 1));
        playerProfile.setInventory(inventory);

        // Example campaign with matchers
        Campaign campaign = new Campaign();
        CampaignMatchersSpecs matchersSpecs = new CampaignMatchersSpecs();
        ListMatcherSpec hasMatchers = new ListMatcherSpec();
        matchersSpecs.setHas(hasMatchers);
        hasMatchers.getCountry().add("US");
        hasMatchers.getItems().add("item_1");
        campaign.setMatchers(matchersSpecs);

        boolean result = matcher.matchPlayerWithCampaign(playerProfile, campaign);

        assertTrue(result);
    }

    @Test
    public void testMatchPlayerWithCampaign_CountryAndItemsDoNotMatch() {
        ListIncludeProfileMatcher matcher = new ListIncludeProfileMatcher();

        // Example player profile
        PlayerProfile playerProfile = new PlayerProfile();
        playerProfile.setCountry("CA");
        Inventory inventory = new Inventory();
        inventory.setItems(Map.of("item_2", 1));
        playerProfile.setInventory(inventory);

        // Example campaign with matchers
        Campaign campaign = new Campaign();
        CampaignMatchersSpecs matchersSpecs = new CampaignMatchersSpecs();
        ListMatcherSpec hasMatchers = new ListMatcherSpec();
        matchersSpecs.setHas(hasMatchers);
        hasMatchers.getCountry().add("US");
        hasMatchers.getItems().add("item_1");
        campaign.setMatchers(matchersSpecs);

        boolean result = matcher.matchPlayerWithCampaign(playerProfile, campaign);

        assertFalse(result);
    }

    @Test
    public void testMatchPlayerWithCampaign_ItemsNotIncludedOrExcluded() {
        ListIncludeProfileMatcher matcher = new ListIncludeProfileMatcher();

        // Example player profile
        PlayerProfile playerProfile = new PlayerProfile();
        Map<String, Integer> inventoryItems = new HashMap<>();
        inventoryItems.put("item_2", 1);
        inventoryItems.put("item_3", 2);
        playerProfile.getInventory().setItems(inventoryItems);

        // Example campaign with matchers
        Campaign campaign = new Campaign();
        CampaignMatchersSpecs matchersSpecs = new CampaignMatchersSpecs();
        ListMatcherSpec hasMatchers = new ListMatcherSpec();
        matchersSpecs.setHas(hasMatchers);
        hasMatchers.getItems().add("item_1");
        campaign.setMatchers(matchersSpecs);

        boolean result = matcher.matchPlayerWithCampaign(playerProfile, campaign);

        assertFalse(result);
    }
}
