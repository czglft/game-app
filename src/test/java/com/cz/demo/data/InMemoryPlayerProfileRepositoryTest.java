package com.cz.demo.data;

import com.cz.demo.domain.PlayerProfile;
import com.cz.demo.domain.exception.PlayerNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.cz.demo.data.InMemoryPlayerProfileRepository.EXISTING_PLAYER_ID;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InMemoryPlayerProfileRepositoryTest {
    private InMemoryPlayerProfileRepository playerProfileRepository;

    @BeforeEach
    void setUp() {
        playerProfileRepository = new InMemoryPlayerProfileRepository();
    }

    @Test
    void findById_ExistingPlayerId_ShouldReturnPlayerProfile() {
        // Act
        PlayerProfile result = playerProfileRepository.findById(EXISTING_PLAYER_ID);

        // Assert
        assertNotNull(result);
        Assertions.assertEquals(EXISTING_PLAYER_ID, result.getPlayerId());
    }

    @Test
    void findById_NonExistingPlayerId_ShouldThrowPlayerNotFoundException() {
        // Arrange
        String nonExistingPlayerId = "NON_EXISTING_PLAYER_ID";

        // Act and Assert
        assertThrows(PlayerNotFoundException.class, () -> playerProfileRepository.findById(nonExistingPlayerId));
    }

    @Test
    void save_ShouldSavePlayerProfile() {
        // Arrange
        PlayerProfile playerProfile = new PlayerProfile();
        playerProfile.setPlayerId("NEW_PLAYER_ID");

        // Act
        playerProfileRepository.save(playerProfile);

        // Assert
        PlayerProfile savedProfile = playerProfileRepository.findById("NEW_PLAYER_ID");
        assertNotNull(savedProfile);
        Assertions.assertEquals(playerProfile.getPlayerId(), savedProfile.getPlayerId());
    }
}