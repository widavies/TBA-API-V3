package models.other.events;

import lombok.Data;

/**
 * Insights for FIRST STEAMWORKS qualification and elimination matches.
 * @since 1.0.0
 * @author Will Davies
 */
@Data
public class EventInsights2017 {

    private EventInsights2017Detail quals;
    private EventInsights2017Detail playoff;

}
