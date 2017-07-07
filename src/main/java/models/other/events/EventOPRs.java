package models.other.events;

import java.util.HashMap;

/**
 * OPR, DPR, and CCWM for teams at the event.
 * @since 1.0.0
 * @author Will Davies
 */
public class EventOPRs {
    /**
     *
     A key-value pair with team key (eg frc254) as key and OPR as value.
     */
    private HashMap<String, Float> oprs;
    /**
     *
     A key-value pair with team key (eg frc254) as key and DPR as value.
     */
    private HashMap<String, Float> dprs;
    /**
     *
     A key-value pair with team key (eg frc254) as key and CCWM as value.
     */
    private HashMap<String, Float> ccwms;

}
