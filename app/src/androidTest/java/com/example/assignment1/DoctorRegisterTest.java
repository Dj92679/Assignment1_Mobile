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

public class DoctorRegisterTest extends TestCase {

    DoctorRegister doctorRegister;
    String ED_Username, ED_Password, ED_Name, ED_Surname, ED_RegNum, ED_Number;

    @Rule
    public ActivityTestRule<DoctorRegister> activityTestRule = new ActivityTestRule<>(DoctorRegister.class);

    @Before
    public void setUp() throws Exception {
        doctorRegister = activityTestRule.getActivity();
        ED_Username = "DrFrank";
        ED_Password = "BrokenBone";
        ED_Name = "Frank";
        ED_Surname = "Spencer";
        ED_RegNum = "986";
        ED_Number = "6877687568";
        super.setUp();
    }

    @Test
    public void doctorRegTest()
    {
        onView(withId(R.id.D_RegisterUser)).perform(typeText(ED_Username));
        onView(withId(R.id.D_RegisterPass)).perform(typeText(ED_Password));
        onView(withId(R.id.D_RegisterFName)).perform(typeText(ED_Name));
        onView(withId(R.id.D_RegisterSurname)).perform(typeText(ED_Surname));
        onView(withId(R.id.D_RegisterRegNo)).perform(typeText(ED_RegNum));
        closeSoftKeyboard();
        onView(withId(R.id.D_RegisterNumber)).perform(typeText(ED_Number));
        closeSoftKeyboard();
        onView(withId(R.id.D_RegisterSubmit)).perform(click());

    }

    @After
    public void tearDown() throws Exception {
    }
}