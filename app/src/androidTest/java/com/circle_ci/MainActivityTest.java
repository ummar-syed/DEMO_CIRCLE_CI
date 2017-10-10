package com.circle_ci;

/**
 * Created by dev1 on 10/9/2017.
 */

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
public class MainActivityTest {


    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Before
    public void init() {
        mActivityRule.getActivity()
                .getFragmentManager().beginTransaction();
    }

    @Test
    public void TestAutoComplete() {
        onView(withId(R.id.button_add_response));
    }
}
