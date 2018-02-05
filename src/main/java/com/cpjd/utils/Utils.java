package com.cpjd.utils;

import org.json.simple.JSONArray;

/**
 * Created by Will Davies on 7/7/2017.
 */
public class Utils {

    public static long cleanLong(Object object) {
        if(object == null) return 0;
        else return (long)object;
    }

    public static double cleanDouble(Object object) {
        if(object == null) return 0;
        else return (double)object;
    }

    public static boolean cleanBoolean(Object object) {
        if(object == null) return false;
        else return (boolean)object;
    }

    public static String[] jsonArrayToStringArray(JSONArray jsonArray) {
        if(jsonArray == null) return null;
        String[] toReturn = new String[jsonArray.size()];
        for(int i = 0; i < jsonArray.size(); i++) toReturn[i] = (String)jsonArray.get(i);
        return toReturn;
    }

}
