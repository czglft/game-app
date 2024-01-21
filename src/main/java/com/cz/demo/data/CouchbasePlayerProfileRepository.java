package com.cz.demo.data;

import com.cz.demo.domain.PlayerProfile;
import com.cz.demo.domain.exception.PlayerNotFoundException;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("couchbaseRepository")
public class CouchbasePlayerProfileRepository implements PlayerProfileRepository {

    public static final String EXISTING_PLAYER_ID = "97983be2-98b7-11e7-90cf-082e5f28d836";
    private final CouchbaseTemplate couchbaseTemplate;

    private final ModelMapper modelMapper;


    @PostConstruct
    public void init() {
        PlayerProfile playerProfile = PlayerProfileSeed.generatePlayerProfile(EXISTING_PLAYER_ID);
        save(playerProfile);
    }

    public CouchbasePlayerProfileRepository(CouchbaseTemplate couchbaseTemplate, ModelMapper modelMapper) {
        this.couchbaseTemplate = couchbaseTemplate;
        this.modelMapper = modelMapper;
    }

    public PlayerProfile findById(String playerId) {
        PlayerProfileDocument playerDocument = couchbaseTemplate.findById(PlayerProfileDocument.class).one(playerId);
        if (playerDocument == null)
            throw new PlayerNotFoundException(playerId);
        return modelMapper.map(playerDocument, PlayerProfile.class);
    }

    public void save(PlayerProfile playerProfile) {
        PlayerProfileDocument playerProfileDocument = modelMapper.map(playerProfile, PlayerProfileDocument.class);
        couchbaseTemplate.save(playerProfileDocument);
    }

}