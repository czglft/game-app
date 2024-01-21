package com.cz.demo.service;

import com.cz.demo.domain.Campaign;
import com.cz.demo.domain.PlayerProfile;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class GameServiceImpl implements GameService {

    private final PlayerProfileService playerProfileService;

    private final CampaignService campaignService;

    private final AllProfileMatchersService matcherService;

    public GameServiceImpl(PlayerProfileService playerProfileService, CampaignService campaignService, AllProfileMatchersService matcherService) {
        this.playerProfileService = playerProfileService;
        this.campaignService = campaignService;
        this.matcherService = matcherService;
    }


    @Override
    public PlayerProfile matchAndApplyCampaign(String playerId) {
        PlayerProfile playerProfile = playerProfileService.getPlayerProfile(playerId);
        playerProfile.setModified(ZonedDateTime.now());
        playerProfile.setLastSession(ZonedDateTime.now());

        Campaign currentCampaign = campaignService.getCurrentCampaignData();

        if (matcherService.matchPlayerWithCampaign(playerProfile, currentCampaign)) {
            playerProfile.getActiveCampaigns().add(currentCampaign.getName());
        }

        playerProfileService.updatePlayerProfile(playerProfile);
        return playerProfile;
    }
}
