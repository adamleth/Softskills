package com.grp12.softskilltools.Fragment;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import com.galgespil.stvhendeop.menuapp.R;
import com.grp12.softskilltools.Activities.MainMenu;
import com.grp12.softskilltools.Entities.DISC;
import com.grp12.softskilltools.Entities.Question;
import com.grp12.softskilltools.Util.AnimationUtil;

/**
 * Created by mathiaslarsen on 27/11/2016.
 */

public class DISCFragment extends Fragment implements View.OnClickListener {


    Button B10,B11,B12,B13,B14,B15,B20,B21,B22,B23,B24,B25,Next;
    DISC test;
    private Question currentQuestion1, currentQuestion2;
    boolean finished = false;
    private int q1,q2;
    viewHolder holder;


    View myView;

    private Question current;

    public DISCFragment() {

        test = (DISC)SafeFragment.getInstance().getTempItem();
        q1 = 0;
        q2 = 0;
        holder = new viewHolder();
        this.currentQuestion1 = null;
        this.currentQuestion2 = null;


    }

    /***************************************************
     * This method initializes all the screen elements *
     ***************************************************/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.frag_disc_test, container, false);

        holder.question1 = (TextView) myView.findViewById(R.id.textView6);
        holder.question2 = (TextView) myView.findViewById(R.id.textView7);
        holder.alert = (TextView) myView.findViewById(R.id.Alert);
        holder.progress = (TextView) myView.findViewById(R.id.discProgressText);
        B10 = (Button) myView.findViewById(R.id.button14);
        B11 = (Button) myView.findViewById(R.id.button13);
        B12 = (Button) myView.findViewById(R.id.button12);
        B13 = (Button) myView.findViewById(R.id.button11);
        B14 = (Button) myView.findViewById(R.id.button8);
        B15 = (Button) myView.findViewById(R.id.button5);
        B20 = (Button) myView.findViewById(R.id.button20);
        B21 = (Button) myView.findViewById(R.id.button19);
        B22 = (Button) myView.findViewById(R.id.button18);
        B23 = (Button) myView.findViewById(R.id.button17);
        B24 = (Button) myView.findViewById(R.id.button16);
        B25 = (Button) myView.findViewById(R.id.button15);
        Next = (Button) myView.findViewById(R.id.button4);
        B10.setOnClickListener(this);
        B11.setOnClickListener(this);
        B12.setOnClickListener(this);
        B13.setOnClickListener(this);
        B14.setOnClickListener(this);
        B15.setOnClickListener(this);
        B20.setOnClickListener(this);
        B21.setOnClickListener(this);
        B22.setOnClickListener(this);
        B23.setOnClickListener(this);
        B24.setOnClickListener(this);
        B25.setOnClickListener(this);
        Next.setOnClickListener(this);
        this.currentQuestion1 = loadQuestion(holder.question1);
        this.currentQuestion2 = loadQuestion(holder.question2);
        setProgressOnScreen(currentQuestion2);
        resetButtonColors();
        return myView;
    }

    /******************************************************
     * This method changes the view and updates the score *
     ******************************************************/

    public void next() {

        if (q1 + q2 == 5) {
            resetButtonColors();
            update(currentQuestion1,q1);
            update(currentQuestion2,q2);
            currentQuestion1 = loadQuestion(holder.question1);
            currentQuestion2 = loadQuestion(holder.question2);
            holder.alert.setVisibility(View.GONE);
            holder.progress.setVisibility(View.VISIBLE);
            q1 = 0;
            q2 = 0;
            setProgressOnScreen(currentQuestion2);

        }

        else{
            holder.progress.setVisibility(View.GONE);
            holder.alert.setVisibility(View.VISIBLE);
        }
    }

    /********************************************
     * This method shows the progress on screen *
     ********************************************/

    public void setProgressOnScreen(Question question){
        int currentQuestion = test.getQuestionNumber(question);
        holder.progress.setText("Side "+currentQuestion/2+" af " + test.totalQuestions/2);
    }

    /**********************************************
     * This method updates the question and score *
     **********************************************/

    public void update(Question question, int score) {

        test.setQuestionAnswered(question);
        test.setScore(question,score);
    }

    /***************************************
     * This method loads the next question *
     ***************************************/

    public Question loadQuestion(TextView placeHolder) {

        current = test.QUEUELOGIC();

            if (current == null) {

                AnimationUtil.popIn(Next,100);
                Next.setText("Se resultat");
                AnimationUtil.popOut(Next,300);
                AnimationUtil.popIn(holder.progress,60);
                finished = true;


            } else {

                placeHolder.setText(current.getQuestion());

            }

        return current;
    }


    static class viewHolder {
        TextView question1,question2, alert, progress;
    }

    /************************************************
     * This method resets all colors of the buttons *
     ************************************************/

    public void resetButtonColors(){
//        B10.setBackgroundResource(R.drawable.button_profile_std);
//        B11.setBackgroundResource(R.drawable.button_profile_std);
//        B12.setBackgroundResource(R.drawable.button_profile_std);
//        B13.setBackgroundResource(R.drawable.button_profile_std);
//        B14.setBackgroundResource(R.drawable.button_profile_std);
//        B15.setBackgroundResource(R.drawable.button_profile_std);
//        B20.setBackgroundResource(R.drawable.button_profile_std);
//        B21.setBackgroundResource(R.drawable.button_profile_std);
//        B22.setBackgroundResource(R.drawable.button_profile_std);
//        B23.setBackgroundResource(R.drawable.button_profile_std);
//        B24.setBackgroundResource(R.drawable.button_profile_std);
//        B24.setBackgroundResource(R.drawable.button_profile_std);
//        B25.setBackgroundResource(R.drawable.button_profile_std);
        B10.setBackgroundResource(R.drawable.button_profile_std);
        B11.setBackgroundResource(R.drawable.button_profile_std);
        B12.setBackgroundResource(R.drawable.button_profile_std);
        B13.setBackgroundResource(R.drawable.button_profile_std);
        B14.setBackgroundResource(R.drawable.button_profile_std);
        B15.setBackgroundResource(R.drawable.button_profile_std);
        B20.setBackgroundResource(R.drawable.button_profile_std);
        B21.setBackgroundResource(R.drawable.button_profile_std);
        B22.setBackgroundResource(R.drawable.button_profile_std);
        B23.setBackgroundResource(R.drawable.button_profile_std);
        B24.setBackgroundResource(R.drawable.button_profile_std);
        B25.setBackgroundResource(R.drawable.button_profile_std);




    }

    /***********************************************************
     * This method handles the values on the different buttons *
     ***********************************************************/

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button14:
                resetButtonColors();
                B10.setBackgroundResource(R.drawable.button_primary_solid);
                B25.setBackgroundResource(R.drawable.button_primary_solid);
                q1 = 0;
                q2 = 5;
                break;
            case R.id.button13:
                resetButtonColors();
                B11.setBackgroundResource(R.drawable.button_primary_solid);
                B24.setBackgroundResource(R.drawable.button_primary_solid);
                q1 = 1;
                q2 = 4;
                break;
            case R.id.button12:
                resetButtonColors();
                B12.setBackgroundResource(R.drawable.button_primary_solid);
                B23.setBackgroundResource(R.drawable.button_primary_solid);
                q1 = 2;
                q2 = 3;
                break;
            case R.id.button11:
                resetButtonColors();
                B13.setBackgroundResource(R.drawable.button_primary_solid);
                B22.setBackgroundResource(R.drawable.button_primary_solid);
                q1 = 3;
                q2 = 2;
                break;
            case R.id.button8:
                resetButtonColors();
                B14.setBackgroundResource(R.drawable.button_primary_solid);
                B21.setBackgroundResource(R.drawable.button_primary_solid);
                q1 = 4;
                q2 = 1;
                break;
            case R.id.button5:
                resetButtonColors();
                B15.setBackgroundResource(R.drawable.button_primary_solid);
                B20.setBackgroundResource(R.drawable.button_primary_solid);
                q1 = 5;
                q2 = 0;
                break;
            case R.id.button20:
                resetButtonColors();
                B15.setBackgroundResource(R.drawable.button_primary_solid);
                B20.setBackgroundResource(R.drawable.button_primary_solid);
                q2 = 0;
                q1 = 5;
                break;
            case R.id.button19:
                resetButtonColors();
                B14.setBackgroundResource(R.drawable.button_primary_solid);
                B21.setBackgroundResource(R.drawable.button_primary_solid);
                q2 = 1;
                q1 = 4;
                break;
            case R.id.button18:
                resetButtonColors();
                B13.setBackgroundResource(R.drawable.button_primary_solid);
                B22.setBackgroundResource(R.drawable.button_primary_solid);
                q2 = 2;
                q1 = 3;
                break;
            case R.id.button17:
                resetButtonColors();
                B12.setBackgroundResource(R.drawable.button_primary_solid);
                B23.setBackgroundResource(R.drawable.button_primary_solid);
                q2 = 3;
                q1 = 2;
                break;
            case R.id.button16:
                resetButtonColors();
                B11.setBackgroundResource(R.drawable.button_primary_solid);
                B24.setBackgroundResource(R.drawable.button_primary_solid);
                q2 = 4;
                q1 = 1;
                break;
            case R.id.button15:
                resetButtonColors();
                B10.setBackgroundResource(R.drawable.button_primary_solid);
                B25.setBackgroundResource(R.drawable.button_primary_solid);
                q2 = 5;
                q1 = 0;
                break;

            case R.id.button4:

                if (!finished) {

                    System.out.println(currentQuestion1.toString());
                    System.out.println(currentQuestion2.toString());
                    test.resolveFinishedDate();
                    next();

                }

                else {
                    test.resolveFinishedDate();
                    MainMenu.getInstance().getUser().addToResults(test);
                    ResultListFragment nextFrag= new ResultListFragment();
                    this.getFragmentManager().beginTransaction()
                            .replace(R.id.article_fragment, nextFrag,null)
                            .addToBackStack(null)
                            .commit();
                }

                break;
        }
    }
}
