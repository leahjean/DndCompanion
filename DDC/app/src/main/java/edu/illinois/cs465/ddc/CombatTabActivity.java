package edu.illinois.cs465.ddc;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CombatTabActivity extends FragmentActivity {

    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(new CustomPagerAdapter(getSupportFragmentManager()));
    }

    class CustomPagerAdapter extends FragmentPagerAdapter {

        public CustomPagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position){
                case 0:
                    StatTab st = new StatTab();
                    return st;
                case 1:
                    AbilityTab at = new AbilityTab();
                    return at;
                default:
                    return null;
            }
//// Create fragment object
//            Fragment fragment = new DemoFragment();
//
//// Attach some data to the fragment
//// that we’ll use to populate our fragment layouts
//            Bundle args = new Bundle();
//            args.putInt("page_position", position + 1);
//
//// Set the arguments on the fragment
//// that will be fetched in the
//// DemoFragment@onCreateView
//            fragment.setArguments(args);
//            return fragment;
        }
        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + (position + 1);
        }
    }

    public static class DemoFragment extends Fragment {

        public DemoFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_demo, container, false);
            Bundle args = getArguments();
            ((TextView) rootView.findViewById(R.id.textView)).setText("Page " + args.getInt("page_position"));
            return rootView;
        }
    }
}
