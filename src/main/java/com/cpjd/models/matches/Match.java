package com.cpjd.models.matches;

import com.cpjd.models.events.Media;

import java.util.HashMap;

/**
 * @since 1.0.0
 * @author Will Davies
 */

public class Match extends SMatch {
    /**
     * UNIX timestamp (seconds since 1-Jan-1970 00:00:00) when the match result was posted.
     */
    private long postResultTime;
    /**
     *
     Score breakdown for auto, teleop, etc. points. Varies from year to year. May be null.

     These are year specific, so it's up to you to determine what you'd like to fetch.

     */
    private HashMap<String, Object> redScoreBreakdown;
    private HashMap<String, Object> blueScoreBreakdown;
    /**
     * Array of `Media` objects associated with this match.
     */
    private Media[] videos;

    public long getPostResultTime() {
        return postResultTime;
    }

    public void setPostResultTime(long postResultTime) {
        this.postResultTime = postResultTime;
    }

    public HashMap<String, Object> getRedScoreBreakdown() {
        return redScoreBreakdown;
    }

    public void setRedScoreBreakdown(HashMap<String, Object> redScoreBreakdown) {
        this.redScoreBreakdown = redScoreBreakdown;
    }

    public HashMap<String, Object> getBlueScoreBreakdown() {
        return blueScoreBreakdown;
    }

    public void setBlueScoreBreakdown(HashMap<String, Object> blueScoreBreakdown) {
        this.blueScoreBreakdown = blueScoreBreakdown;
    }

    public Media[] getVideos() {
        return videos;
    }

    public void setVideos(Media[] videos) {
        this.videos = videos;
    }
}
