package com.cz.demo.service;

import com.cz.demo.domain.Campaign;
import com.cz.demo.domain.PlayerProfile;

public interface ProfileMatchersService {

    boolean matchPlayerWithCampaign(PlayerProfile playerProfile, Campaign campaign);
}
