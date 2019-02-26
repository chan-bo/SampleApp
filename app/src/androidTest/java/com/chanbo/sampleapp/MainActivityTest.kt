package com.chanbo.sampleapp

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.chanbo.sampleapp.ui.main.MainActivity
import com.chanbo.sampleapp.ui.toprated.TopRatedAdapter
import com.chanbo.sampleapp.utils.EspressoIdlingResource
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import tools.fastlane.screengrab.Screengrab
import tools.fastlane.screengrab.UiAutomatorScreenshotStrategy

@RunWith(JUnit4::class)
class MainActivityTest {

//    @Rule
//    val activityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    fun setUp() {
        ActivityScenario.launch(MainActivity::class.java)
        Screengrab.setDefaultScreenshotStrategy(UiAutomatorScreenshotStrategy())
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getIdlingResource())
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getIdlingResource())
    }

    @Test
    fun testRecyclerView() {
        Thread.sleep(3000)
//        Screengrab.screenshot("before_click")
        onView(withId(R.id.recyclerView))
            .perform(RecyclerViewActions.actionOnItemAtPosition<TopRatedAdapter.TopRatedViewHolder>(0, click()))
//        Thread.sleep(5000)
//        Screengrab.screenshot("after_click")
    }
}