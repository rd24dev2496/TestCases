package com.example.layout;

import static androidx.test.espresso.Espresso.onData;
import static org.junit.Assert.*;



import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.anything;


import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MenuActivityScreenTest {

    public static final String TEA_NAME = "Green Tea";

    @Rule
    public ActivityTestRule<MenuActivity> mActivityTestRule = new ActivityTestRule<>(MenuActivity.class);
    /**
     * Clicks on a GridView item and checks it opens up the OrderActivity with the correct details.
     */
    @Test
    public void clickGridViewItem_OpensOrderActivity() {

        ActivityScenario.launch(MenuActivity.class);
        onView(withId(R.id.tea_name_text_view)).check(matches(withText(TEA_NAME)));

        onData(anything()).inAdapterView(withId(R.id.tea_grid_view)).atPosition(1).perform(click());

        // Checks that the OrderActivity opens with the correct tea name displayed
     //onView(withId(R.id.tea_name_text_view)).check(matches(withText(TEA_NAME)));
        //onView(withId(R.id.tea_name_text_view)).check(matches(withText("Success")));


    }

}