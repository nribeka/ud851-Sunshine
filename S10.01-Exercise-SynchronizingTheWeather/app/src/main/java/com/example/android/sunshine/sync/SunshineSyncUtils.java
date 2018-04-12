package com.example.android.sunshine.sync;

// DONE (9) Create a class called SunshineSyncUtils
    //  DONE (10) Create a public static void method called startImmediateSync
    //  DONE (11) Within that method, start the SunshineSyncIntentService

import android.content.Context;
import android.content.Intent;

public class SunshineSyncUtils {
    public static void startImmidiateSync(Context context) {
        Intent syncWeatherIntent = new Intent(context, SunshineSyncIntentService.class);
        context.startService(syncWeatherIntent);
    }
}