package com.grp12.softskilltools.Fragment;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.grp12.softskilltools.Activities.MainMenu;
import com.grp12.softskilltools.Entities.User;
import com.grp12.softskilltools.Util.AnimationUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.galgespil.stvhendeop.menuapp.R;
import com.grp12.softskilltools.Entities.ProfileMessages;
import com.grp12.softskilltools.Util.ArcImageView;

import java.util.ArrayList;
import java.util.List;

import io.codetail.animation.SupportAnimator;
import io.codetail.animation.ViewAnimationUtils;


public class PrefFragment extends Fragment {
    public TextView profile_name, tag1, title;
    public ImageView profile_bg;
    public View myView;
    public ArcImageView profile_image;
    public ViewPager pager;
    public List<ProfileMessages> listData = new ArrayList<>();
    public SupportAnimator animator;
    public RelativeLayout relative;
    public LinearLayout root;
    public MyPagerAdapter adaptor;
    public TabLayout tabs;
    public String[] colors = {"#4DABF6", "#8B76AF", "#D95347", "#7CBF61", "#CF90AB",};
    private String tabTitles[] = new String[] { "Min konto", "Tilpas", "Statistik" };
    private User user;

    public PrefFragment() {

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.frag_pref, container, false);
        user = MainMenu.getInstance().getUser();
        tabs = (TabLayout) myView.findViewById(R.id.tabs);
        profile_name = (TextView) myView.findViewById(R.id.profile_name);
        profile_bg = (ImageView) myView.findViewById(R.id.profile_bg_5);
        profile_image = (ArcImageView) myView.findViewById(R.id.profile_image);
        relative = (RelativeLayout) myView.findViewById(R.id.top_wrapper);
        root = (LinearLayout) myView.findViewById(R.id.root);
        pager = (ViewPager) myView.findViewById(R.id.viewPager);
        tag1 = (TextView) myView.findViewById(R.id.tag1);
        adaptor = new MyPagerAdapter(getFragmentManager());
        tabs.setupWithViewPager(pager);
        pager.setAdapter(adaptor);
        profile_name.setText(user.getName().toString() + " " + user.getSurName().toString());
        tag1.setText(user.getEmail().toString());

        AnimationUtil.enterTop(profile_name, 700);
        AnimationUtil.enterTop(tag1, 900);

        profile_image.setBorderColor(0x55000000);
        profile_image.setBorderWidth(15);
        profile_image.setProgress(100);


        AnimationUtil.popOut(profile_image, 700);

        profile_bg.postDelayed(new Runnable() {
            @Override
            public void run() {
                profile_bg.setVisibility(View.VISIBLE);
                animator = ViewAnimationUtils.createCircularReveal(profile_bg,
                        profile_bg.getRight() / 2, profile_bg.getBottom() / 2, 0,
                        AnimationUtil.hypo(profile_bg.getHeight(), profile_bg.getWidth()),
                        View.LAYER_TYPE_SOFTWARE);
                animator.setDuration(500);
                animator.setInterpolator(new AccelerateDecelerateInterpolator());
                animator.start();
            }
        }, 800);

        root.postDelayed(new Runnable() {
            @Override
            public void run() {
                root.setVisibility(View.VISIBLE);
                animator = ViewAnimationUtils.createCircularReveal(root,
                        0, (int) (root.getBottom() * 0.66), 0,
                        AnimationUtil.hypo(root.getHeight(), root.getWidth()),
                        View.LAYER_TYPE_SOFTWARE);
                animator.setDuration(500);
                animator.setInterpolator(new AccelerateDecelerateInterpolator());
                animator.start();
                AnimationUtil.enterLeft(tabs,300);
                AnimationUtil.enterBottom(pager,350);
            }
        }, 100);


        return myView;

    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        /******************************************************************************
         * This method creates a new instance of the different pages in the viewPager *
         ******************************************************************************/

        @Override
        public Fragment getItem(int position) {
            switch (position) {


                case 0: return FirstFragment.newInstance(user.getName().toString(),user.getSurName().toString(),user.getEmail().toString(),user.getPhone().toString());
                case 1: return SecondFragment.newInstance(user);
                case 2: return ThirdFragment.newInstance("ThirdFragment, Instance 1");
                default: return ThirdFragment.newInstance("ThirdFragment, Default");
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // Generate title based on item position
            return tabTitles[position];
        }


        @Override
        public int getCount() {
            return 3;
        }
    }
}
