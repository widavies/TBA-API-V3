package com.cpjd.models.simple;

import lombok.Data;
import com.cpjd.models.other.District;
import com.cpjd.models.standard.Event;

import java.io.Serializable;
import java.util.Calendar;

/**
 * This is the Simple Event Model, as defined by the V3 TBA api.
 *
 * @since 1.0.0
 * @author Will Davies
 */
@Data
public class SEvent implements Serializable, Comparable<Event> {
    /**
     * TBA event key with the format yyyy[EVENT_CODE], where yyyy is the year, and EVENT_CODE is the event code of the event.
     */
    private String key;
    /**
     * Official name of event on record either provided by FIRST or organizers of offseason event.
     */
    private String name;
    /**
     * Event short code, as provided by FIRST.
     */
    private String eventCode;
    /**
     * Event Type, as defined here: https://github.com/the-blue-alliance/the-blue-alliance/blob/master/consts/event_type.py#L2
     */
    private long eventType;

    /**
     * Districts array
     */
    private District district;

    /**
     * State or Province the event is located in.
     */
    private String stateProv;
    /**
     * Country the event is located in.
     */
    private String country;
    /**
     * Event start date in yyyy-mm-dd format.
     */
    private String startDate;
    /**
     * Event end date in yyyy-mm-dd format.
     */
    private String endDate;

    /**
     * Year the event data is for.
     */
    private long year;

    public long getTimeInMillis(String date) {
        String[] tokens = date.split("-");

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, Integer.parseInt(tokens[0]));
        c.set(Calendar.MONTH, Integer.parseInt(tokens[1]));
        c.set(Calendar.DAY_OF_MONTH, Integer.parseInt(tokens[2]));
        return c.getTimeInMillis();
    }

    @Override
    public int compareTo(Event o) {
        return Long.compare(getTimeInMillis(startDate), getTimeInMillis(o.getStartDate()));
    }
}
