package com.yusufbayram.testingdemo


import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Before
import org.junit.Rule

@RunWith(AndroidJUnit4ClassRunner::class)
class UiTest {

    @get: Rule var activityScenarioRule = activityScenarioRule<MainActivity>()

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }


    @Test
    fun testAddition() {
        onView(withId(R.id.etxt_base_number)).perform(typeText("10"))
        closeSoftKeyboard()
        onView(withId(R.id.etxt_number)).perform(typeText("5"))
        closeSoftKeyboard()
        onView(withId(R.id.btn_add)).perform(click())
        onView(withId(R.id.txt_result)).check(matches(withText("15")))
        onView(withId(R.id.btn_add)).perform(doubleClick())
        onView(withId(R.id.txt_result)).check(matches(withText("25")))
        onView(withId(R.id.btn_add)).perform(longClick())
        onView(withId(R.id.txt_result)).check(matches(isDisplayed()))
    }

    @Test
    fun testSubstruction() {
        onView(withId(R.id.etxt_base_number)).perform(typeText("20"))
        closeSoftKeyboard()
        onView(withId(R.id.etxt_number)).perform(typeText("8"))
        closeSoftKeyboard()
        onView(withId(R.id.btn_sub)).perform(click())
        onView(withId(R.id.txt_result)).check(matches(withText("12")))
        onView(withId(R.id.btn_sub)).perform(longClick())
        onView(withId(R.id.txt_result)).check(matches(isDisplayed()))
    }

    @Test
    fun testClear() {
        onView(withId(R.id.btn_clear)).perform(click())
        onView(withId(R.id.txt_result)).check(matches(withText("0")))
        onView(withId(R.id.btn_clear)).perform(longClick())
        onView(withId(R.id.txt_result)).check(matches(isDisplayed()))
    }

    @Test
    fun testRating() {
        onView(withId(R.id.ratingBar)).perform(click())
    }
}