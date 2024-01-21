package com.cz.demo.service;

import com.cz.demo.domain.PlayerProfile;

public interface PlayerProfileService {
    PlayerProfile getPlayerProfile(String playerId);

    void updatePlayerProfile(PlayerProfile playerProfile);
}
