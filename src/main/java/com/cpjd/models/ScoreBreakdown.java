package com.cpjd.models;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;

@Data
public class ScoreBreakdown implements Serializable {

    private boolean isRed;

    private HashMap<String, Object> values;

}
