package com.grp12.softskilltools.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.galgespil.stvhendeop.menuapp.R;
import com.grp12.softskilltools.Activities.MainMenu;
import com.grp12.softskilltools.Entities.DISC;
import com.grp12.softskilltools.Entities.Question;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.frag_disc_test, container, false);

        holder.question1 = (TextView) myView.findViewById(R.id.textView6);
        holder.question2 = (TextView) myView.findViewById(R.id.textView7);
        holder.alert = (TextView) myView.findViewById(R.id.Alert);
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
        this.currentQuestion1 = loadQuestion(this.currentQuestion1,holder.question1);
        this.currentQuestion2 = loadQuestion(this.currentQuestion2,holder.question2);







        return myView;
    }

    public void next(){
        if (q1 + q2 == 5){
            test.setQuestionAnswered(currentQuestion1);
            test.setQuestionAnswered(currentQuestion2);
            test.setScore(currentQuestion1,q1);
            test.setScore(currentQuestion2,q2);
            loadQuestion(currentQuestion1,holder.question1);
            loadQuestion(currentQuestion2,holder.question2);
            holder.alert.setVisibility(View.GONE);
        }
        else{
            holder.alert.setVisibility(View.VISIBLE);
        }
    }

    public Question loadQuestion(Question current, TextView placeHolder){
        this.current = current;
        current = test.QUEUELOGIC();
        if (current.getAnswered() == true){
            Next.setText("Se resultat");
            finished = true;
            MainMenu.getInstance().getUser().addToResults(test);
        }
        else {
            placeHolder.setText(current.getQuestion());

        }
        return current;
    }
    static class viewHolder{
        TextView question1,question2, alert;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button14:
                q1 = 0;
                q2 = 5;
                break;
            case R.id.button13:
                q1 = 1;
                q2 = 4;
                break;
            case R.id.button12:
                q1 = 2;
                q2 = 3;
                break;
            case R.id.button11:
                q1 = 3;
                q2 = 2;
                break;
            case R.id.button8:
                q1 = 4;
                q2 = 1;
                break;
            case R.id.button5:
                q1 = 5;
                q2 = 0;
                break;
            case R.id.button20:
                q2 = 0;
                q1 = 5;
                break;
            case R.id.button19:
                q2 = 1;
                q1 = 4;
                break;
            case R.id.button18:
                q2 = 2;
                q1 = 3;
                break;
            case R.id.button17:
                q2 = 3;
                q1 = 2;
                break;
            case R.id.button16:
                q2 = 4;
                q1 = 1;
                break;
            case R.id.button15:
                q2 = 5;
                q1 = 0;
                break;
            case R.id.button4:
                if (finished==false){
                    next();
                }
                else{

                }

                //Gå til resultat
                break;
        }
    }
}
