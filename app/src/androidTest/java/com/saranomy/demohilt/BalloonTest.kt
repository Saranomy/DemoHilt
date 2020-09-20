package com.saranomy.demohilt

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.saranomy.demohilt.models.WaterBalloon
import com.saranomy.demohilt.models.WaterInterface
import com.saranomy.demohilt.modules.BalloonModule
import com.saranomy.demohilt.presentations.MainActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject
import javax.inject.Named

@HiltAndroidTest
@UninstallModules(BalloonModule::class) // ignore the production module by using the @UninstallModules
@RunWith(AndroidJUnit4::class)
class BalloonTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    // replace the binding
    @Module
    @InstallIn(ApplicationComponent::class)
    object TestModule {
        @Provides
        @Named("Salt")
        fun provideWater(): WaterInterface {
            return object : WaterInterface {
                override fun checkPH(): Double {
                    return 0.0
                }
            }
        }

        @Provides
        @Named("Leather")
        fun provideTest(): String {
            return "Test"
        }
    }

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Inject
    lateinit var waterBalloon: WaterBalloon

    @Test
    fun inject_TestModule() {
        // inject the result for testing
        val result = waterBalloon.pop()
        // check if the produced texts are the same
        onView(withId(R.id.result)).check(matches(withText(result)))
    }
}