package com.example.assignment1;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
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

public class PatientOrDoctorTest extends TestCase {

    @Rule
    public ActivityTestRule<PatientOrDoctor> activityTestRule = new ActivityTestRule<>(PatientOrDoctor.class);

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void patientButton()
    {
        onView(withId(R.id.Patientsubmit)).perform(click());
    }

    @Test
    public void doctorButton()
    {
        onView(withId(R.id.DoctorSubmit)).perform(click());
    }

    @After
    public void tearDown() throws Exception {
    }
}