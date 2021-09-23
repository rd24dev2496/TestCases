package com.example.layout;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)

public class OrderActivityTest {
    @Rule
    public ActivityTestRule<OrderActivity> mActivityTestRule =
            new ActivityTestRule<>(OrderActivity.class);

    @Test
    public void clickDecrementButton_ChangesQuantityAndCost() {
        ActivityScenario.launch(OrderActivity.class);
        onView((withId(R.id.btn_plus))).perform(click());
        //onView(withId(R.id.tv_value)).check(matches(withText("1")));



    }
}