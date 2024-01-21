package com.cz.demo.service;

import com.cz.demo.domain.Campaign;
import com.cz.demo.domain.PlayerProfile;
import com.cz.demo.fixtures.CampaignsFixtures;
import com.cz.demo.fixtures.PlayerProfileFixtures;
import com.cz.demo.domain.matchers.ProfileMatcher;
import com.cz.demo.utils.BaseUnitTestClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AllProfileMatchersServiceTest extends BaseUnitTestClass {

    @Mock
    private ProfileMatcher matcher1;

    @Mock
    private ProfileMatcher matcher2;

    private AllProfileMatchersService allProfileMatchersService;

    @BeforeEach
    void setup(){
        allProfileMatchersService = new AllProfileMatchersService(List.of(matcher1, matcher2));
    }

    @Test
    void testMatchPlayerWithCampaignAllMatch() {
        PlayerProfile playerProfile = PlayerProfileFixtures.generateSamplePlayerProfile();
        Campaign campaign = CampaignsFixtures.generateSampleCampaign();

        when(matcher1.matchPlayerWithCampaign(playerProfile, campaign)).thenReturn(true);
        when(matcher2.matchPlayerWithCampaign(playerProfile, campaign)).thenReturn(true);

        // Act
        boolean result = allProfileMatchersService.matchPlayerWithCampaign(playerProfile, campaign);

        // Assert
        assertTrue(result);
        verify(matcher1, times(1)).matchPlayerWithCampaign(playerProfile, campaign);
        verify(matcher2, times(1)).matchPlayerWithCampaign(playerProfile, campaign);
    }

    @Test
    void testMatchPlayerWithCampaignOneFails() {
        PlayerProfile playerProfile = PlayerProfileFixtures.generateSamplePlayerProfile();
        Campaign campaign = CampaignsFixtures.generateSampleCampaign();

        when(matcher1.matchPlayerWithCampaign(playerProfile, campaign)).thenReturn(true);
        when(matcher2.matchPlayerWithCampaign(playerProfile, campaign)).thenReturn(false);

        boolean result = allProfileMatchersService.matchPlayerWithCampaign(playerProfile, campaign);

        assertFalse(result);
        verify(matcher1, times(1)).matchPlayerWithCampaign(playerProfile, campaign);
        verify(matcher2, times(1)).matchPlayerWithCampaign(playerProfile, campaign);
    }

}