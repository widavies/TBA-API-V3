package models.other;

import lombok.Data;

/**
 * Created by Will Davies on 7/7/2017.
 */
public class DistrictRanking {
    private String teamKey;
    private int rank;
    private int rookieBonus;
    private int pointTotal;

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
        private int alliancePoints;
        /**
         * Points awarded for event awards.
         */
        private int awardPoints;
        /**
         * Points awarded for qualification match performance.
         */
        private int qualPoints;
        /**
         * Points awarded for elimination match performance.
         */
        private int elimPoints;
        /**
         * Total points awarded at this event.
         */
        private int total;
    }

}
