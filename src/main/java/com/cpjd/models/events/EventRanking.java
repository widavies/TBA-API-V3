package com.cpjd.models.events;

import com.cpjd.sorting.Sortable;
import com.cpjd.sorting.SortingType;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Will Davies on 7/7/2017.
 */
@Data
public class EventRanking extends Sortable<EventRanking> implements Serializable {
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

    @Override
    public int sort(SortingType type, boolean ascending, EventRanking t2) {
        if(type == SortingType.DEFAULT || type == SortingType.RANK) {
            return Long.compare(rank, t2.getRank());
        } else if(type == SortingType.TEAM) {
            return teamKey.compareTo(t2.getTeamKey());
        }

        throw new RuntimeException("Unsupported sort type for model EventRanking.");
    }
}

