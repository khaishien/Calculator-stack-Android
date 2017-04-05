package com.kslau.nexus.calculator;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.TextView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by shen-mini-itx on 4/6/2017.
 */


@RunWith(AndroidJUnit4.class)
@LargeTest
public class CalculatorTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void computeTest() {
        onView(withId(R.id.one_tv))
                .perform(click());
        onView(withId(R.id.nine_tv))
                .perform(click());
        onView(withId(R.id.plus_tv))
                .perform(click());
        onView(withId(R.id.three_tv))
                .perform(click());
        onView(withId(R.id.equal_tv))
                .perform(click());

        //19 + 3 =
        onView(withId(R.id.current_tv))
                .check(matches(withText("22")));


    }

}
