package com.cz.demo.data;

import com.cz.demo.domain.Clan;
import com.cz.demo.domain.Device;
import com.cz.demo.domain.Inventory;
import com.cz.demo.domain.PlayerProfile;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class PlayerProfileSeed {

    public static PlayerProfile generatePlayerProfile(String id) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss'Z'").withZone(ZoneId.of("UTC"));

        PlayerProfile playerProfile = new PlayerProfile();
        playerProfile.setPlayerId(id);
        playerProfile.setCredential("apple_credential");
        playerProfile.setCreated(ZonedDateTime.parse("2021-01-10 13:37:17Z", formatter));
        playerProfile.setModified(ZonedDateTime.parse("2021-01-23 13:37:17Z", formatter));
        playerProfile.setLastSession(ZonedDateTime.parse("2021-01-23 13:37:17Z", formatter));
        playerProfile.setTotalSpent(400);
        playerProfile.setTotalRefund(0);
        playerProfile.setTotalTransactions(5);
        playerProfile.setLastPurchase(ZonedDateTime.parse("2021-01-22 13:37:17Z", formatter));
        playerProfile.setActiveCampaigns(new HashSet<>());
        playerProfile.setDevices(Set.of(
                new Device(1, "apple iphone 11", "vodafone", "123")
        ));
        playerProfile.setLevel(3);
        playerProfile.setXp(1000);
        playerProfile.setTotalPlaytime(144);
        playerProfile.setCountry("CA");
        playerProfile.setLanguage("fr");
        playerProfile.setBirthdate(ZonedDateTime.parse("2000-01-10 13:37:17Z", formatter));
        playerProfile.setGender("male");

        // Inventory
        Inventory inventory = new Inventory();
        inventory.setCash(123);
        inventory.setCoins(123);
        inventory.setItems(Collections.singletonMap("item_1", 1));
        playerProfile.setInventory(inventory);

        // Clan
        Clan clan = new Clan();
        clan.setId("123456");
        clan.setName("Hello world clan");
        playerProfile.setClan(clan);

        playerProfile.setCustomField("mycustom");

        return playerProfile;
    }

}
