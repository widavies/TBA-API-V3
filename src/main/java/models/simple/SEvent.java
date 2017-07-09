package models.simple;

import lombok.Data;
import models.other.District;

/**
 * This is the Simple Event Model, as defined by the V3 TBA api.
 *
 * @since 1.0.0
 * @author Will Davies
 */
@Data
public class SEvent {
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
    private District[] districtsList;

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
}
