package models.simple;

import lombok.Data;

import java.io.Serializable;

/**
 * The simple Team model as defined by the V3 TPA api.
 *
 * @since 1.0.0
 * @author Will Davies
 */
@Data
public class STeam implements Serializable {
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

}
