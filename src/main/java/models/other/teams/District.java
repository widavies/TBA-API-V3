package models.other.teams;

import lombok.Data;

/**
 * @since 1.0.0
 * @author Will Davies
 */
@Data
public class District {
    /**
     * The short identifier for the district.
     */
    private String abbreviation;
    /**
     * The long name for the district.
     */
    private String displayName;
    /**
     * Key for this district, e.g. 2016ne.
     */
    private String key;
    /**
     * Year this district participated.
     */
    private long year;

}
