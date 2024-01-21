package com.cz.demo.data;
import com.cz.demo.domain.Clan;
import com.cz.demo.domain.Device;
import com.cz.demo.domain.Inventory;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;


import java.util.List;

@Document
@Data
public class PlayerProfileDocument {

    @Id
    private String playerId;

    @Field
    private String credential;

    @Field
    private String created;

    @Field
    private String modified;

    @Field
    private String lastSession;

    @Field
    private int totalSpent;

    @Field
    private int totalRefund;

    @Field
    private int totalTransactions;

    @Field
    private String lastPurchase;

    @Field
    private List<String> activeCampaigns;

    @Field
    private List<Device> devices;

    @Field
    private int level;

    @Field
    private int xp;

    @Field
    private int totalPlaytime;

    @Field
    private String country;

    @Field
    private String language;

    @Field
    private String birthdate;

    @Field
    private String gender;

    @Field
    private Inventory inventory;

    @Field
    private Clan clan;

    @Field
    private String customField;
}
