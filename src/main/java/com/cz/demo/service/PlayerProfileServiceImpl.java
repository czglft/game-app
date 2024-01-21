package com.cz.demo.service;

import com.cz.demo.data.PlayerProfileRepository;
import com.cz.demo.domain.PlayerProfile;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PlayerProfileServiceImpl implements PlayerProfileService {


    private final PlayerProfileRepository playerProfileRepository;

    public PlayerProfileServiceImpl(@Qualifier("couchbaseRepository") PlayerProfileRepository playerProfileRepository) {
        this.playerProfileRepository = playerProfileRepository;
    }

    public PlayerProfile getPlayerProfile(String playerId) {
        return playerProfileRepository.findById(playerId);
    }

    public void updatePlayerProfile(PlayerProfile playerProfile) {
        playerProfileRepository.save(playerProfile);
    }
}
