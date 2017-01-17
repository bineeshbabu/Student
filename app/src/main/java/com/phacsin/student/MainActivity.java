package com.phacsin.student;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.phacsin.student.fragments.Fragment_1;
import com.phacsin.student.fragments.Fragment_2;
import com.phacsin.student.fragments.Fragment_3;

import java.util.ArrayList;
import java.util.List;

import static com.phacsin.student.R.id.tabs;
public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ImageView img_send,img_logout;
    private int[] tabicons={R.drawable.atte_white,R.drawable.mark_white,R.drawable.not_white,R.drawable.atte_grey,R.drawable.mark_grey,R.drawable.not_grey};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img_send =(ImageView) findViewById(R.id.send_message);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        img_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),SendMessage.class);
                startActivity(i);
            }
        });
        tabLayout = (TabLayout) findViewById(tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabicons[0]);
        tabLayout.getTabAt(1).setIcon(tabicons[4]);
        tabLayout.getTabAt(2).setIcon(tabicons[5]);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tabLayout.getSelectedTabPosition();
                if(tabLayout.getSelectedTabPosition()==0){
                    tabLayout.getTabAt(0).setIcon(tabicons[0]);
                    tabLayout.getTabAt(1).setIcon(tabicons[4]);
                    tabLayout.getTabAt(2).setIcon(tabicons[5]);
                }
                if(tabLayout.getSelectedTabPosition()==1){
                    tabLayout.getTabAt(0).setIcon(tabicons[3]);
                    tabLayout.getTabAt(1).setIcon(tabicons[1]);
                    tabLayout.getTabAt(2).setIcon(tabicons[5]);

                }
                else if(tabLayout.getSelectedTabPosition()==2){
                    tabLayout.getTabAt(0).setIcon(tabicons[3]);
                    tabLayout.getTabAt(1).setIcon(tabicons[4]);
                    tabLayout.getTabAt(2).setIcon(tabicons[2]);

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Fragment_1(), "Attendance");
        adapter.addFragment(new Fragment_2(), "Exam");
        adapter.addFragment(new Fragment_3(), "Notifications");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
