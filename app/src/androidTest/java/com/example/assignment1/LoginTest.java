package com.example.assignment1;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)

public class LoginTest extends TestCase {

    String patientUserTest, patientPassTest, patientNameChange;
    Login login;

    @Rule
    public ActivityTestRule<Login> activityTestRule = new ActivityTestRule<>(Login.class);

    @Before
    public void setUp() throws Exception {
        patientPassTest = "Password1234";
        patientUserTest = "JSmith4";
        patientNameChange = "Stevey";
        super.setUp();
    }

    @Test
    public void patientLogin()
    {
        onView(withId(R.id.etxtUserLogin)).perform(typeText(patientUserTest));
        onView(withId(R.id.etxtUserPass)).perform(typeText(patientPassTest));
        closeSoftKeyboard();
        onView(withId(R.id.btn_LoginFirst)).perform(click());
        onView(withId(R.id.PatientSettings)).perform(click());
        onView(withId(R.id.NameChange)).perform(typeText(patientNameChange));
        onView(withId(R.id.ChangeName)).perform(click());
    }



    @After
    public void tearDown() throws Exception {
    }
}