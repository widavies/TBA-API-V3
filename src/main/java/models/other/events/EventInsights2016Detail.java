package models.other.events;

import lombok.Data;

/**
 * @since 1.0.0
 * @author Will Davies
 */
@Data
public class EventInsights2016Detail {
    /**
     * For the Low Bar - An array with three values, number of times damaged, number of opportunities to damage, and percentage.
     */
    private float[] lowBar;

    /**
     * For the Cheval De Frise - An array with three values, number of times damaged, number of opportunities to damage, and percentage.
     */
    private float[] aChevalDeFrise;
    /**
     * For the Portcullis - An array with three values, number of times damaged, number of opportunities to damage, and percentage.
     */
    private float[] aPortcullis;
    /**
     * For the Ramparts - An array with three values, number of times damaged, number of opportunities to damage, and percentage.
     */
    private float[] bRamparts;
    /**
     * For the Moat - An array with three values, number of times damaged, number of opportunities to damage, and percentage.
     */
    private float[] bMoat;
    /**
     * For the Sally Port - An array with three values, number of times damaged, number of opportunities to damage, and percentage.
     */
    private float[] cSallyPort;
    /**
     * For the Drawbridge - An array with three values, number of times damaged, number of opportunities to damage, and percentage.
     */
    private float[] cDrawbridge;
    /**
     * For the Rough Terrain - An array with three values, number of times damaged, number of opportunities to damage, and percentage.
     */
    private float[] dRoughTerrain;
    /**
     * For the Rock Wall - An array with three values, number of times damaged, number of opportunities to damage, and percentage.
     */
    private float[] dRockwall;
    /**
     * Average number of high goals scored.
     */
    private float averageHighGoals;
    /**
     * Average number of low goals scored.
     */
    private float averageLowGoals;
    /**
     * An array with three values, number of times breached, number of opportunities to breech, and percentage.
     */
    private float[] breaches;
    /**
     * An array with three values, number of times scaled, number of opportunities to scale, and percentage.
     */
    private float[] scales;
    /**
     * An array with three values, number of times challenged, number of opportunities to challenge, and percentage.
     */
    private float[] challenges;
    /**
     * An array with three values, number of times captured, number of opportunities to capture, and percentage.
     */
    private float[] captures;
    /**
     * Average winning score.
     */
    private float averageWinScore;
    /**
     * Average margin of victory.
     */
    private float averageWinMargin;
    /**
     * Average total score.
     */
    private float averageScore;
    /**
     * Average autonomous score.
     */
    private float averageAutoScore;
    /**
     * Average crossing score.
     */
    private float averageCrossingScore;
    /**
     * Average boulder score.
     */
    private float averageBoulderScore;
    /**
     * Average tower score.
     */
    private float averageTowerScore;
    /**
     * Average foul score.
     */
    private float averageFoulScore;

    /**
     * An array with three values, high score, match key from the match with the high score, and the name of the match.
     */
    private String[] highScore;
}
