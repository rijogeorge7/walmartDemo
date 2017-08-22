package com.rijo.walmartdemo;

import android.app.Fragment;
import android.content.Intent;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.rijo.walmartdemo.ui.startupScreen.StartUpActivity;
import com.rijo.walmartdemo.ui.startupScreen.fragments.ProductDetailsFragment;
import com.rijo.walmartdemo.ui.startupScreen.fragments.ProductListFragment;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertTrue;

/**
 * Created by rijogeorge on 8/22/17.
 */
@RunWith(AndroidJUnit4.class)
public class StartupActivityTest {
    //// third parameter is set to false which means the activity is not started automatically
    @Rule
    public IntentsTestRule<StartUpActivity> mActivityRule = new IntentsTestRule<>(StartUpActivity.class,true,false);

    @Before
    public void setUpIntent() throws Exception {
        mActivityRule.launchActivity(new Intent());
    }
    @Test
    public void activityStartedSuccessfully() throws Exception {
        onView(withId(R.id.productList_recycler_view))
                .check(matches(isDisplayed()));
        Fragment fragment=mActivityRule.getActivity().getFragmentManager().findFragmentById(R.id.fragment_container);
        assertTrue(fragment instanceof ProductListFragment);
        onView(withId(R.id.productList_recycler_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(3, click()));
        onView(withId(R.id.imageView))
                .check(matches(isDisplayed()));
        fragment=mActivityRule.getActivity().getFragmentManager().findFragmentById(R.id.fragment_container);
        assertTrue(fragment instanceof ProductDetailsFragment);
        pressBack();
        fragment=mActivityRule.getActivity().getFragmentManager().findFragmentById(R.id.fragment_container);
        assertTrue(fragment instanceof ProductListFragment);
    }
}
