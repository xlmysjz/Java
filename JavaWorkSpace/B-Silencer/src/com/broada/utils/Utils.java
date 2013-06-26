/**
 * 
 */
/**
 * @author Administrator
 *
 */
package com.broada.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public final static int TIME_OUT = Integer.parseInt(Silencer
            .getString("element.find.timeout"));

    public static String getDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

}