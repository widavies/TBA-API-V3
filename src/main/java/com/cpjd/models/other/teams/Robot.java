package com.cpjd.models.other.teams;

import lombok.Data;

import java.io.Serializable;

@Data
public class Robot implements Serializable {
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

}
