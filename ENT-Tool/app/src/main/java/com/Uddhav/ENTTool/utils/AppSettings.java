package com.Uddhav.ENTTool.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.Uddhav.ENTTool.R;

import java.util.Map;

/**
 * Created by Uddhav Gautam on 7.3.2016. upgautam@ualr.edu
 */
public class AppSettings {

    public static AppSettings pojoPref = null;
    private static Context ctx = App.AppContext; //App is a class. AppContext is a public static object
    // ctx is the context (system environment) of the base Application (process) of my project.

    private int TimeInterval, Source, Magnitude, MapType, UpdatePeriod, Sorting;
    private boolean Notifications, Vibration, Sound; // for checking notification, vibration and sound whehter to do ON/OFF

    private String Key_TimeInterval, Key_Source, Key_Magnitude;
    private String Key_UpdatePeriod, Key_Sorting, Key_Notifications, Key_Vibration, Key_Sound;

    AppSettings() { // constructor

        Key_TimeInterval = ctx.getResources().getString(R.string.listPref_Key_TimeInterval);
        Key_Source = ctx.getResources().getString(R.string.listPref_Key_Source);
        Key_Magnitude = ctx.getResources().getString(R.string.listPref_Key_Magnitude);
        Key_UpdatePeriod = ctx.getResources().getString(R.string.listPref_Key_UpdatePeriod);
        Key_Sorting = ctx.getResources().getString(R.string.listPref_Key_Sorting);
        Key_Notifications = ctx.getResources().getString(R.string.CheckBoxPref_Key_Notifications);
        Key_Vibration = ctx.getResources().getString(R.string.CheckBoxPref_Key_Vibration);
        Key_Sound = ctx.getResources().getString(R.string.CheckBoxPref_Key_Sound);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(ctx);
        Map<String, ?> allEntries = pref.getAll();

        String asd = (String) allEntries.get(Key_TimeInterval);

        TimeInterval = Integer.parseInt(asd);
        Source = Integer.parseInt((String) allEntries.get(Key_Source));
        Magnitude = Integer.parseInt((String) allEntries.get(Key_Magnitude));
        UpdatePeriod = Integer.parseInt((String) allEntries.get(Key_UpdatePeriod));
        Sorting = Integer.parseInt((String) allEntries.get(Key_Sorting));

        Notifications = (Boolean) allEntries.get(Key_Notifications);
        Vibration = (Boolean) allEntries.get(Key_Vibration);
        Sound = (Boolean) allEntries.get(Key_Sound);

        // for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
        // Log.d("map values", entry.getKey() + ": " + entry.getValue().toString());
        // }

    }

    public static void setDefaultSettings() {
        PreferenceManager.setDefaultValues(ctx, R.xml.pref, false);
        //Note, all resources are got from the resource ID.
        //PreferenceManager is a helper method to create a preference.
        //Used to help create Preference hierarchies from activities or XML.
        // In most cases, clients should use addPreferencesFromIntent(Intent) or addPreferencesFromResource(int).
    }

    public static AppSettings getInstance() {
        return pojoPref == null ? new AppSettings() : pojoPref;
    }

    public int getTimeInterval() {
        return TimeInterval;
    }

    public void setTimeInterval(int timeInterval) {
        TimeInterval = timeInterval;
    }

    public int getSource() {
        return Source;
    }

    public void setSource(int source) {
        Source = source;
    }

    public int getMagnitude() {
        return Magnitude;
    }

    public void setMagnitude(int magnitude) {
        Magnitude = magnitude;
    }

    public int getMapType() {
        return MapType;
    }

    public void setMapType(int mapType) {
        MapType = mapType;
    }

    public int getUpdatePeriod() {
        return UpdatePeriod;
    }

    public void setUpdatePeriod(int updatePeriod) {
        UpdatePeriod = updatePeriod;
    }

    public int getSorting() {
        return Sorting;
    }

    public void setSorting(int sorting) {
        Sorting = sorting;
    }

    public boolean isSound() {
        return Sound;
    }

    public void setSound(boolean sound) {
        Sound = sound;
    }

    public boolean isVibration() {
        return Vibration;
    }

    public void setVibration(boolean vibration) {
        Vibration = vibration;
    }

    public boolean isNotifications() {
        return Notifications;
    }

    public void setNotifications(boolean notifications) {
        Notifications = notifications;
    }
}
