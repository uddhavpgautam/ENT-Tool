package com.Uddhav.ENTTool.utils;

import android.app.Application;
import android.content.Context;

import com.Uddhav.ENTTool.R;
import com.splunk.mint.Mint;

/**
 * Created by Uddhav Gautam on 7.3.2016. upgautam@ualr.edu
 */
public class App extends Application {

	public static Context		AppContext	= null;
	public static MainThreadBus	bus			= null;

	@Override
	public void onCreate() {
		super.onCreate();

		AppContext = getApplicationContext();

//		Mint.initAndStartSession(App.this, getString(R.string.Mint_apiKey));

		Mint.initAndStartSession(App.this, "29463cb0");

		bus = new MainThreadBus();

	}
}
