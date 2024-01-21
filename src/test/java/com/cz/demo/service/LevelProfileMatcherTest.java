package com.cz.demo.service;

import com.cz.demo.domain.Campaign;
import com.cz.demo.domain.PlayerProfile;
import com.cz.demo.domain.matchers.LevelProfileMatcher;
import com.cz.demo.fixtures.CampaignsFixtures;
import com.cz.demo.fixtures.PlayerProfileFixtures;
import com.cz.demo.utils.BaseUnitTestClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LevelProfileMatcherTest extends BaseUnitTestClass {


    @Test
    void testMatchPlayerWithCampaignInRange() {
        PlayerProfile playerProfile = PlayerProfileFixtures.generateSamplePlayerProfileWithLevel(2);
        Campaign campaign = CampaignsFixtures.generateSampleCampaignWithLevelsRange(1, 3);

        LevelProfileMatcher levelProfileMatcher = new LevelProfileMatcher();

        boolean result = levelProfileMatcher.matchPlayerWithCampaign(playerProfile, campaign);

        Assertions.assertTrue(result);
    }

    @Test
    void testMatchPlayerWithCampaignOutsideRange() {
        PlayerProfile playerProfile = PlayerProfileFixtures.generateSamplePlayerProfileWithLevel(5);
        Campaign campaign = CampaignsFixtures.generateSampleCampaignWithLevelsRange(1, 3);

        LevelProfileMatcher levelProfileMatcher = new LevelProfileMatcher();

        boolean result = levelProfileMatcher.matchPlayerWithCampaign(playerProfile, campaign);

        Assertions.assertFalse(result);
    }

}