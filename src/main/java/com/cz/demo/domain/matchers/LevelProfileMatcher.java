package com.cz.demo.domain.matchers;

import com.cz.demo.domain.Campaign;
import com.cz.demo.domain.CampaignLevelMatcherSpec;
import com.cz.demo.domain.PlayerProfile;
import org.springframework.stereotype.Component;

@Component
public class LevelProfileMatcher implements ProfileMatcher {
    @Override
    public boolean matchPlayerWithCampaign(PlayerProfile playerProfile, Campaign campaign) {
        int playerLevel = playerProfile.getLevel();
        CampaignLevelMatcherSpec levelMatcher = campaign.getMatchers().getLevel();
        return playerLevel >= levelMatcher.getMin() &&
                playerLevel <= levelMatcher.getMax();
    }
}
