package com.cpjd.models.teams;

import com.cpjd.sorting.Sortable;
import com.cpjd.sorting.SortingType;
import lombok.Data;

import java.io.Serializable;

@Data
public class Robot extends Sortable<Robot> implements Serializable {
    /**
     * Year this robot competed in.
     */
    private long year;
    /**
     * Name of the robot as provided by the team.
     */
    private String robotName;
    /**
     * Internal TBA identifier for this robot.
     */
    private String key;
    /**
     * TBA team key for this robot.
     */
    private String teamKey;

    @Override
    public int sort(SortingType type, boolean ascending, Robot t2) {
        if(type == SortingType.DEFAULT || type == SortingType.DATE) {
            return Long.compare(year, t2.getYear());
        }

        throw new RuntimeException("Unsupported sort type for model robot.");
    }
}
