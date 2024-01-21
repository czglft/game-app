package com.cz.demo.integration;

import com.cz.demo.domain.PlayerProfile;
import com.cz.demo.domain.exception.PlayerNotFoundException;
import com.cz.demo.fixtures.PlayerProfileFixtures;
import com.cz.demo.service.GameService;
import com.cz.demo.web.PlayerProfileController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PlayerProfileController.class)
public class PlayerProfileMockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GameService gameService;


    @Test
    void testGetClientConfig_Success() throws Exception {
        String playerId = "123";
        PlayerProfile mockUpdatedProfile = PlayerProfileFixtures.generateSamplePlayerProfile();
        when(gameService.matchAndApplyCampaign(playerId)).thenReturn(mockUpdatedProfile);

        mockMvc.perform(get("/game/get_client_config/{player_id}", playerId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.playerId").exists()) // Adjust based on your PlayerProfile structure
                .andExpect(jsonPath("$.playerId").value(mockUpdatedProfile.getPlayerId()));

        verify(gameService, times(1)).matchAndApplyCampaign(playerId);
    }

    @Test
    void testGetClientConfig_PlayerNotFoundException() throws Exception {
        String playerId = "456";
        when(gameService.matchAndApplyCampaign(playerId)).thenThrow(new PlayerNotFoundException(playerId));

        mockMvc.perform(get("/game/get_client_config/{player_id}", playerId))
                .andExpect(status().isNotFound())
                .andExpect(content().string(String.format("Player with id %s not found", playerId)));

        verify(gameService, times(1)).matchAndApplyCampaign(playerId);
    }
}
