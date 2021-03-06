package edu.illinois.cs465.ddc;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.DimenRes;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import io.github.douglasjunior.androidSimpleTooltip.SimpleTooltip;

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

    /**
     * Add onclick listener to any view that will initialize a tooltip on click
     * Call when an on click listener has not been defined yet
     * Based on: https://github.com/douglasjunior/android-simple-tooltip
     * @param context current context can be obtained using getApplicationContext
     * @param view The view to add the tooltip text to
     * @param tooltipText The text that the tooltip will contain
     * @param gravity The direction that the tooltip will appear in
     */
    protected static void addSimpleTooltipListener(
            final Context context,
            View view,
            final String tooltipText,
            final int gravity
    ) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSimpleTooltip(context, view, tooltipText, gravity);
            }
        });
    }

    /**
     * Add a tooltip to the specified view
     * Call when on click listener is already defined
     * Based on: https://github.com/douglasjunior/android-simple-tooltip
     * @param context current context can be obtained using getApplicationContext
     * @param view The view to add the tooltip text to
     * @param tooltipText The text that the tooltip will contain
     * @param gravity The direction that the tooltip will appear in
     */
    protected static void addSimpleTooltip(Context context, View view, String tooltipText, int gravity) {
        new SimpleTooltip.Builder(context)
                .anchorView(view)
                .text(tooltipText)
                .gravity(gravity)
                .margin((float) 1)
                .padding((float) 20)
                .build()
                .show();
    }

    /**
     * This method converts device specific pixels to density independent pixels.
     * Src: https://stackoverflow.com/questions/4605527/converting-pixels-to-dp
     *
     * @param px A value in px (pixels) unit. Which we need to convert into db
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent dp equivalent to px value
     */
    public static float convertPixelsToDp(float px, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float dp = px / ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return dp;
    }

    // Hashmap to store tooltip messages for commonly used terms like STR, DEX, etc.
    protected static final Map<String, String> tooltipTexts = initTooltipTexts();
    private static Map<String, String> initTooltipTexts() {
        Map<String, String> tooltipTexts = new HashMap<>();
        tooltipTexts.put("STR", "Strength -- a measure of your physical power.");
        tooltipTexts.put("DEX", "Dexterity -- how agile you are.");
        tooltipTexts.put("CON", "Constitution -- how much you can endure.");
        tooltipTexts.put("INT", "Intelligence -- your reasoning and memory.");
        tooltipTexts.put("WIS", "Wisdom -- your intuition and insight.");
        tooltipTexts.put("CHA", "Charisma -- your charm and wit.");
        tooltipTexts.put("Proficiency", "An innate bonus to you overall skill.");
        tooltipTexts.put("athletics", "Useful for climbing, grappling, and more!");
        tooltipTexts.put("acrobatics", "When you need to do some flips!");
        tooltipTexts.put("sleight of hand", "For stealing things or performing tricks.");
        tooltipTexts.put("stealth", "Want to sneak around without being seen?");
        tooltipTexts.put("arcana", "Your ability to detect things of magical origin.");
        tooltipTexts.put("history", "Your ability to recall past events.");
        tooltipTexts.put("investigation", "When you need to search for clues!");
        tooltipTexts.put("nature", "When you need to know about the forest.");
        tooltipTexts.put("religion", "For keeping track of the world's deities.");
        tooltipTexts.put("animal handling", "Ever try to hold a baby dragon?");
        tooltipTexts.put("insight", "For figuring out someone's motivations.");
        tooltipTexts.put("medicine", "Great for keeping downed allies safe!");
        tooltipTexts.put("perception", "For seeing everything around you.");
        tooltipTexts.put("survival", "Great for knowing what's safe to eat.");
        tooltipTexts.put("deception", "For lying with a straight face.");
        tooltipTexts.put("intimidation", "Good for bluffing your way out of fights.");
        tooltipTexts.put("performance", "When you need a distraction!");
        tooltipTexts.put("persuasion", "Make friends and influence people.");
        return Collections.unmodifiableMap(tooltipTexts);
    }
}
