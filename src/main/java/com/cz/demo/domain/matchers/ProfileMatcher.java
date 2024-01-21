package com.cz.demo.domain.matchers;


import com.cz.demo.domain.Campaign;
import com.cz.demo.domain.PlayerProfile;

public interface ProfileMatcher {
    boolean matchPlayerWithCampaign(PlayerProfile playerProfile, Campaign campaign);

}
