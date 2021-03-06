package com.grp12.softskilltools.introduction;

import android.support.annotation.NonNull;

import com.cleveroad.slidingtutorial.Direction;
import com.cleveroad.slidingtutorial.PageFragment;
import com.cleveroad.slidingtutorial.TransformItem;
import com.galgespil.stvhendeop.menuapp.R;

/**
 * Created by mathiaslarsen on 13/01/2017.
 */

public class Page_2 extends PageFragment {

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_page_second;
    }

    /*******************************************************
     * This method handles the second page of the coachMark *
     *******************************************************/

    @NonNull
    @Override
    protected TransformItem[] getTransformItems() {
        return new TransformItem[]{
                TransformItem.create(R.id.ivFirstImage, Direction.RIGHT_TO_LEFT, 0.2f),
                TransformItem.create(R.id.ivSecondImage, Direction.LEFT_TO_RIGHT, 0.6f),
                TransformItem.create(R.id.ivThirdImage, Direction.RIGHT_TO_LEFT, 0.08f),
                TransformItem.create(R.id.ivFourthImage, Direction.LEFT_TO_RIGHT, 0.1f),
                TransformItem.create(R.id.ivFifthImage, Direction.LEFT_TO_RIGHT, 0.03f),
                TransformItem.create(R.id.ivSixthImage, Direction.LEFT_TO_RIGHT, 0.09f),
                TransformItem.create(R.id.ivSeventhImage, Direction.LEFT_TO_RIGHT, 0.14f),
                TransformItem.create(R.id.ivEighthImage, Direction.LEFT_TO_RIGHT, 0.07f)
        };
    }
}
