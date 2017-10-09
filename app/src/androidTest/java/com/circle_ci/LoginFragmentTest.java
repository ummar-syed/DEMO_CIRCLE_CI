package com.circle_ci;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.TextView;

import com.circle_ci.fragments.LoginFragment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by sandip.lawate on 10/9/2017.
 */
public class LoginFragmentTest extends ActivityInstrumentationTestCase2<MainActivity> {
    private LoginFragment fragment;
    private MainActivity mainActivity;

    public LoginFragmentTest() {

        super(MainActivity.class);
    }

    private Fragment startFragment(Fragment fragment) {
        mainActivity = getActivity();
        FragmentTransaction transaction = mainActivity.getFragmentManager().beginTransaction();
        transaction.add(R.id.frameLayout, fragment, "tag");
        transaction.commit();
        getInstrumentation().waitForIdleSync();
        Fragment frag = mainActivity.getFragmentManager().findFragmentByTag("tag");
        return frag;
    }

    @Before
    public void setup() {
        mainActivity = getActivity();
    }

    public void testMethod1() {

        fragment = new LoginFragment();

        Fragment frag = startFragment(fragment);
        Button btnSubmit = (Button) frag.getView().findViewById(R.id.submit_Button);
        assertTrue("Test", (btnSubmit.getText().equals("Submit")));

    }


}
