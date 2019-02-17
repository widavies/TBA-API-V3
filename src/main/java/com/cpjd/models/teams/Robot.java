package com.cpjd.models.teams;

import com.cpjd.sorting.Sortable;
import com.cpjd.sorting.SortingType;

import java.io.Serializable;

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

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public String getRobotName() {
        return robotName;
    }

    public void setRobotName(String robotName) {
        this.robotName = robotName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTeamKey() {
        return teamKey;
    }

    public void setTeamKey(String teamKey) {
        this.teamKey = teamKey;
    }
}
