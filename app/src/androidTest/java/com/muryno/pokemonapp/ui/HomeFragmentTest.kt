package com.muryno.pokemonapp.ui


import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import androidx.test.platform.app.InstrumentationRegistry
import com.muryno.pokemonapp.R
import com.muryno.pokemonapp.presenter.fragment.HomeFragment
import com.muryno.pokemonapp.utils.BaseUnitAndroidTest
import com.muryno.pokemonapp.utils.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith


@MediumTest
@ExperimentalCoroutinesApi
@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class HomeFragmentTest : BaseUnitAndroidTest() {
    val navController = TestNavHostController(ApplicationProvider.getApplicationContext())

    @Test
    fun displayScreenTitle() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.muryno.pokemonapp", appContext.packageName)
    }


    @Test
    fun check_all_views_are_display() {
        //Launch fragment
        launchNewsListFragment()
        onView(withId(R.id.front_imageView))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.back_image))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    private fun launchNewsListFragment() {
        launchFragmentInHiltContainer<HomeFragment> {
            navController.setGraph(R.navigation.nav_host)
            navController.setCurrentDestination(R.id.homeFragment)
            this.viewLifecycleOwnerLiveData.observeForever { viewLifecycleOwner ->
                if (viewLifecycleOwner != null) {
                    // The fragment’s view has just been created
                    Navigation.setViewNavController(this.requireView(), navController)
                }
            }
        }
    }
}