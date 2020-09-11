package com.oluwasegun.gadsleaderboard;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.animation.Animator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;
import com.oluwasegun.gadsleaderboard.tabs.LeaderBoardFragment;
import com.oluwasegun.gadsleaderboard.tabs.SkillFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_CIRCULAR_REVEAL_X = "EXTRA_CIRCULAR_REVEAL_X";
    public static final String EXTRA_CIRCULAR_REVEAL_Y = "EXTRA_CIRCULAR_REVEAL_Y";

    View rootLayout;
    private int revealX;
    private int revealY;

    ViewPager viewPager;
    TabLayout tabLayout;
    TextView submit;

    SkillFragment skillFragment;
    LeaderBoardFragment topLearnerFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        skillFragment = new SkillFragment();
        topLearnerFragment = new LeaderBoardFragment();
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SubmitProject.class));
            }
        });

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        };
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

//
//        ImageButton btn = (ImageButton) findViewById(R.id.homeImage);
//        btn.setOnClickListener(this);

    }

//    protected void revealActivity(int x, int y){
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
//            float finalRadius = (float) (Math.max(rootLayout.getWidth(), rootLayout.getHeight()));
//            Animator circularReveal = ViewAnimationUtils.createCircularReveal();
//            circularReveal.setDuration(400);
//            circularReveal.setInterpolator(new AccelerateInterpolator());
//            rootLayout.setVisibility(View.VISIBLE);
//            circularReveal.start();
//        }
//        else {
//            finish();
//        }
//    }

    class MyPagerAdapter extends FragmentPagerAdapter{
        String [] fragmentNames = {" Learning Leader ", " Skill IQ Leader "};

        public MyPagerAdapter(FragmentManager fm, int behavior){
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new LeaderBoardFragment();
                case 1:
                    return new SkillFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return fragmentNames.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position){
            return fragmentNames[position];
        }
    }

//    @Override
//    public void onClick(View v)
//    {
//        // TODO Auto-generated method stub
//        Intent i = new Intent(getApplicationContext(),LeaderBoard.class);
//        startActivity(i);
//        setContentView(R.layout.leader_board);
//    }
}