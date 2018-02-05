package com.cpjd.models.other.events;

import lombok.Data;

/**
 * Insights for FIRST STEAMWORKS qualification and elimination matches.
 *
 * @since 1.0.0
 * @author Will Davies
 */
@Data
public class EventInsights2016 {
    private EventInsights2016Detail qual;
    private EventInsights2016Detail playoff;

}
