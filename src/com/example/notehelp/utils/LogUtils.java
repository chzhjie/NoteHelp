package com.example.notehelp.utils;

import android.util.Log;

/**
 * Created by zhenjie on 2015/5/15.
 */
public class LogUtils {
    public static boolean ISLOG =   true;
    public static final String NORMAL_TAG = "LOG";

    public static void info(String s,Object... args){
        Log.d(NORMAL_TAG,String.format(s, args));
    }
    public static void info(String tag,String s,Object... args){
        Log.d(tag,String.format(s, args));
    }

    public static void d(String tag,String s){
        Log.d(tag,s);
    }

    public static void d(String s){
        Log.d(NORMAL_TAG,s);
    }
}
