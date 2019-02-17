package com.cpjd.models.districts;

import com.cpjd.sorting.Sortable;
import com.cpjd.sorting.SortingType;

import java.io.Serializable;

/**
 * @since 1.0.0
 * @author Will Davies
 */
public class District extends Sortable<District> implements Serializable {
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

    @Override
    public int sort(SortingType type, boolean ascending, District t2) {
        if(type == SortingType.DEFAULT || type == SortingType.DATE) {
            return Long.compare(year, t2.getYear());
        } else if(type == SortingType.NAME) {
            return displayName.compareTo(t2.getDisplayName());
        }

        throw new RuntimeException("Unsupported sort type for model District.");
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }
}
