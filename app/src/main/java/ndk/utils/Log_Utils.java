package ndk.utils;

import android.util.Log;

import ndk.dstock.BuildConfig;

/**
 * Created on 18-07-2018 20:31 under DStock.
 */
public class Log_Utils {
    public static void debug(final String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, message);
        }
    }
}
