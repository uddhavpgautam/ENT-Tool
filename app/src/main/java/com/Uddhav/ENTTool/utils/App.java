package com.Uddhav.ENTTool.utils;

import android.app.Application;
import android.content.Context;

import com.splunk.mint.Mint;

/**
 * Created by Uddhav Gautam on 7.3.2016. upgautam@ualr.edu
 */
public class App extends Application { //Application is android's class like PreferenceManager is.
    // Application in the android is the base process that runs inside the Dalvik VM. Since, it is a process,
    // it has a lifecycle like Activity. But, Activity is What you see/do in the screen. So, one Application may contain
    // many Activities Application are the basic fundamental things. Application is defined in the AndroidManifest.xml
    //file.
    //In this project, there are 4 activities, defined in the AndroidManifest.xml file, inside the Application
    //So, basically, activities are like the screen of the projects, related to the GUI. So, activity extends ContextThemeWrapper
    //whereas, the Application extends ContextWrapper.
    // Application's father is the activity's grandpa

    public static Context AppContext = null; //Context is an abstract class which has Object as father. This tells overall
    // system environment
    public static MainThreadBus bus = null;
    //bus is just a Otto bus. It uses handler for the communication between activity and fragments or activity and services.

    @Override
    public void onCreate() {
        super.onCreate();

        AppContext = getApplicationContext(); //Now, AppContext is the context of the Application class (App class here)


//		Mint.initAndStartSession(App.this, getString(R.string.Mint_apiKey));

        Mint.initAndStartSession(App.this, "29463cb0"); //I am using Splunk Mint SDK to initialize and do start session
        // of this App providing the Splunk Mint API key. 29463cb0 is the key. Splunk Mint, here, I am using for the Data collector

        bus = new MainThreadBus();
        // I have initialized the MainThreadBus. Mean, I have called the MainThreadBus() default construction. But, since, tehre
        // is no constructor. So, "bus", here, has no use
    }
}
