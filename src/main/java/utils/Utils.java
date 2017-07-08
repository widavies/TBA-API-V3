package utils;

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

}
