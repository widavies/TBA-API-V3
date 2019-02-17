package com.cpjd.models.teams;

import com.cpjd.sorting.Sortable;
import com.cpjd.sorting.SortingType;
import lombok.Data;

import java.io.Serializable;

/**
 * The simple Team model as defined by the V3 TPA api.
 *
 * @since 1.0.0
 * @author Will Davies
 */
@Data
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
}
