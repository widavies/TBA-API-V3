package com.cpjd.models.events;

import java.io.Serializable;

/**
 * @since 1.0.0
 * @author Will Davies
 */
public class Award implements Serializable{
    /**
     * The name of the award as provided by FIRST. May vary for the same award type.
     */
    private String name;
    /**
     * SortingType of award given. See https://github.com/the-blue-alliance/the-blue-alliance/blob/master/consts/award_type.py#L6
     */
    private long awardType;
    /**
     * The event_key of the event the award was won at.
     */
    private String eventKey;
    /**
     * A list of recipients of the award at the event. Either team_key and/or awardee for individual awards.
     */
    private AwardRecipient[] recipients;
    /**
     * The year this award was won.
     */
    private long year;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAwardType() {
        return awardType;
    }

    public void setAwardType(long awardType) {
        this.awardType = awardType;
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public AwardRecipient[] getRecipients() {
        return recipients;
    }

    public void setRecipients(AwardRecipient[] recipients) {
        this.recipients = recipients;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }
}
