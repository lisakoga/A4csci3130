package com.acme.a3csci3130;

/**
 * Created by lisa on 2018-03-15.
 */


import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.espresso.intent.rule.IntentsTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;

import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
@LargeTest

public class EspressoTest
{
    @Rule
    IntentsTestRule<MainActivity> intentsTestRule = new IntentsTestRule<>(MainActivity.class);

    private String id = "john_smith";
    private String name = "John Smith";
    private String number = "999999999";
    private String business = "Fisher";
    private String address = "6050 University Ave.";
    private String province = "NS";
    private Contact contact = new Contact(id, name, number, business, address, province);

    /**
     *  Test for creating a new contact
     */
    @Test
    public void addContact()
    {
        onView(withId(R.id.submitButton)).perform(click());
        intended(hasComponent(CreateContactAcitivity.class.getName()));

        onView(withId(R.id.name)).perform(typeText(id));
        onView(withId(R.id.number)).perform(typeText(number));
        onView(withId(R.id.business)).perform(typeText(business));
        onView(withId(R.id.address)).perform(typeText(address));
        onView(withId(R.id.province)).perform(typeText(province));
        closeSoftKeyboard();
        onView(withId(R.id.submitButton)).perform(click());
    }

    /**
     *  Test for updating a contact
     */
    @Test
    public void updateContact()
    {
        onView(withId(R.id.updateButton)).perform(click());
        intended(hasComponent(DetailViewActivity.class.getName()));
    }

    /**
     *  Test for deleting a contact
     */
    @Test
    public void deleteContact()
    {
        onView(withId(R.id.deleteButton)).perform(click());
        intended(hasComponent(DetailViewActivity.class.getName()));
    }

    /**
     *  Test for clicking "CREATE CONTACT" button on the main page
     */
    @Test
    public void pressButton()
    {
        // submitButton
        onView(withId(R.id.submitButton)).perform(click());
        intended(hasComponent(MainActivity.class.getName()));
    }


}

