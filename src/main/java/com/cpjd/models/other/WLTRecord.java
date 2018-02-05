package com.cpjd.models.other;

import lombok.Data;

import java.io.Serializable;

/**
 * @since 1.0.0
 * @author Will Davies
 */
@Data
public class WLTRecord implements Serializable {
    /**
     * Number of losses.
     */
    private long losses;
    /**
     * Number of wins.
     */
    private long wins;
    /**
     * Number of ties.
     */
    private long ties;
}
