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
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

/**
 * Created by faizmukti on 19-Oct-17.
 */
@RunWith(AndroidJUnit4.class)
public class MasjFormTest {
    @Rule
    public IntentsTestRule<UserRegisterActivity> mUserRegisterActivityTestRule =
            new IntentsTestRule<>(UserRegisterActivity.class);

    @Test
    public void berhasil_regis_takmir_ilangKecamatan() throws Exception {
        onView(withId(R.id.et_nama))
                .perform(typeText("Agus Sumarno")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_email))
                .perform(typeText("agussumarno@gmail.com")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_username))
                .perform(typeText("agusSumar")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_password))
                .perform(typeText("agus123456")).perform(closeSoftKeyboard());
        onView(withId(R.id.spnr_role)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("takmir"))).perform(click());
        onView(withId(R.id.btn_register))
                .perform(click());
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        Thread.sleep(3000);
        intended(hasComponent(MasjidFormActivity.class.getName()));
        onView(withId(R.id.et_nama))
                .perform(typeText("Masjid Annur")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_kota))
                .perform(typeText("Surabaya")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_alamat))
                .perform(typeText("Simo Hilir Barat 8H/9")).perform(closeSoftKeyboard());
        onView(withId(R.id.btn_register))
                .perform(click());
        onView(withText("Please enter kecamatan"))
                .inRoot(withDecorView(Matchers.not(Matchers.is(mUserRegisterActivityTestRule.getActivity().getWindow().getDecorView()))));
    }

    @Test
    public void berhasil_regis_takmir_ilang_nama() throws Exception {
        onView(withId(R.id.et_nama))
                .perform(typeText("Agus Sumarno")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_email))
                .perform(typeText("agussumarno@gmail.com")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_username))
                .perform(typeText("agusSumar")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_password))
                .perform(typeText("agus123456")).perform(closeSoftKeyboard());
        onView(withId(R.id.spnr_role)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("takmir"))).perform(click());
        onView(withId(R.id.btn_register))
                .perform(click());

        Thread.sleep(3000);
        intended(hasComponent(MasjidFormActivity.class.getName()));
        onView(withId(R.id.et_kecamatan))
                .perform(typeText("Sukomanunggal")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_kota))
                .perform(typeText("Surabaya")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_alamat))
                .perform(typeText("Simo Hilir Barat 8H/9")).perform(closeSoftKeyboard());
        onView(withId(R.id.btn_register))
                .perform(click());
        onView(withText("Please enter nama masjid"))
                .inRoot(withDecorView(Matchers.not(Matchers.is(mUserRegisterActivityTestRule.getActivity().getWindow().getDecorView()))));
    }

    @Test
    public void berhasil_regis_takmir_ilangKota() throws Exception {
        onView(withId(R.id.et_nama))
                .perform(typeText("Agus Sumarno")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_email))
                .perform(typeText("agussumarno@gmail.com")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_username))
                .perform(typeText("agusSumar")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_password))
                .perform(typeText("agus123456")).perform(closeSoftKeyboard());
        onView(withId(R.id.spnr_role)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("takmir"))).perform(click());
        onView(withId(R.id.btn_register))
                .perform(click());
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        Thread.sleep(3000);
        intended(hasComponent(MasjidFormActivity.class.getName()));
        onView(withId(R.id.et_nama))
                .perform(typeText("Masjid Annur")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_kecamatan))
                .perform(typeText("Sukomanunggal")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_alamat))
                .perform(typeText("Simo Hilir Barat 8H/9")).perform(closeSoftKeyboard());
        onView(withId(R.id.btn_register))
                .perform(click());
        onView(withText("Please enter kota"))
                .inRoot(withDecorView(Matchers.not(Matchers.is(mUserRegisterActivityTestRule.getActivity().getWindow().getDecorView()))));
    }

    @Test
    public void berhasil_regis_takmir_ilangAlamat() throws Exception {
        onView(withId(R.id.et_nama))
                .perform(typeText("Agus Sumarno")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_email))
                .perform(typeText("agussumarno@gmail.com")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_username))
                .perform(typeText("agusSumar")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_password))
                .perform(typeText("agus123456")).perform(closeSoftKeyboard());
        onView(withId(R.id.spnr_role)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("takmir"))).perform(click());
        onView(withId(R.id.btn_register))
                .perform(click());

        Thread.sleep(3000);
        intended(hasComponent(MasjidFormActivity.class.getName()));
        onView(withId(R.id.et_nama))
                .perform(typeText("Masjid Annur")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_kota))
                .perform(typeText("Surabaya")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_kecamatan))
                .perform(typeText("Sukomanunggal")).perform(closeSoftKeyboard());
        onView(withId(R.id.btn_register))
                .perform(click());
        onView(withText("Please enter alamat"))
                .inRoot(withDecorView(Matchers.not(Matchers.is(mUserRegisterActivityTestRule.getActivity().getWindow().getDecorView()))));
    }

    @Test
    public void berhasil_regis_takmir_sukses() throws Exception {
        onView(withId(R.id.et_nama))
                .perform(typeText("Agus Sumarno")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_email))
                .perform(typeText("agussumarno@gmail.com")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_username))
                .perform(typeText("agusSumar")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_password))
                .perform(typeText("agus123456")).perform(closeSoftKeyboard());
        onView(withId(R.id.spnr_role)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("takmir"))).perform(click());
        onView(withId(R.id.btn_register))
                .perform(click());

        Thread.sleep(3000);
        intended(hasComponent(MasjidFormActivity.class.getName()));
        onView(withId(R.id.et_nama))
                .perform(typeText("Masjid Annur")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_kota))
                .perform(typeText("Surabaya")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_alamat))
                .perform(typeText("Simo Hilir Barat 8H/9")).perform(closeSoftKeyboard());
        onView(withId(R.id.et_kecamatan))
                .perform(typeText("Sukomanunggal")).perform(closeSoftKeyboard());
        onView(withId(R.id.btn_register))
                .perform(click());
        Thread.sleep(3000);

    }

}
