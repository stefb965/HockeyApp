/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2013 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package nl.rebelic.hockeyapp;

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;

import org.appcelerator.titanium.TiApplication;
import org.appcelerator.kroll.common.Log;


import android.app.Activity;
import net.hockeyapp.android.CrashManager;
import net.hockeyapp.android.CrashManagerListener;
import net.hockeyapp.android.UpdateManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;



@Kroll.module(name="Hockeyapp", id="nl.rebelic.hockeyapp")
public class HockeyappModule extends KrollModule
{

	// Standard Debugging variables
	private static final String TAG = "HockeyappModule";
    
    private String appId = null;
    
	// You can define constants with @Kroll.constant, for example:
	// @Kroll.constant public static final String EXTERNAL_NAME = value;
	
	public HockeyappModule()
	{
		super();
	}

	@Kroll.onAppCreate
	public static void onAppCreate(TiApplication app)
	{
		Log.d(TAG, "inside onAppCreate");
		// put module init code that needs to run when the application is created
	}

	@Override
    public void onResume(Activity activity) {
        // TODO Auto-generated method stub
        super.onResume(activity);
        
        checkForCrashes();
        checkForUpdates();
    }
    
	// Methods
    @Kroll.method
    public void start(String appId)
    {
        this.appId = appId;
    }
    
    private void checkForCrashes() {
        if(this.appId == null)
            return;
        
        Log.d(TAG, "checkForCrashes");
        Activity activity = TiApplication.getAppRootOrCurrentActivity();
        // CrashManager.register(activity, this.appId);
		CrashManager.register(activity, this.appId, new CrashManagerListener() {
			
			public boolean shouldAutoUploadCrashes() {
			    return true;
			  };
		});


    }
    
    private void checkForUpdates() {
        if(this.appId == null)
            return;

        Log.d(TAG, "checkForUpdates");
        // Remove this for store builds!
        Activity activity = TiApplication.getAppRootOrCurrentActivity();
        UpdateManager.register(activity, this.appId);
    }
}

