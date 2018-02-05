package com.cpjd.models.other;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Will Davies on 7/7/2017.
 */
public class DistrictRanking implements Serializable {
    private String teamKey;
    private long rank;
    private long rookieBonus;
    private long pointTotal;

    /**
     * List of events that contributed to the point total for the team.
     */
    private EventPoint[] eventPoints;

    @Data
    private class EventPoint {
        /**
         * TBA Event key for this event.
         */
        private String eventKey;
        /**
         * true if this event is a District Championship event.
         */
        private boolean districtCmp;
        /**
         * Points awarded for alliance selection.
         */
        private long alliancePoints;
        /**
         * Points awarded for event awards.
         */
        private long awardPoints;
        /**
         * Points awarded for qualification match performance.
         */
        private long qualPoints;
        /**
         * Points awarded for elimination match performance.
         */
        private long elimPoints;
        /**
         * Total points awarded at this event.
         */
        private long total;
    }

}
