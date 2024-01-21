package com.cz.demo.service;

import com.cz.demo.data.PlayerProfileRepository;
import com.cz.demo.domain.PlayerProfile;
import com.cz.demo.utils.BaseUnitTestClass;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class PlayerProfileServiceImplTest extends BaseUnitTestClass {

    @Mock
    private PlayerProfileRepository playerProfileRepository;

    @InjectMocks
    private PlayerProfileServiceImpl playerProfileService;


    @Test
    void testGetPlayerProfile() {
        // Arrange
        String playerId = "somePlayerId";
        PlayerProfile expectedProfile = new PlayerProfile(); // Create a dummy profile for testing
        when(playerProfileRepository.findById(playerId)).thenReturn(expectedProfile);

        // Act
        PlayerProfile actualProfile = playerProfileService.getPlayerProfile(playerId);

        // Assert
        assertNotNull(actualProfile);
        assertEquals(expectedProfile, actualProfile);
        verify(playerProfileRepository, times(1)).findById(playerId);
    }

    @Test
    void testUpdatePlayerProfile() {
        // Arrange
        PlayerProfile playerProfile = new PlayerProfile(); // Create a dummy profile for testing

        // Act
        playerProfileService.updatePlayerProfile(playerProfile);

        // Assert
        verify(playerProfileRepository, times(1)).save(playerProfile);
    }
}