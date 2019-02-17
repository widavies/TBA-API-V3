package com.cpjd.models.events;

import com.cpjd.sorting.Sortable;
import com.cpjd.sorting.SortingType;
import com.cpjd.models.districts.District;

import java.io.Serializable;
import java.util.Calendar;

/**
 * This is the Simple Event Model, as defined by the V3 TBA api.
 *
 * @since 1.0.0
 * @author Will Davies
 */
public class SEvent extends Sortable<SEvent> implements Serializable {
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
     * Event SortingType, as defined here: https://github.com/the-blue-alliance/the-blue-alliance/blob/master/consts/event_type.py#L2
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
    public int sort(SortingType type, boolean ascending, SEvent t2) {
        if(type == SortingType.DEFAULT || type == SortingType.DATE) {
            return Long.compare(getTimeInMillis(startDate), getTimeInMillis(t2.getStartDate()));
        } else if(type == SortingType.NAME) {
            return name.compareTo(t2.getName());
        }

        throw new RuntimeException("Unsupported sorting type for event model type.");
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public long getEventType() {
        return eventType;
    }

    public void setEventType(long eventType) {
        this.eventType = eventType;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public String getStateProv() {
        return stateProv;
    }

    public void setStateProv(String stateProv) {
        this.stateProv = stateProv;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }
}
