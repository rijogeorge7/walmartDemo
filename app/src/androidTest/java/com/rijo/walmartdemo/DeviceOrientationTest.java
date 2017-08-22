package com.rijo.walmartdemo;

import android.content.pm.ActivityInfo;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;

import com.rijo.walmartdemo.ui.startupScreen.StartUpActivity;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by rijogeorge on 8/22/17.
 */

public class DeviceOrientationTest {
    @Rule
    public ActivityTestRule<StartUpActivity> mActivityRule = new ActivityTestRule<>(StartUpActivity.class);

    @Test
    public void startupActivityOrientationTest() {
        onView(withId(R.id.productList_recycler_view))
                .check(matches(isDisplayed()));
        mActivityRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        onView(withId(R.id.productList_recycler_view))
                .check(matches(isDisplayed()));
        mActivityRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        onView(withId(R.id.productList_recycler_view))
                .check(matches(isDisplayed()));
        onView(withId(R.id.productList_recycler_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(3, click()));
        onView(withId(R.id.imageView))
                .check(matches(isDisplayed()));
        mActivityRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        onView(withId(R.id.imageView))
                .check(matches(isDisplayed()));
        mActivityRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        onView(withId(R.id.imageView))
                .check(matches(isDisplayed()));
    }
}
