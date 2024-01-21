package com.cz.demo.domain.matchers;

import com.cz.demo.domain.Campaign;
import com.cz.demo.domain.ListMatcherSpec;
import com.cz.demo.domain.PlayerProfile;
import org.springframework.stereotype.Component;

@Component
public class ListIncludeProfileMatcher implements ProfileMatcher {
    @Override
    public boolean matchPlayerWithCampaign(PlayerProfile playerProfile, Campaign campaign) {
        ListMatcherSpec specsToBeIncluded = campaign.getMatchers().getHas();
        boolean countryMatches = specsToBeIncluded.getCountry().isEmpty() || specsToBeIncluded.getCountry().contains(playerProfile.getCountry());
        boolean playerHasAllItemsNeededForCampaign = isPlayerHasAllItemsNeededForCampaign(playerProfile, specsToBeIncluded);
        return countryMatches && (specsToBeIncluded.getItems().isEmpty() || playerHasAllItemsNeededForCampaign);
    }

    private static boolean isPlayerHasAllItemsNeededForCampaign(PlayerProfile playerProfile, ListMatcherSpec specsToBeIncluded) {
        return playerProfile.getInventory().getItems().keySet().containsAll(specsToBeIncluded.getItems());
    }
}
