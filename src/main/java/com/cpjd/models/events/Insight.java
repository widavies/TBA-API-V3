package com.cpjd.models.events;

import java.util.HashMap;

public class Insight {

    /**
     * These are year specific, so it's up to you to determine what you'd like to fetch.
     *
     */

    private HashMap<String, Object> qual;
    private HashMap<String, Object> playoff;

    public HashMap<String, Object> getQual() {
        return qual;
    }

    public void setQual(HashMap<String, Object> qual) {
        this.qual = qual;
    }

    public HashMap<String, Object> getPlayoff() {
        return playoff;
    }

    public void setPlayoff(HashMap<String, Object> playoff) {
        this.playoff = playoff;
    }
}
