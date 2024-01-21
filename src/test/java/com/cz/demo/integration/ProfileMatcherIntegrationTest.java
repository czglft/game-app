package com.cz.demo.integration;

import com.cz.demo.data.CouchbasePlayerProfileRepository;
import com.cz.demo.data.PlayerProfileSeed;
import com.cz.demo.domain.PlayerProfile;
import com.cz.demo.service.GameService;
import com.cz.demo.service.PlayerProfileService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.couchbase.core.CouchbaseTemplate;

import static com.cz.demo.service.CampaignMockedService.MOCK_CAMPAIGN_MAX_LEVEL;
import static com.cz.demo.service.CampaignMockedService.MOCK_CAMPAIGN_NAME;

@SpringBootTest
public class ProfileMatcherIntegrationTest {

    @Autowired
    private CouchbasePlayerProfileRepository playerProfileRepository;

    @Autowired
    private PlayerProfileService playerProfileService;


    @Autowired
    private GameService gameService;

    @Autowired
    private CouchbaseTemplate couchbaseTemplate;

    @BeforeEach
    void setup() {
        getFlushBucket();
    }

    @AfterEach
    void teardown() {
        getFlushBucket();
    }

    private void getFlushBucket() {
        couchbaseTemplate.getCouchbaseClientFactory().getCluster().buckets().flushBucket("players");
    }

    @Test
    void testMatchOkayAndApplyCampaign() {
        // Prepopulate the database
        String playerId = "player_id";
        PlayerProfile playerProfile = PlayerProfileSeed.generatePlayerProfile(playerId);
        playerProfile.setLevel(MOCK_CAMPAIGN_MAX_LEVEL - 1);
        int activeCampaigns = playerProfile.getActiveCampaigns().size();
        Assertions.assertEquals(0, activeCampaigns);
        playerProfileRepository.save(playerProfile);

        // Perform the matching with a new campaign using the services
        PlayerProfile updatedProfile = gameService.matchAndApplyCampaign(playerId);

        // Assertions
        Assertions.assertEquals(1, updatedProfile.getActiveCampaigns().size());
        Assertions.assertTrue(updatedProfile.getActiveCampaigns().contains(MOCK_CAMPAIGN_NAME));
        Assertions.assertEquals(playerProfile.getPlayerId(), updatedProfile.getPlayerId());
    }

    @Test
    void testMatchNotOkaySoDontApplyCampaign() {
        String playerId = "player_id";
        PlayerProfile playerProfile = PlayerProfileSeed.generatePlayerProfile(playerId);
        playerProfile.setLevel(MOCK_CAMPAIGN_MAX_LEVEL + 1);
        int activeCampaigns = playerProfile.getActiveCampaigns().size();
        Assertions.assertEquals(0, activeCampaigns);
        playerProfileRepository.save(playerProfile);

        // Perform the matching with a new campaign using the services
        PlayerProfile updatedProfile = gameService.matchAndApplyCampaign(playerId);


        // number of campaigns stays the same
        activeCampaigns = playerProfile.getActiveCampaigns().size();
        Assertions.assertEquals(0, activeCampaigns);
    }


}
