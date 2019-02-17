package com.cpjd.models.events;

import lombok.Data;

import java.util.HashMap;

@Data
public class Insight {

    /**
     * These are year specific, so it's up to you to determine what you'd like to fetch.
     *
     */

    private HashMap<String, Object> qual;
    private HashMap<String, Object> playoff;

}
