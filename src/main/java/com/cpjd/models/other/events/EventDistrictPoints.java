package com.cpjd.models.other.events;

import lombok.Data;

import java.util.HashMap;

/**
 * @since 1.0.0
 * @author Will Davies
 */
@Data
public class EventDistrictPoints {

    /**
     * Points gained for each team at the event. Stored as a key-value pair with the team key as the key, and an object describing the points as it’s value.
     */
    private HashMap<String, Object> points;

    /**
     * Tiebreaker values for each team at the event. Stored as a key-value pair with the team key as the key, and an object describing the tiebreaker elements as it’s value
     */
    private HashMap<String, Object> tiebreakers;


}
