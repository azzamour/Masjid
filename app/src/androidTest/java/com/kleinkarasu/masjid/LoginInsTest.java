package com.kleinkarasu.masjid;

/**import android.app.Activity;
 import android.content.Context;
 import android.support.test.InstrumentationRegistry;*/
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.google.firebase.auth.FirebaseAuth;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.app.PendingIntent.getActivity;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.intent.Intents.intended;
/**import static org.junit.Assert.*;
 import static android.support.test.espresso.assertion.ViewAssertions.matches;
 import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
 import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
 import static android.support.test.espresso.matcher.ViewMatchers.withText;
 import static org.hamcrest.Matchers.is;
 import static org.hamcrest.Matchers.not;

 /**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class LoginInsTest {

    @Rule
    public IntentsTestRule<LoginActivity> mLoginActivityActivityTestRule =
            new IntentsTestRule<>(LoginActivity.class);

    @Test
    public void cekLoginBtn_kosongan_pwd() throws Exception {
        onView(withId(R.id.et_email))
                .perform(click()).perform(typeText("faizmukti@gmail.com")).perform(closeSoftKeyboard());
        onView(withId(R.id.btn_signin))
                .perform(click());
        onView(withText(R.string.toast_text_email))
                .inRoot(withDecorView(Matchers.not(Matchers.is(mLoginActivityActivityTestRule.getActivity().getWindow().getDecorView()))));

    }
    @Test
    public void cekLoginBtn_kosongan_email() throws Exception{
        onView(withId(R.id.et_password))
                .perform(click()).perform(typeText("passwordku1234")).perform(closeSoftKeyboard());
        onView(withId(R.id.btn_signin))
                .perform(click());
        onView(withText(R.string.toast_text_pwd))
                .inRoot(withDecorView(Matchers.not(Matchers.is(mLoginActivityActivityTestRule.getActivity().getWindow().getDecorView()))));

    }
    @Test
    public void cekLoginBtn_kosongan_email_pwd() throws Exception{
        onView(withId(R.id.btn_signin))
                .perform(click());
        onView(withText("Please enter email and password"))
                .inRoot(withDecorView(Matchers.not(Matchers.is(mLoginActivityActivityTestRule.getActivity().getWindow().getDecorView()))));
        onView(withText(R.string.toast_text_email))
                .inRoot(withDecorView(Matchers.not(Matchers.is(mLoginActivityActivityTestRule.getActivity().getWindow().getDecorView()))));
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    @Test
    public void cekLoginBtn_bener_email_salah_password() throws Exception{
        onView(withId(R.id.et_email))
                .perform(click()).perform(typeText("faizmukti@gmail.com")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_password))
                .perform(click()).perform(typeText("passsaya1234")).perform(closeSoftKeyboard());
        onView(withId(R.id.btn_signin))
                .perform(click());
        onView(withText(R.string.toast_text_wrong))
                .inRoot(withDecorView(Matchers.not(Matchers.is(mLoginActivityActivityTestRule.getActivity().getWindow().getDecorView()))));
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    @Test
    public void cekLoginBtn_bener_password_salah_email() throws Exception{
        onView(withId(R.id.et_email))
                .perform(click()).perform(typeText("faizmukto@gmail.com")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_password))
                .perform(click()).perform(typeText("password1234")).perform(closeSoftKeyboard());
        onView(withId(R.id.btn_signin))
                .perform(click());
        onView(withText(R.string.toast_text_wrong))
                .inRoot(withDecorView(Matchers.not(Matchers.is(mLoginActivityActivityTestRule.getActivity().getWindow().getDecorView()))));
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void cekLoginBtn_bener_password_bener_email() throws Exception{
        onView(withId(R.id.et_email))
                .perform(click()).perform(typeText("admin@user.com")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_password))
                .perform(click()).perform(typeText("123456")).perform(closeSoftKeyboard());
        onView(withId(R.id.btn_signin))
                .perform(click());

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        intended(hasComponent(WargaActivity.class.getName()));
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signOut();
    }
}
