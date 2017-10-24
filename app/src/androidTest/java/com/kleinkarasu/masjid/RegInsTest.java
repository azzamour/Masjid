package com.kleinkarasu.masjid;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static android.support.test.espresso.intent.Intents.intended;

/**
 * Created by faizmukti on 18-Oct-17.
 */
@RunWith(AndroidJUnit4.class)
public class RegInsTest {
    @Rule
    public IntentsTestRule<UserRegisterActivity> mUserRegisterActivityActivityTestRule =
            new IntentsTestRule<UserRegisterActivity>(UserRegisterActivity.class);


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
        onView(withText(R.string.toast_text_name))
                .inRoot(withDecorView(Matchers.not(Matchers.is(mUserRegisterActivityActivityTestRule.getActivity().getWindow().getDecorView()))));
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Test
    public void userName_kosong()throws Exception{
        onView(withId(R.id.et_email))
                .perform(typeText("bejo@gmail.com")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_nama))
                .perform(typeText("Bejo Sugiantoro")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_password))
                .perform(typeText("bejo1234")).perform(closeSoftKeyboard());
        onView(withId(R.id.spnr_role)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("warga"))).perform(click());
        onView(withId(R.id.btn_register))
                .perform(click());
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Test
    public void email_kosong()throws Exception {
        onView(withId(R.id.et_username))
                .perform(typeText("bejoSugi")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_nama))
                .perform(typeText("Bejo Sugiantoro")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_password))
                .perform(typeText("bejo1234")).perform(closeSoftKeyboard());
        onView(withId(R.id.spnr_role)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("warga"))).perform(click());
        onView(withId(R.id.btn_register))
                .perform(click());
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Test
    public void pwd_kosong()throws Exception {
        onView(withId(R.id.et_email))
                .perform(typeText("bejo@gmail.com")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_nama))
                .perform(typeText("Bejo Sugiantoro")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_username))
                .perform(typeText("bejoSugi")).perform(closeSoftKeyboard());
        onView(withId(R.id.spnr_role)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("warga"))).perform(click());
        onView(withId(R.id.btn_register))
                .perform(click());
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }




    @Test
    public void name_kosong_takmir()throws Exception{
        onView(withId(R.id.et_email))
                .perform(typeText("bejo@gmail.com")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_username))
                .perform(typeText("bejoSugi")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_password))
                .perform(typeText("bejo1234")).perform(closeSoftKeyboard());
        onView(withId(R.id.spnr_role)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("takmir"))).perform(click());
        onView(withId(R.id.btn_register))
                .perform(click());
        onView(withText(R.string.toast_text_name))
                .inRoot(withDecorView(Matchers.not(Matchers.is(mUserRegisterActivityActivityTestRule.getActivity().getWindow().getDecorView()))));
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Test
    public void userName_kosong_takmir()throws Exception{
        onView(withId(R.id.et_email))
                .perform(typeText("bejo@gmail.com")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_nama))
                .perform(typeText("Bejo Sugiantoro")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_password))
                .perform(typeText("bejo1234")).perform(closeSoftKeyboard());
        onView(withId(R.id.spnr_role)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("takmir"))).perform(click());
        onView(withId(R.id.btn_register))
                .perform(click());
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Test
    public void email_kosong_takmir()throws Exception {
        onView(withId(R.id.et_username))
                .perform(typeText("bejoSugi")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_nama))
                .perform(typeText("Bejo Sugiantoro")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_password))
                .perform(typeText("bejo1234")).perform(closeSoftKeyboard());
        onView(withId(R.id.spnr_role)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("takmir"))).perform(click());
        onView(withId(R.id.btn_register))
                .perform(click());
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Test
    public void pwd_kosong_takmir()throws Exception {
        onView(withId(R.id.et_email))
                .perform(typeText("bejo@gmail.com")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_nama))
                .perform(typeText("Bejo Sugiantoro")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_username))
                .perform(typeText("bejoSugi")).perform(closeSoftKeyboard());
        onView(withId(R.id.spnr_role)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("takmir"))).perform(click());
        onView(withId(R.id.btn_register))
                .perform(click());
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Test
    public void gagal_regis_warga()throws Exception{
        onView(withId(R.id.et_nama))
                .perform(typeText("Bejo Sugiantoro")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_email))
                .perform(typeText("bejo@gmail.com")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_username))
                .perform(typeText("bejoSugi")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_password))
                .perform(typeText("12")).perform(closeSoftKeyboard());
        onView(withId(R.id.spnr_role)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("warga"))).perform(click());
        onView(withId(R.id.btn_register))
                .perform(click());
        onView(withText("Could not register... please try again"))
                .inRoot(withDecorView(Matchers.not(Matchers.is(mUserRegisterActivityActivityTestRule.getActivity().getWindow().getDecorView()))));
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void gagal_regis_takmir()throws Exception{
        onView(withId(R.id.et_nama))
                .perform(typeText("Bejo Sugiantoro")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_email))
                .perform(typeText("bejo@gmail.com")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_username))
                .perform(typeText("bejoSugi")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_password))
                .perform(typeText("12")).perform(closeSoftKeyboard());
        onView(withId(R.id.spnr_role)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("takmir"))).perform(click());
        onView(withId(R.id.btn_register))
                .perform(click());
        onView(withText("Could not register... please try again"))
                .inRoot(withDecorView(Matchers.not(Matchers.is(mUserRegisterActivityActivityTestRule.getActivity().getWindow().getDecorView()))));
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Test
    public void berhasil_regis_warga() throws Exception {
        onView(withId(R.id.et_nama))
                .perform(typeText("Bejo Sugiantoroyo")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_email))
                .perform(typeText("bejoyo@gmail.com")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_username))
                .perform(typeText("bejoSugiyo")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_password))
                .perform(typeText("1234567")).perform(closeSoftKeyboard());
        onView(withId(R.id.spnr_role)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("warga"))).perform(click());
        onView(withId(R.id.btn_register))
                .perform(click());
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        Thread.sleep(3000);
        intended(hasComponent(WargaActivity.class.getName()));
    }

}
