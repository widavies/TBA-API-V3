package com.cpjd.models.events;

import lombok.Data;

import java.io.Serializable;

/**
 * @since 1.0.0
 * @author Will Davies
 */
@Data
public class Webcast implements Serializable {
    private String type;
    private String channel;
    private String file;
}
