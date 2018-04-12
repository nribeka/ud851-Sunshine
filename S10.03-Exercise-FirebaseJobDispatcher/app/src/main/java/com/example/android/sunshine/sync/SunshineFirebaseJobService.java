package com.example.android.sunshine.sync;

import android.content.Context;
import android.os.AsyncTask;

import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;

public class SunshineFirebaseJobService extends JobService {

    private AsyncTask<Void, Void, Void> mFetchWeatherTask;

    @Override
    public boolean onStartJob(final JobParameters job) {
        mFetchWeatherTask = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                Context context = SunshineFirebaseJobService.this;
                SunshineSyncTask.syncWeather(context);
                return null;
            }

            @Override
            protected void onPostExecute(Void o) {
                jobFinished(job, false);
            }
        };

        mFetchWeatherTask.execute();
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters job) {
        if (mFetchWeatherTask != null) {
            mFetchWeatherTask.cancel(true);
            return true;
        }
        return false;
    }
}
// DONE (2) Make sure you've imported the jobdispatcher.JobService, not job.JobService

// DONE (3) Add a class called SunshineFirebaseJobService that extends jobdispatcher.JobService

// DONE (4) Declare an ASyncTask field called mFetchWeatherTask

//  DONE (5) Override onStartJob and within it, spawn off a separate ASyncTask to sync weather data
//              DONE (6) Once the weather data is sync'd, call jobFinished with the appropriate arguments

//  DONE (7) Override onStopJob, cancel the ASyncTask if it's not null and return true
