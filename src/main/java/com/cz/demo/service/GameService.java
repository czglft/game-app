package com.cz.demo.service;

import com.cz.demo.domain.PlayerProfile;

public interface GameService {

    PlayerProfile matchAndApplyCampaign(String playerId);
}
