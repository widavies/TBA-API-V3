package models.other;

/**
 * Created by Will Davies on 7/7/2017.
 */
public class Award {
    /**
     * The name of the award as provided by FIRST. May vary for the same award type.
     */
    private String name;
    /**
     * Type of award given. See https://github.com/the-blue-alliance/the-blue-alliance/blob/master/consts/award_type.py#L6
     */
    private int awardType;
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
    private int year;
}
