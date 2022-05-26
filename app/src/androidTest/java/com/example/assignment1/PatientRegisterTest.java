package com.example.assignment1;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.rule.ActivityTestRule;

import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.Test;

public class PatientRegisterTest extends TestCase {

    String EP_Username, EP_Password, EP_FName, EP_Surname, EP_Address, EP_Age, EP_DOB, EP_Gender, EP_PhoneNumber, EP_EContact, EP_ENumber;

    @Rule
    public ActivityTestRule<PatientRegister> activityTestRule = new ActivityTestRule<>(PatientRegister.class);

    public void setUp() throws Exception {
        EP_Username = "JSmith4";
        EP_Password = "Password1234";
        EP_FName = "John";
        EP_Surname = "Smith";
        EP_Address = "4 Galloway Drive";
        EP_Age = "42";
        EP_DOB = "26/12/1980";
        EP_Gender = "Male";
        EP_PhoneNumber = "02798483494";
        EP_EContact = "Wife";
        EP_ENumber = "0279856495";
        super.setUp();
    }

    @Test
    public void patientRegister()
    {
        onView(withId(R.id.P_RegisterUser)).perform(typeText(EP_Username));
        onView(withId(R.id.P_RegisterPass)).perform(typeText(EP_Password));
        onView(withId(R.id.P_RegisterFName)).perform(typeText(EP_FName));
        onView(withId(R.id.P_RegisterSurname)).perform(typeText(EP_Surname));
        onView(withId(R.id.P_RegisterAddress)).perform(typeText(EP_Address));
        onView(withId(R.id.P_RegisterAge)).perform(typeText(EP_Age));
        onView(withId(R.id.P_RegisterDOB)).perform(typeText(EP_DOB));
        onView(withId(R.id.P_RegisterGender)).perform(typeText(EP_Gender));
        onView(withId(R.id.P_RegisterNumber)).perform(typeText(EP_PhoneNumber));
        onView(withId(R.id.P_RegisterEContact)).perform(typeText(EP_EContact));
        onView(withId(R.id.P_RegisterENumber)).perform(typeText(EP_ENumber));
        closeSoftKeyboard();
        onView(withId(R.id.Patientsubmit)).perform(click());
    }

    public void tearDown() throws Exception {
    }
}