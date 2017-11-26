package edu.illinois.cs465.ddc;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * General utility functions useable across a variety of screens
 */

public class GeneralUtil {
    // Private constructor to prevent instantiation of utility class
    private GeneralUtil() {}

    /**
     * Call function to hide keyboard when opened on any text input fields
     * https://stackoverflow.com/questions/4165414/how-to-hide-soft-keyboard-on-android-after-clicking-outside-edittext
     * @param context Can be obtained using getApplicationContext()
     * @param view base parameter for all event-listeners. Can also be obtained using findViewById
     */
    protected static void hideKeyboard(Context context, View view) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
