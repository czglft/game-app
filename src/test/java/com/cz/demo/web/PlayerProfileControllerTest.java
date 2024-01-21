package com.cz.demo.web;

import com.cz.demo.domain.PlayerProfile;
import com.cz.demo.domain.exception.PlayerNotFoundException;
import com.cz.demo.fixtures.PlayerProfileFixtures;
import com.cz.demo.service.GameService;
import com.cz.demo.utils.BaseUnitTestClass;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class PlayerProfileControllerTest extends BaseUnitTestClass {

    @Mock
    private GameService gameService;

    @InjectMocks
    private PlayerProfileController playerProfileController;

    @Test
    void testGetClientConfig_Success() {
        String playerId = "123";
        PlayerProfile mockUpdatedProfile = PlayerProfileFixtures.generateSamplePlayerProfile();
        when(gameService.matchAndApplyCampaign(playerId)).thenReturn(mockUpdatedProfile);

        ResponseEntity<PlayerProfile> responseEntity = playerProfileController.getClientConfig(playerId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockUpdatedProfile, responseEntity.getBody());
        verify(gameService, times(1)).matchAndApplyCampaign(playerId);
    }

    @Test
    void testGetClientConfig_PlayerNotFoundException() {
        String playerId = "456";
        when(gameService.matchAndApplyCampaign(playerId)).thenThrow(new PlayerNotFoundException(playerId));

        assertThrows(PlayerNotFoundException.class, () -> playerProfileController.getClientConfig(playerId));
    }

}