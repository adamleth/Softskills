package com.grp12.softskilltools.Fragment;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.grp12.softskilltools.Activities.MainMenu;
import com.grp12.softskilltools.Util.AnimationUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.galgespil.stvhendeop.menuapp.R;
import com.grp12.softskilltools.Entities.ProfileMessages;
import com.grp12.softskilltools.Util.ArcImageView;
import com.grp12.softskilltools.Util.BaseAdaptorHelper;
import com.grp12.softskilltools.Util.QuickAdaptor;

import java.util.ArrayList;
import java.util.List;

import io.codetail.animation.SupportAnimator;
import io.codetail.animation.ViewAnimationUtils;


/**
 * Created by BLiveInHack on 19-01-2016.
 */
public class PrefFragment extends Fragment {
    public TextView profile_name, tag1, placeholder, title, profile_name_1;
    public ImageView menu, profile_bg, img2, img3;
    public View myView;
    public ArcImageView profile_image;
    public QuickAdaptor<ProfileMessages> adaptor;
    public RecyclerView rv;
    public List<ProfileMessages> listData = new ArrayList<>();
    public SupportAnimator animator;
    public RelativeLayout relative;
    public LinearLayout root;
    public String[] colors = {"#4DABF6", "#8B76AF", "#D95347", "#7CBF61", "#CF90AB",};

    public PrefFragment(){

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.frag_pref, container, false);


        profile_name = (TextView) myView.findViewById(R.id.profile_name);
        profile_bg = (ImageView) myView.findViewById(R.id.profile_bg_5);
        profile_image = (ArcImageView) myView.findViewById(R.id.profile_image);
        relative = (RelativeLayout) myView.findViewById(R.id.top_wrapper);
        root = (LinearLayout) myView.findViewById(R.id.root);

        tag1 = (TextView) myView.findViewById(R.id.tag1);
        placeholder = (TextView) myView.findViewById(R.id.placeholder);

        rv = (RecyclerView) myView.findViewById(R.id.rv);

        profile_name.setText(MainMenu.getInstance().getUser().getName().toString() + " " + MainMenu.getInstance().getUser().getSurName().toString());
        tag1.setText(MainMenu.getInstance().getUser().getEmail().toString());

        AnimationUtil.enterTop(profile_name, 1500);
        AnimationUtil.enterTop(tag1, 1700);

        profile_image.setBorderColor(0x55000000);
        profile_image.setBorderWidth(15);
        profile_image.setProgress(100);


        AnimationUtil.popOut(profile_image, 1500);

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
        }, 1700);

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
            }
        }, 300);


        adaptor = new QuickAdaptor<ProfileMessages>(getActivity(), R.layout.row_layout) {
            @Override
            protected void convert(final BaseAdaptorHelper helper, ProfileMessages item) {

                helper.getImageView(R.id.action_img).setImageResource(item.getImage());
                helper.getTextView(R.id.action).setText(item.getFrom());
                //helper.getTextView(R.id.action).setTextColor(Color.parseColor(colors[helper.getAdapterPosition()]));


                final View v = helper.getView(R.id.root);
                v.setBackgroundColor(Color.parseColor(colors[helper.getAdapterPosition()]));
                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AnimationUtil.rotateClockWiseVisible(helper.getImageView(R.id.action_img),100);
                        placeholder.setVisibility(View.VISIBLE);
                        int cx = (view.getLeft() + view.getRight()) / 2;
                        int cy = (view.getTop());

                        // get the final radius for the clipping circle
                        int dx = Math.max(cx, view.getWidth() - cx);
                        int dy = Math.max(cy, view.getHeight() - cy);
                        float finalRadius = (float) Math.hypot(dx, dy);


                        placeholder.setBackgroundColor(Color.parseColor(colors[helper.getAdapterPosition()]));
                        animator = ViewAnimationUtils.createCircularReveal(placeholder, cx, cy, 0,
                                finalRadius,
                                View.LAYER_TYPE_SOFTWARE);
                        animator.setDuration(500);
                        animator.setInterpolator(new AccelerateDecelerateInterpolator());
                        animator.start();
                    }
                });

            }

        };

        rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rv.setAdapter(adaptor);

        listData.add(new ProfileMessages("1 minut siden", "Profil", "Test besked", R.mipmap.avatar));
        listData.add(new ProfileMessages("21 minutter siden", "Tilpas", "Test besked", R.mipmap.pencil));
        listData.add(new ProfileMessages("1 time siden", "Hist.", "Test besked", R.mipmap.infographic));
        listData.add(new ProfileMessages("2 timer siden", "Bill.", "Test besked", R.mipmap.insertpic));
        listData.add(new ProfileMessages("2 timer siden", "Team", "Test besked", R.mipmap.users));
        adaptor.addAll(listData);




        return myView;

    }



}
