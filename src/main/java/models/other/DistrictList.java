package models.other;

import lombok.Data;

/**
 * @since 1.0.0
 * @author Will Davies
 */
@Data
public class DistrictList {
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
    private int year;

}
