package com.ukn.edu.tainex;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;

import com.ukn.edu.tainex.databinding.ActivityMainBinding;
import com.ukn.edu.tainex.ui.main.ExhibitFragment;
import com.ukn.edu.tainex.ui.main.IntroduceFragment;
import com.ukn.edu.tainex.ui.main.NewsFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Fragment> fragmentList;
    String[] titles;
    private ActivityMainBinding viewBinding;
    private NewsFragment newsFragment = new NewsFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());
        fragmentList = new ArrayList<>();
        fragmentList.add(new ExhibitFragment());
        fragmentList.add(newsFragment);
        fragmentList.add(new IntroduceFragment());

        titles = new String[]{
                getResources().getString(R.string.tab_text_1),
                getResources().getString(R.string.tab_text_2),
                getResources().getString(R.string.tab_text_3)};

        MyPagerAdapter myPagerAdapter
                = new MyPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager = viewBinding.viewPager;
        viewPager.setAdapter(myPagerAdapter);
        TabLayout tabs = viewBinding.tabs;
        tabs.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return true;
    }

    class MyPagerAdapter extends FragmentPagerAdapter{

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragmentList.get(i);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        public CharSequence getPageTitle(int i){
            return titles[i];
        }
    }
}