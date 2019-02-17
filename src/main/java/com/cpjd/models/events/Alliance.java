package com.cpjd.models.events;

import com.cpjd.sorting.Sortable;
import com.cpjd.sorting.SortingType;

public class Alliance extends Sortable<Alliance> {

    private String name;
    private String backupOut;
    private String backupIn;
    private String[] declines;
    private String[] picks;
    
    /*
     * Status
     */
    private String status;
    private long currentLevelRecord_Losses;
    private long currentLevelRecord_Wins;
    private long currentLevelRecord_Ties;
    private String level;
    private double playoffAverage;
    private long recordLosses;
    private long recordWins;
    private long recordTies;

    @Override
    public int sort(SortingType type, boolean ascending, Alliance t2) {
        if(type == SortingType.DEFAULT || type == SortingType.NAME) {
            return name.compareTo(t2.getName());
        }
        
        throw new RuntimeException("Unsupported sort type for model Alliance");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBackupOut() {
        return backupOut;
    }

    public void setBackupOut(String backupOut) {
        this.backupOut = backupOut;
    }

    public String getBackupIn() {
        return backupIn;
    }

    public void setBackupIn(String backupIn) {
        this.backupIn = backupIn;
    }

    public String[] getDeclines() {
        return declines;
    }

    public void setDeclines(String[] declines) {
        this.declines = declines;
    }

    public String[] getPicks() {
        return picks;
    }

    public void setPicks(String[] picks) {
        this.picks = picks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getCurrentLevelRecord_Losses() {
        return currentLevelRecord_Losses;
    }

    public void setCurrentLevelRecord_Losses(long currentLevelRecord_Losses) {
        this.currentLevelRecord_Losses = currentLevelRecord_Losses;
    }

    public long getCurrentLevelRecord_Wins() {
        return currentLevelRecord_Wins;
    }

    public void setCurrentLevelRecord_Wins(long currentLevelRecord_Wins) {
        this.currentLevelRecord_Wins = currentLevelRecord_Wins;
    }

    public long getCurrentLevelRecord_Ties() {
        return currentLevelRecord_Ties;
    }

    public void setCurrentLevelRecord_Ties(long currentLevelRecord_Ties) {
        this.currentLevelRecord_Ties = currentLevelRecord_Ties;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public double getPlayoffAverage() {
        return playoffAverage;
    }

    public void setPlayoffAverage(double playoffAverage) {
        this.playoffAverage = playoffAverage;
    }

    public long getRecordLosses() {
        return recordLosses;
    }

    public void setRecordLosses(long recordLosses) {
        this.recordLosses = recordLosses;
    }

    public long getRecordWins() {
        return recordWins;
    }

    public void setRecordWins(long recordWins) {
        this.recordWins = recordWins;
    }

    public long getRecordTies() {
        return recordTies;
    }

    public void setRecordTies(long recordTies) {
        this.recordTies = recordTies;
    }
}
