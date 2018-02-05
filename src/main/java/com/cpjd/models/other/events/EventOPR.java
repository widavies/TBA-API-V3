package com.cpjd.models.other.events;

import lombok.Data;

import java.io.Serializable;

/**
 * OPR, DPR, and CCWM for a single team
 * @since 1.0.0
 * @author Will Davies
 */
@Data
public class EventOPR implements Serializable {
    /**
     * The team's key
     */
    private String teamKey;
    /**
     * The team's opr
     */
    private double opr;
    /**
     * The team's dpr
     */
    private double dpr;
    /**
     * The team's ccwm
     */
    private double ccwm;

}
