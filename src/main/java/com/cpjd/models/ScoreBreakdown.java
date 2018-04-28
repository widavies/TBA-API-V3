package com.cpjd.models;

import lombok.Data;

import java.util.HashMap;

@Data
public class ScoreBreakdown {

    private boolean isRed;

    private HashMap<String, Object> values;

}
