package com.cz.demo.data;

import com.cz.demo.domain.PlayerProfile;
import com.cz.demo.domain.exception.PlayerNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
@Qualifier("inMemoryRepository")
public class InMemoryPlayerProfileRepository implements PlayerProfileRepository {
    public static final String EXISTING_PLAYER_ID = "97983be2-98b7-11e7-90cf-082e5f28d836";

    private final HashMap<String, PlayerProfile> repository = new HashMap<>();

    public InMemoryPlayerProfileRepository() {
        PlayerProfile playerProfile = PlayerProfileSeed.generatePlayerProfile(EXISTING_PLAYER_ID);
        save(playerProfile);
    }

    @Override
    public PlayerProfile findById(String playerId) {
        PlayerProfile playerProfile = repository.get(playerId);
        if (playerProfile == null)
            throw new PlayerNotFoundException(playerId);
        return playerProfile;
    }

    @Override
    public void save(PlayerProfile playerProfile) {
        repository.put(playerProfile.getPlayerId(), playerProfile);
    }
}
