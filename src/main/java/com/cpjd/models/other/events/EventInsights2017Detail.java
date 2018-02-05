package com.cpjd.models.other.events;

import lombok.Data;

/**
 *
 * @since 1.0.0
 * @author Will Davies
 */
@Data
public class EventInsights2017Detail {
    /**
     * Average foul score.
     */
    private float averageFoulScore;
    /**
     * Average fuel points scored.
     */
    private float averageFuelPoints;
    /**
     * Average fuel points scored during auto.
     */
    private float averageFuelPointsAuto;
    /**
     * Average fuel points scored during teleop.
     */
    private float averageFuelPointsTeleop;
    /**
     * Average points scored in the high goal.
     */
    private float averageHighGoals;
    /**
     * Average points scored in the high goal during auto.
     */
    private float averageHighGoalsAuto;
    /**
     * Average points scored in the high goal during teleop.
     */
    private float averageHighGoalsTeleop;
    /**
     * Average points scored in the low goal.
     */
    private float averageLowGoals;
    /**
     * Average points scored in the low goal during auto.
     */
    private float averageLowGoalsAuto;
    /**
     * Average points scored in the low goal during teleop.
     */
    private float averageLowGoalsTeleop;
    /**
     * Average mobility points scored during auto.
     */
    private float averageMobilityPointsAuto;
    /**
     * Average points scored during auto.
     */
    private float averagePointsAuto;
    /**
     * Average points scored during teleop.
     */
    private float averagePointsTeleop;
    /**
     * Average rotor points scored
     */
    private float averageRotorPoints;
    /**
     * Average rotor points scored during auto.
     */
    private float averageRotorPointsAuto;
    /**
     * Average rotor points scored during teleop.
     */
    private float averageRotorPointsTeleop;
    /**
     * Average score.
     */
    private float averageScore;
    /**
     * Average takeoff points scored during teleop.
     */
    private float averageTakeoffPointsTeleop;
    /**
     * Average margin of victory.
     */
    private float averageWinMargin;
    /**
     * Average winning score.
     */
    private float averageWinScore;
    /**
     * An array with three values, kPa scored, match key from the match with the high kPa, and the name of the match
     */
    private String[] highKpa;
    /**
     * An array with three values, high score, match key from the match with the high score, and the name of the match
     */
    private String[] highScore;
    /**
     * An array with three values, number of times kPa bonus achieved, number of opportunities to bonus, and percentage.
     */
    private float[] kpaAchieved;
    /**
     * An array with three values, number of times mobility bonus achieved, number of opportunities to bonus, and percentage.
     */
    private float[] mobilityCounts;
    /**
     * An array with three values, number of times rotor 1 engaged, number of opportunities to engage, and percentage.
     */
    private float[] rotor1Engaged;
    /**
     * An array with three values, number of times rotor 1 engaged in auto, number of opportunities to engage in auto, and percentage.
     */
    private float[] rotor1EngagedAuto;
    /**
     * An array with three values, number of times rotor 2 engaged, number of opportunities to engage, and percentage.
     */
    private float[] rotor2Engaged;
    /**
     * An array with three values, number of times rotor 2 engaged in auto, number of opportunities to engage in auto, and percentage.
     */
    private float[] rotor2EngagedAuto;
    /**
     * An array with three values, number of times rotor 3 engaged, number of opportunities to engage, and percentage.
     */
    private float[] rotor3Engaged;
    /**
     * An array with three values, number of times rotor 4 engaged, number of opportunities to engage, and percentage.
     */
    private float[] rotor4Engaged;
    /**
     * An array with three values, number of times takeoff was counted, number of opportunities to takeoff, and percentage.
     */
    private float[] takeoffCounts;

}
