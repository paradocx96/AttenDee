package com.androx.attendee;

import androidx.test.espresso.Espresso;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class AddAttendeeActivityTest {

    @Rule
    public ActivityTestRule<AddAttendeeActivity> mActivityActivityTestRule = new ActivityTestRule<AddAttendeeActivity>(AddAttendeeActivity.class);


    private String pName = "Hirush";
    private String pRemarks = "Ganemulla";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testUserInputScenario(){
        //input text in editor
        Espresso.onView(withId(R.id.editTxt_personName)).perform(typeText(pName), closeSoftKeyboard());
        //Espresso.onView(withId(R.id.editTxt_remarks)).perform(typeText(pRemarks), closeSoftKeyboard());

        //close the keyboard
        //Espresso.closeSoftKeyboard();

        //perform button click
        Espresso.onView(withId(R.id.addPersonBtn)).perform(click());


        //check the text in the text view
//        Espresso.onView(withId(R.id.attendeeName_Example1)).check(matches(withText(pName)));
//        Espresso.onView(withId(R.id.attendeeRemark_Example4)).check(matches(withText(pRemarks)));
        Espresso.onView(withId(R.id.tv)).check(matches(withText(pName)));
    }

    @After
    public void tearDown() throws Exception {
    }
}