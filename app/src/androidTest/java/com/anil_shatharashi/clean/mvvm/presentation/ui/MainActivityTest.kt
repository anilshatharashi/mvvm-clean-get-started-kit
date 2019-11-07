package com.anil_shatharashi.clean.mvvm.presentation.ui

import android.content.Intent
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.anil_shatharashi.clean.mvvm.R
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.koin.test.KoinTest

@RunWith(AndroidJUnit4::class)
class MainActivityTest : KoinTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testRule: IntentsTestRule<MainActivity> = IntentsTestRule<MainActivity>(MainActivity::class.java, false, false)

    @Before
    fun setup() {
        testRule.launchActivity(Intent())
    }

    @Test
    fun testTeacherListScreenContent() {
        onView(withText(R.string.fetch_data)).check(matches(isDisplayed())).perform(click())

        onView(withText(testRule.activity.resources.getString(R.string.tenth_char, "s"))).check(matches(isDisplayed()))
        onView(withText(testRule.activity.resources.getString(R.string.every_tenth_char, "s d e s e q q 8"))).check(matches(isDisplayed()))
        onView(withText(testRule.activity.resources.getString(R.string.words_count, "{Hello=1, how=2, are=8, you=3}"))).check(matches(isDisplayed()))
    }
}
