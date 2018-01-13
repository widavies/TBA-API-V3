package models.other;

import lombok.Data;

import java.io.Serializable;

/**
 * @since 1.0.0
 * @author Will Davies
 */
@Data
public class Media implements Serializable {
    /**
     * TBA identifier for this media.
     */
    private String key;
    /**
     * String type of the media element.
     */
    private String[] type;
    /**
     * The key used to identify this media on the media site.
     */
    private String foreignKey;
    /**
     * If required, a JSON dict of additional media information.
     */
    private String details;
    /**
     * True if the media is of high quality.
     */
    private boolean preferred;

}
