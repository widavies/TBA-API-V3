package models.other;

import lombok.Data;

import java.io.Serializable;

/**
 * @since 1.0.0
 * @author Will Davies
 */
@Data
public class District implements Serializable {
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
