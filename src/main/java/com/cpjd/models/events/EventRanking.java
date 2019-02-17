package com.cpjd.models.events;

import com.cpjd.sorting.Sortable;
import com.cpjd.sorting.SortingType;

import java.io.Serializable;

/**
 * Created by Will Davies on 7/7/2017.
 */
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

    public String getTeamKey() {
        return teamKey;
    }

    public void setTeamKey(String teamKey) {
        this.teamKey = teamKey;
    }

    public long getDq() {
        return dq;
    }

    public void setDq(long dq) {
        this.dq = dq;
    }

    public long[] getExtraStats() {
        return extraStats;
    }

    public void setExtraStats(long[] extraStats) {
        this.extraStats = extraStats;
    }

    public long getQualAverage() {
        return qualAverage;
    }

    public void setQualAverage(long qualAverage) {
        this.qualAverage = qualAverage;
    }

    public long getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(long matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public double[] getSortOrders() {
        return sortOrders;
    }

    public void setSortOrders(double[] sortOrders) {
        this.sortOrders = sortOrders;
    }

    public long getWins() {
        return wins;
    }

    public void setWins(long wins) {
        this.wins = wins;
    }

    public long getTies() {
        return ties;
    }

    public void setTies(long ties) {
        this.ties = ties;
    }

    public long getLosses() {
        return losses;
    }

    public void setLosses(long losses) {
        this.losses = losses;
    }

    public long getRank() {
        return rank;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }
}

