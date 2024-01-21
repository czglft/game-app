package com.cz.demo.web;

import com.cz.demo.domain.PlayerProfile;
import com.cz.demo.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class PlayerProfileController {

    private final GameService gameService;

    public PlayerProfileController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/get_client_config/{player_id}")
    public ResponseEntity<PlayerProfile> getClientConfig(@PathVariable String player_id) {
        PlayerProfile updatedProfile = gameService.matchAndApplyCampaign(player_id);
        return ResponseEntity.ok(updatedProfile);
    }
}
