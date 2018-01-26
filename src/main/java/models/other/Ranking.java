package models.other;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Will Davies on 7/7/2017.
 */
@Data
public class Ranking implements Serializable {
    /**
     * Number of times disqualified.
     */
    private long dq;
    /**
     * Number of matches played by this team.
     */
    private long matchesPlayed;
    /**
     * The average match score during qualifications. Year specific. May be null if not relevant for a given year.
     */
    private double qualAverage;
    /**
     * The team’s rank at the event as provided by FIRST.
     */
    private long rank;
    /**
     *
     Win-Loss-Tie record information, if available. May be null.
     */
    private WLTRecord qualificationsRecord;
    /**
     *
     Win-Loss-Tie record information, if available. May be null.
     */
    private WLTRecord overallRecord;
    /**
     * Additional year-specific information, may be null. See parent `sort_order_info` for details.
     */
    private double[] sortOrders;
    /**
     * The team with this rank.
     */
    private String teamKey;
}

