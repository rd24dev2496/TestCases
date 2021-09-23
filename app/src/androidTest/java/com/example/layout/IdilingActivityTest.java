package com.example.layout;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.IdlingResource;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class IdilingActivityTest {
    private static final String STRING_TO_BE_TYPED = "Espresso";

    @Rule
    public ActivityTestRule<IdilingActivity> mActivityTestRule =
            new ActivityTestRule<>(IdilingActivity.class);

    private IdlingResource mIdlingResource;

    @Before
    public void registerIdlingResource() {

        mIdlingResource = mActivityTestRule.getActivity().getIdlingResource();
        Espresso.registerIdlingResources(mIdlingResource);

    }

    @Test
    public void changeText_sameActivity() {
        onView((withId(R.id.editTextUserInput))).perform(typeText(STRING_TO_BE_TYPED), ViewActions.closeSoftKeyboard());
        onView((withId(R.id.changeTextBt))).perform(click());
    onView((withId(R.id.textToBeChanged))).check(matches(withText(STRING_TO_BE_TYPED)));
    }
    @After
    public  void unregisterIdlingResource(){
        if (mIdlingResource!= null)
        {
            Espresso.unregisterIdlingResources(mIdlingResource);
        }
    }
}