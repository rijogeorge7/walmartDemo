package com.rijo.walmartdemo;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.rijo.walmartdemo.ui.startupScreen.StartUpActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by rijogeorge on 8/22/17.
 */
public class AppNavigationTest {
    @Rule
    public ActivityTestRule<StartUpActivity> mActivityRule = new ActivityTestRule<>(StartUpActivity.class);


    @Test
    public void mainNavigationTest() throws Exception {

        onView(withId(R.id.productList_recycler_view))
                .check(matches(isDisplayed()));
        onView(withId(R.id.productList_recycler_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(3, click()));
        onView(withId(R.id.imageView))
                .check(matches(isDisplayed()));
        pressBack();
        onView(withId(R.id.productList_recycler_view))
                .check(matches(isDisplayed()));

    }

}
