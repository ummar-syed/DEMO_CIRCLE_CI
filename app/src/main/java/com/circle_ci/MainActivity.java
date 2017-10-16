package com.circle_ci;


import android.app.Activity;
import android.os.Bundle;

import com.circle_ci.fragments.LoginFragment;
import com.crashlytics.android.Crashlytics;
import com.google.firebase.analytics.FirebaseAnalytics;

import net.hockeyapp.android.CrashManager;
import net.hockeyapp.android.UpdateManager;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends Activity {
    private FirebaseAnalytics mFirebaseAnalytics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        Fabric.with(this, new Crashlytics());

        Bundle params = new Bundle();
        params.putString("action", "launch");
        mFirebaseAnalytics.logEvent("Init", params);

        getFragmentManager().beginTransaction().add(R.id.frameLayout, new LoginFragment())
                .addToBackStack(LoginFragment.class.getSimpleName())
                .commit();
        checkForUpdates();
        //
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkForCrashes();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterManagers();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterManagers();
    }

    private void checkForCrashes() {
        CrashManager.register(this);
    }

    private void checkForUpdates() {
        // Remove this for store builds!
        UpdateManager.register(this);
    }

    private void unregisterManagers() {
        UpdateManager.unregister();
    }

}
