package com.cpjd.models.other;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Will Davies on 7/7/2017.
 */
@Data
public class EventRanking implements Serializable {
    /**
     * The team with this rank.
     */
    private String teamKey;
    /**
     * Number of times disqualified.
     */
    private long dq;

    private long[] extraStats;
    private long qualAverage;
    private long matchesPlayed;
    private double[] sortOrders;
    private long wins, ties, losses;
    private long rank;

}

