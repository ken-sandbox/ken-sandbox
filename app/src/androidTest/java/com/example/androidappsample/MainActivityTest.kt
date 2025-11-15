package com.example.androidappsample

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Before
    fun setUp() {
        // Launch MainActivity before each test
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun testHelloTextViewIsDisplayed() {
        // Verify that the text view with the "hello" text is displayed
        onView(withId(R.id.textHello)).check { view, _ ->
            assert(view != null)
        }
    }

    @Test
    fun testHelloTextContent() {
        // Verify that the text view contains expected text (in default locale)
        // This test will vary by device language setting
        onView(withId(R.id.textHello)).check { view, _ ->
            val text = (view as android.widget.TextView).text.toString()
            assert(text.isNotEmpty())
        }
    }

    @Test
    fun testEditTextIsVisible() {
        // Verify that the EditText field is displayed
        onView(withId(R.id.editTextName)).check { view, _ ->
            assert(view != null)
        }
    }

    @Test
    fun testButtonIsVisible() {
        // Verify that the Greet button is displayed
        onView(withId(R.id.buttonGreet)).check { view, _ ->
            assert(view != null)
        }
    }

    @Test
    fun testOutputTextViewIsVisible() {
        // Verify that the output TextView is displayed
        onView(withId(R.id.textOutput)).check { view, _ ->
            assert(view != null)
        }
    }

    @Test
    fun testGreetingWithUserInput() {
        // Type a name into the EditText
        onView(withId(R.id.editTextName)).perform(typeText("Alice"), closeSoftKeyboard())

        // Click the Greet button
        onView(withId(R.id.buttonGreet)).perform(click())

        // Verify that the output TextView shows the greeting
        onView(withId(R.id.textOutput)).check { view, _ ->
            val text = (view as android.widget.TextView).text.toString()
            assert(text.contains("Alice"))
        }
    }

    @Test
    fun testGreetingWithEmptyInput() {
        // Don't type anything into the EditText
        // Click the Greet button
        onView(withId(R.id.buttonGreet)).perform(click())

        // Verify that the output TextView shows the default greeting
        onView(withId(R.id.textOutput)).check { view, _ ->
            val text = (view as android.widget.TextView).text.toString()
            // Default greeting depends on locale; ensure it's not empty
            assert(text.isNotBlank())
        }
    }

    @Test
    fun testMultipleGreetings() {
        // First greeting with a name
        onView(withId(R.id.editTextName)).perform(typeText("Bob"), closeSoftKeyboard())
        onView(withId(R.id.buttonGreet)).perform(click())

        onView(withId(R.id.textOutput)).check { view, _ ->
            val text = (view as android.widget.TextView).text.toString()
            assert(text.contains("Bob"))
        }

        // Clear and test again with another name
        onView(withId(R.id.editTextName)).perform(
            androidx.test.espresso.action.ViewActions.replaceText("Charlie"),
            closeSoftKeyboard()
        )
        onView(withId(R.id.buttonGreet)).perform(click())

        onView(withId(R.id.textOutput)).check { view, _ ->
            val text = (view as android.widget.TextView).text.toString()
            assert(text.contains("Charlie"))
        }
    }
}
