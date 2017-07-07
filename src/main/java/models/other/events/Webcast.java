package models.other.events;

import lombok.Data;

/**
 * @since 1.0.0
 * @author Will Davies
 */
@Data
public class Webcast {
    private String type;
    private String channel;
    private String file;
}
