package com.cz.demo.domain.matchers;

import com.cz.demo.domain.Campaign;
import com.cz.demo.domain.ListMatcherSpec;
import com.cz.demo.domain.PlayerProfile;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ListExcludeProfileMatcher implements ProfileMatcher {
    @Override
    public boolean matchPlayerWithCampaign(PlayerProfile playerProfile, Campaign campaign) {
        ListMatcherSpec specsToBeExcluded = campaign.getMatchers().getDoesNotHave();
        boolean doesNotHaveCountry = !specsToBeExcluded.getCountry().contains(playerProfile.getCountry());
        boolean doesNotHaveAnyForbiddenItem = isDoesNotHaveAnyForbiddenItem(playerProfile, specsToBeExcluded);
        return doesNotHaveCountry && doesNotHaveAnyForbiddenItem;
    }

    private boolean isDoesNotHaveAnyForbiddenItem(PlayerProfile playerProfile, ListMatcherSpec specsToBeExcluded) {
        return areDisjoint(specsToBeExcluded.getItems(), playerProfile.getInventory().getItems().keySet());
    }

    public boolean areDisjoint(Set<String> set1, Set<String> set2) {
        Set<String> commonElements = new HashSet<>(set1);
        commonElements.retainAll(set2);

        return commonElements.isEmpty();
    }
}
