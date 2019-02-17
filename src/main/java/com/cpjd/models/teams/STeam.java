package com.cpjd.models.teams;

import com.cpjd.sorting.Sortable;
import com.cpjd.sorting.SortingType;

import java.io.Serializable;

/**
 * The simple Team model as defined by the V3 TPA api.
 *
 * @since 1.0.0
 * @author Will Davies
 */
public class STeam extends Sortable<STeam> implements Serializable {
    /**
     * TBA team key with the format frcXXXX with XXXX representing the team number.
     */
    private String key;
    /**
     * Official team number issued by FIRST.
     */
    private long teamNumber;
    /**
     * Team nickname provided by FIRST.
     */
    private String nickname;
    /**
     * Official long name registered with FIRST.
     */
    private String name;
    /**
     * City of team derived from parsing the address registered with FIRST.
     */
    private String city;
    /**
     * State of team derived from parsing the address registered with FIRST.
     */
    private String stateProv;
    /**
     * Country of team derived from parsing the address registered with FIRST.
     */
    private String country;

    @Override
    public int sort(SortingType type, boolean ascending, STeam t2) {
        if(type == SortingType.DEFAULT || type == SortingType.NUMBER) {
            return Long.compare(teamNumber, t2.getTeamNumber());
        }

        throw new RuntimeException("Unsupported sort type for team model.");
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(long teamNumber) {
        this.teamNumber = teamNumber;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProv() {
        return stateProv;
    }

    public void setStateProv(String stateProv) {
        this.stateProv = stateProv;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
