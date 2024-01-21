package com.cz.demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
public class PlayerProfile {
    private String playerId;
    private String credential;

    private ZonedDateTime created;
    private ZonedDateTime modified;
    private ZonedDateTime lastSession;
    private int totalSpent;
    private int totalRefund;
    private int totalTransactions;
    private ZonedDateTime lastPurchase;
    private Set<String> activeCampaigns;
    private Set<Device> devices;
    private int level;
    private int xp;
    private int totalPlaytime;
    private String country;
    private String language;
    private ZonedDateTime birthdate;
    private String gender;
    private Inventory inventory = new Inventory();
    private Clan clan;
    private String customField;


}
