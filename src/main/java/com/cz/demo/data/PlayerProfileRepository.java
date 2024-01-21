package com.cz.demo.data;

import com.cz.demo.domain.PlayerProfile;

public interface PlayerProfileRepository {

    PlayerProfile findById(String playerId);

    void save(PlayerProfile playerProfile);
}
