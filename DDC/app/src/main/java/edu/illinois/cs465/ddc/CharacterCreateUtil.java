package edu.illinois.cs465.ddc;


/**
 * Utility functions for character creation activities
 */
public final class CharacterCreateUtil {
    // Empty private constructor to prevent instantiation of the utility class
    private CharacterCreateUtil() {}

    /**
     * Scroll to the next portrait in the race and class select screens
     * @param viewPager ViewPager is the carousel of portraits
     */
    public static void raceClassScrollNextPortrait(WrapContentHeightViewPager viewPager) {
        int currItem = viewPager.getCurrentItem();
        int nextItem = currItem + 1;
        int classCount = ((PortraitViewPageAdapter) viewPager.getAdapter()).getCount();
        if (nextItem > classCount - 1) {
            nextItem = 0;
        }
        viewPager.setCurrentItem(nextItem, true);
    }

    /**
     * Scroll to the previous portrait in the race and class select screens
     * @param viewPager ViewPager is the carousel of portraits
     */
    public static void raceClassScrollPrevPortrait(WrapContentHeightViewPager viewPager) {
        int currItem = viewPager.getCurrentItem();
        int prevItem = currItem - 1;
        if (prevItem < 0) {
            prevItem = ((PortraitViewPageAdapter) viewPager.getAdapter()).getCount();
        }
        viewPager.setCurrentItem(prevItem, true);
    }
}
