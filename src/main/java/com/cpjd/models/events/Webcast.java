package com.cpjd.models.events;

import java.io.Serializable;

/**
 * @since 1.0.0
 * @author Will Davies
 */
public class Webcast implements Serializable {
    private String type;
    private String channel;
    private String file;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
