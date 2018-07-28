package ndk.dstock;

import ndk.utils.Log_Utils;

/**
 * Created on 20-07-2018 08:49 under DStock.
 */
public class Log_Utils_Wrapper {

    public static void debug(String message) {
        Log_Utils.debug(Application_Specification.APPLICATION_NAME, message, BuildConfig.DEBUG);
    }
}
