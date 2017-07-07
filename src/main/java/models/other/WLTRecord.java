package models.other;

import lombok.Data;

/**
 * @since 1.0.0
 * @author Will Davies
 */
@Data
public class WLTRecord {
    /**
     * Number of losses.
     */
    private int losses;
    /**
     * Number of wins.
     */
    private int wins;
    /**
     * Number of ties.
     */
    private int ties;
}
