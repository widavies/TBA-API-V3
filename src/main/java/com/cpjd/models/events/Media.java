package com.cpjd.models.events;

import java.io.Serializable;

/**
 * @since 1.0.0
 * @author Will Davies
 */
public class Media implements Serializable {
    /**
     * TBA identifier for this media.
     */
    private String key;
    /**
     * String type of the media element.
     */
    private String type;
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getForeignKey() {
        return foreignKey;
    }

    public void setForeignKey(String foreignKey) {
        this.foreignKey = foreignKey;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public boolean isPreferred() {
        return preferred;
    }

    public void setPreferred(boolean preferred) {
        this.preferred = preferred;
    }
}
