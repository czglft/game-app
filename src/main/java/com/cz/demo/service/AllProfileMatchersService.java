package com.cz.demo.service;

import com.cz.demo.domain.Campaign;
import com.cz.demo.domain.PlayerProfile;
import com.cz.demo.domain.matchers.ProfileMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllProfileMatchersService implements ProfileMatchersService {

    private final List<ProfileMatcher> profileMatchers;

    public AllProfileMatchersService(List<ProfileMatcher> profileMatchers) {
        this.profileMatchers = profileMatchers;
    }

    @Override
    public boolean matchPlayerWithCampaign(PlayerProfile playerProfile, Campaign campaign) {
        // Iterate through registered profile matchers
        for (ProfileMatcher matcher : profileMatchers) {
            if (!matcher.matchPlayerWithCampaign(playerProfile, campaign)) {
                return false; // Fail fast if any matcher doesn't match
            }
        }
        return true; // All matchers passed
    }
}
