package com.example.sinke.buddybuild;

import android.content.Intent;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.intent.rule.IntentsTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

public class MainActivityTests {

  @Rule
  public IntentsTestRule<MainActivity> mActivityRule = new IntentsTestRule<>(
          MainActivity.class, false, false);
  @Test
  public void renderTest() {
    Intent intent = new Intent();
    mActivityRule.launchActivity(intent);

    onView(withId(R.id.text)).check(ViewAssertions.matches(allOf(isDisplayed(),
            withText("Hello World!"))));
  }

  @Test
  public void clickOnButtonText() {
    Intent intent = new Intent();
    mActivityRule.launchActivity(intent);

    onView(withId(R.id.button)).perform(click());
    onView(withId(R.id.text)).check(ViewAssertions.matches(allOf(isDisplayed(),
            withText("Blue"))));
  }
}
