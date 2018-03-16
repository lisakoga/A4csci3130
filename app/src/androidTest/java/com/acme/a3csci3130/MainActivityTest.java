package com.acme.a3csci3130;

import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.espresso.intent.rule.IntentsTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;

import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
@LargeTest

/**
 * Created by lisa on 2018-03-15.
 */

public class MainActivityTest
{
    @Rule
    public IntentsTestRule<MainActivity> intentsTestRule = new IntentsTestRule<>(MainActivity.class);

    /**
     *  Test for clicking "CREATE CONTACT" button on the main page
     */

    @Test
    public void clickCreateContact()
    {
        onView(withId(R.id.submitButton)).perform(click());
        intended(hasComponent(MainActivity.class.getName()));
    }
}
