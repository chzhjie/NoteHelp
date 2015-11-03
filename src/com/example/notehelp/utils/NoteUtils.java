package com.example.notehelp.utils;

import android.app.Activity;
import android.view.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhenjie on 2015/5/15.
 */
public class NoteUtils {
    /**
     * 将String转换为Date
     *
     * @param strDate
     * @return
     */
    public static Date parseDataFromString(String strDate) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = dateFormat.parse(strDate);
        } catch (ParseException e) {
            LogUtils.d(e.getMessage());
        }
        return date;
    }

    /**
     * 将时间转换为String类型
     *
     * @param date
     * @return
     */
    public static String parseStringFromDate(Date date) {
        String dateStr = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateStr = dateFormat.format(date);
        return dateStr;
    }

    public static <T extends View> T getView(Activity parent, int viewID) {
        return (T) checkView(parent.findViewById(viewID));
    }

    public static <T extends View> T getView(View parent, int viewID) {
        return (T) checkView(parent.findViewById(viewID));
    }

    private static View checkView(View v) {
        if (v == null) {
            throw new IllegalArgumentException("View don not exist");
        }
        return v;
    }

}
