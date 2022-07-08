package com.example.assignment1;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)

public class DoctorLoginTest {

    String doctorUserTest, doctorPassTest;

    @Rule
    public ActivityTestRule<DoctorLogin> activityTestRule = new ActivityTestRule<>(DoctorLogin.class);

    @Before
    public void setUp() throws Exception {
        doctorUserTest = "DrFrank";
        doctorPassTest = "BrokenBone";
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void patientDoctor() {
        onView(withId(R.id.etxtDocLogin)).perform(typeText(doctorUserTest));
        onView(withId(R.id.etxtDocPass)).perform(typeText(doctorPassTest));
        closeSoftKeyboard();
        onView(withId(R.id.btn_Login2)).perform(click());
        //start of delete testing
        onView(withId(R.id.DoctorSettings)).perform(click());
        onView(withId(R.id.AccountDelete)).perform(click());
    }
}