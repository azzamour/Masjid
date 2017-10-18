package com.kleinkarasu.masjid;

import android.support.test.espresso.action.TypeTextAction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

/**
 * Created by faizmukti on 18-Oct-17.
 */
@RunWith(AndroidJUnit4.class)
public class RegInsTest {
    @Rule
    public ActivityTestRule<UserRegisterActivity> mUserRegisterActivityActivityTestRule =
            new ActivityTestRule<UserRegisterActivity>(UserRegisterActivity.class);

    @Test
    public void name_kosong()throws Exception{
        onView(withId(R.id.et_email))
                .perform(typeText("bejo@gmail.com")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_username))
                .perform(typeText("bejoSugi")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_password))
                .perform(typeText("bejo1234")).perform(closeSoftKeyboard());
        onView(withId(R.id.spnr_role)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("warga"))).perform(click());
        onView(withId(R.id.btn_register))
                .perform(click());
    }
    public void userName_kosong()throws Exception{

    }
}
