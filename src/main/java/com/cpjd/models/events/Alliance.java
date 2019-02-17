package com.cpjd.models.events;

import com.cpjd.sorting.Sortable;
import com.cpjd.sorting.SortingType;
import lombok.Data;

@Data
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
}
