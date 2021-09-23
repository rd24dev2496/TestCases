package com.example.layout;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)

public class LoginActivityTest {
    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule =
            new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void clickDecrementButton_ChangesQuantityAndCost() {
        ActivityScenario.launch(LoginActivity.class);

        String username="rishabh";
        String password="password";
        onView(withId(R.id.et_username)).perform(ViewActions.typeText(username));
        onView(withId(R.id.et_password)).perform(ViewActions.typeText(password));
        onView(withId(R.id.btn_submit)).perform(ViewActions.scrollTo(), ViewActions.click());
        onView(withId(R.id.loginTitleTextView)).check(matches(withText("Success")));

    }


}