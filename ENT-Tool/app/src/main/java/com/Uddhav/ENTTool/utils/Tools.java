package com.Uddhav.ENTTool.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.splunk.mint.Mint;

/**
 * Created by Uddhav Gautam on 7.3.2016. upgautam@ualr.edu
 */
public class Tools {

    public static int syncPeriod = 1000 * 15;
    public static String DATEFORMAT = "yyyy-MM-dd HH:mm:ss";
    public static String DATEFORMAT_SEISMICPORTAL = "yyyy-MM-dd'T'HH:mm:ss.S'Z'";

    public static boolean isOnline(Context act) {
        ConnectivityManager cm = (ConnectivityManager) act.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public static void catchException(Exception ex) {
        ex.printStackTrace();
        Mint.logException(ex);
    }
}
