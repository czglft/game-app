package com.cz.demo.fixtures;

import com.cz.demo.domain.Device;
import com.cz.demo.domain.Inventory;
import com.cz.demo.domain.PlayerProfile;

import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;

public class PlayerProfileFixtures {

    public static PlayerProfile generateSamplePlayerProfile() {
        PlayerProfile playerProfile = new PlayerProfile();
        playerProfile.setPlayerId("97983be2-98b7-11e7-90cf-082e5f28d836");
        playerProfile.setCredential("apple_credential");
        playerProfile.setCreated(ZonedDateTime.now().minusDays(10));
        playerProfile.setModified(ZonedDateTime.now());
        playerProfile.setLastSession(ZonedDateTime.now().minusDays(1));
        playerProfile.setTotalSpent(400);
        playerProfile.setTotalRefund(0);
        playerProfile.setTotalTransactions(5);
        playerProfile.setLastPurchase(ZonedDateTime.now().minusDays(1));
        playerProfile.setActiveCampaigns(Set.of("campaign1", "campaign2"));
        Device device = new Device();
        device.setId(1);
        device.setModel("apple iphone 11");
        device.setCarrier("vodafone");
        device.setFirmware("123");
        playerProfile.setDevices(Set.of(device));
        playerProfile.setLevel(3);
        playerProfile.setXp(1000);
        playerProfile.setTotalPlaytime(144);
        playerProfile.setCountry("CA");
        playerProfile.setLanguage("fr");
        playerProfile.setBirthdate(ZonedDateTime.now().minusYears(20));
        playerProfile.setGender("male");
        Inventory inventory = new Inventory();
        inventory.setCash(123);
        inventory.setCoins(123);
        inventory.setItems(Map.of("item_1", 2));
        playerProfile.setInventory(inventory);
        return playerProfile;
    }


    public static PlayerProfile generateSamplePlayerProfileWithLevel(int level) {
        PlayerProfile profile = generateSamplePlayerProfile();
        profile.setLevel(level);
        return profile;
    }
}
