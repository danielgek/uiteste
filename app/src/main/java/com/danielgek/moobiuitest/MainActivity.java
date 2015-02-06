package com.danielgek.moobiuitest;

import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.danielgek.moobiuitest.fragments.Fragment1;
import com.danielgek.moobiuitest.fragments.Fragment2;
import com.danielgek.moobiuitest.view.SlidingTabLayout;


public class MainActivity extends ActionBarActivity {



    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;
    private Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);


        if(toolbar != null){

            toolbar.setTitle("Navigation Drawer");
            setSupportActionBar(toolbar);

        }

        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        FragmentManager fragmentManager = getSupportFragmentManager();

        mViewPager.setAdapter(new SamplePagerAdapter(fragmentManager));

        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setViewPager(mViewPager);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        //drawerLayout.setStatusBarBackgroundColor(getResources().getColor(R.color.colorAccent));
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.drawer_open,R.string.drawer_close){
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawerLayout.setDrawerListener(drawerToggle);



    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    class SamplePagerAdapter extends FragmentStatePagerAdapter {

        public SamplePagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public int getCount() {
            return 3;
        }




        @Override
        public CharSequence getPageTitle(int position) {
            return "Item " + (position + 1);
        }


        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position){
                case 0: fragment = new Fragment1();break;
                case 1: fragment = new Fragment2();break;
                default: fragment = new Fragment1();
            }

            return fragment;
        }

    }
}
