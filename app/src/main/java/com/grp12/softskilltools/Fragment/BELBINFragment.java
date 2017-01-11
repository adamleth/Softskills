package com.grp12.softskilltools.Fragment;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.galgespil.stvhendeop.menuapp.R;
import com.grp12.softskilltools.Activities.MainMenu;
import com.grp12.softskilltools.Entities.BELBIN;
import com.grp12.softskilltools.Entities.Question;

/**
 * Created by Mathias R. Larsen on 03-01-2017.
 */

public class BELBINFragment extends Fragment implements View.OnClickListener {



        BELBIN test;
        ScrollView exView;
        boolean finished = false;
        Question currentQuestion1,currentQuestion2,currentQuestion3,
                currentQuestion4,currentQuestion5,currentQuestion6,
                currentQuestion7,currentQuestion8,currentQuestion9,currentQuestion10;
        Button B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11,B12,B13,B14,B15,B16,B17,B18,B19,B20,
                B21,B22,B23,B24,B25,B26,B27,B28,B29,B30,B31,B32,B33,B34,B35,B36,B37,B38,
                B39,B40,B41,B42,B43,B44,B45,B46,B47,B48,B49,B50,B51,B52,B53,B54,B55,B56,
                B57,B58,B59,B60,B61,B62,B63,B64,B65,B66,B67,B68,B69,B70,B71,B72,B73,B74,
                B75,B76,B77,B78,B79,B80,B81,B82,B83,B84,B85,B86,B87,B88,B89,B90,B91,B92,
                B93,B94,B95,B96,B97,B98,B99,B100,B101,B102,B103,B104,B105,B106,B107,B108,B109,B110, ACTION;
        private Question current;
        int q1,q2,q3,q4,q5,q6,q7,q8,q9,q10;
        viewHolder holder;
        View myView;

    public BELBINFragment(){
        q1 = q2 = q3 = q4 = q5 = q6 = q7 = q8 = q9 = q10 = 0;
        test = (BELBIN)SafeFragment.getInstance().getTempItem();
        holder = new viewHolder();

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.frag_belbin_test, container, false);

        holder.question1 = (TextView) myView.findViewById(R.id.textView24);
        holder.question2 = (TextView) myView.findViewById(R.id.textView25);
        holder.question3 = (TextView) myView.findViewById(R.id.textView27);
        holder.question4 = (TextView) myView.findViewById(R.id.textView29);
        holder.question5 = (TextView) myView.findViewById(R.id.textView31);
        holder.question6 = (TextView) myView.findViewById(R.id.textView);
        holder.question7 = (TextView) myView.findViewById(R.id.textView5);
        holder.question8 = (TextView) myView.findViewById(R.id.textView13);
        holder.question9 = (TextView) myView.findViewById(R.id.textView22);
        holder.question10 = (TextView) myView.findViewById(R.id.textView23);


        B1 = (Button) myView.findViewById(R.id.button150);B2 = (Button) myView.findViewById(R.id.button48);
        B3 = (Button) myView.findViewById(R.id.button47);B4 = (Button) myView.findViewById(R.id.button30);
        B5 = (Button) myView.findViewById(R.id.button31);B6 = (Button) myView.findViewById(R.id.button41);
        B7 = (Button) myView.findViewById(R.id.button42);B8 = (Button) myView.findViewById(R.id.button43);
        B9 = (Button) myView.findViewById(R.id.button44);B10 = (Button) myView.findViewById(R.id.button45);
        B11 = (Button) myView.findViewById(R.id.button46);B12 = (Button) myView.findViewById(R.id.button149);
        B13 = (Button) myView.findViewById(R.id.button59);B14 = (Button) myView.findViewById(R.id.button58);
        B15 = (Button) myView.findViewById(R.id.button57);B16 = (Button) myView.findViewById(R.id.button56);
        B17 = (Button) myView.findViewById(R.id.button55);B18 = (Button) myView.findViewById(R.id.button54);
        B19 = (Button) myView.findViewById(R.id.button52);B20 = (Button) myView.findViewById(R.id.button51);
        B21 = (Button) myView.findViewById(R.id.button50);B22 = (Button) myView.findViewById(R.id.button49);
        B23 = (Button) myView.findViewById(R.id.button148);B24 = (Button) myView.findViewById(R.id.button70);
        B25 = (Button) myView.findViewById(R.id.button69);B26 = (Button) myView.findViewById(R.id.button68);
        B27 = (Button) myView.findViewById(R.id.button67);B28 = (Button) myView.findViewById(R.id.button66);
        B29 = (Button) myView.findViewById(R.id.button65);B30 = (Button) myView.findViewById(R.id.button64);
        B31 = (Button) myView.findViewById(R.id.button63);B32 = (Button) myView.findViewById(R.id.button62);
        B33 = (Button) myView.findViewById(R.id.button61);B34 = (Button) myView.findViewById(R.id.button80);
        B35 = (Button) myView.findViewById(R.id.button79);B36 = (Button) myView.findViewById(R.id.button78);
        B37 = (Button) myView.findViewById(R.id.button77);B38 = (Button) myView.findViewById(R.id.button76);
        B39 = (Button) myView.findViewById(R.id.button75);B40 = (Button) myView.findViewById(R.id.button74);
        B41 = (Button) myView.findViewById(R.id.button73);B42 = (Button) myView.findViewById(R.id.button72);
        B43 = (Button) myView.findViewById(R.id.button71);B44 = (Button) myView.findViewById(R.id.button147);
        B45 = (Button) myView.findViewById(R.id.button91);B46 = (Button) myView.findViewById(R.id.button90);
        B47 = (Button) myView.findViewById(R.id.button89);B48 = (Button) myView.findViewById(R.id.button88);
        B49 = (Button) myView.findViewById(R.id.button87);B50 = (Button) myView.findViewById(R.id.button86);
        B51 = (Button) myView.findViewById(R.id.button85);B52 = (Button) myView.findViewById(R.id.button84);
        B53 = (Button) myView.findViewById(R.id.button83);B54 = (Button) myView.findViewById(R.id.button81);
        B55 = (Button) myView.findViewById(R.id.button146);B56 = (Button) myView.findViewById(R.id.button100);
        B57 = (Button) myView.findViewById(R.id.button99);B58 = (Button) myView.findViewById(R.id.button98);
        B59 = (Button) myView.findViewById(R.id.button97);B60 = (Button) myView.findViewById(R.id.button96);
        B61 = (Button) myView.findViewById(R.id.button95);B62 = (Button) myView.findViewById(R.id.button94);
        B63 = (Button) myView.findViewById(R.id.button93);B64 = (Button) myView.findViewById(R.id.button92);
        B65 = (Button) myView.findViewById(R.id.button82);B66 = (Button) myView.findViewById(R.id.button145);
        B67 = (Button) myView.findViewById(R.id.button110);B68 = (Button) myView.findViewById(R.id.button109);
        B69 = (Button) myView.findViewById(R.id.button108);B70 = (Button) myView.findViewById(R.id.button107);
        B71 = (Button) myView.findViewById(R.id.button106);B72 = (Button) myView.findViewById(R.id.button105);
        B73 = (Button) myView.findViewById(R.id.button104);B74 = (Button) myView.findViewById(R.id.button103);
        B75 = (Button) myView.findViewById(R.id.button102);B76 = (Button) myView.findViewById(R.id.button101);
        B77 = (Button) myView.findViewById(R.id.button144);B78 = (Button) myView.findViewById(R.id.button120);
        B79 = (Button) myView.findViewById(R.id.button119);B80 = (Button) myView.findViewById(R.id.button118);
        B81 = (Button) myView.findViewById(R.id.button117);B82 = (Button) myView.findViewById(R.id.button116);
        B83 = (Button) myView.findViewById(R.id.button115);B84 = (Button) myView.findViewById(R.id.button114);
        B85 = (Button) myView.findViewById(R.id.button113);B86 = (Button) myView.findViewById(R.id.button112);
        B87 = (Button) myView.findViewById(R.id.button111);B88 = (Button) myView.findViewById(R.id.button143);
        B89 = (Button) myView.findViewById(R.id.button142);B90 = (Button) myView.findViewById(R.id.button130);
        B91 = (Button) myView.findViewById(R.id.button129);B92 = (Button) myView.findViewById(R.id.button128);
        B93 = (Button) myView.findViewById(R.id.button127);B94 = (Button) myView.findViewById(R.id.button126);
        B95 = (Button) myView.findViewById(R.id.button125);B96 = (Button) myView.findViewById(R.id.button124);
        B97 = (Button) myView.findViewById(R.id.button123);B98 = (Button) myView.findViewById(R.id.button122);
        B99 = (Button) myView.findViewById(R.id.button121);B100 = (Button) myView.findViewById(R.id.button140);
        B101 = (Button) myView.findViewById(R.id.button139);B102 = (Button) myView.findViewById(R.id.button138);
        B103 = (Button) myView.findViewById(R.id.button137);B104 = (Button) myView.findViewById(R.id.button136);
        B105 = (Button) myView.findViewById(R.id.button135);B106 = (Button) myView.findViewById(R.id.button134);
        B107 = (Button) myView.findViewById(R.id.button133);B108 = (Button) myView.findViewById(R.id.button132);
        B109 = (Button) myView.findViewById(R.id.button131);B110 = (Button) myView.findViewById(R.id.button141);

        B1.setOnClickListener(this);B2.setOnClickListener(this);B3.setOnClickListener(this);B4.setOnClickListener(this);
        B5.setOnClickListener(this);B6.setOnClickListener(this);B7.setOnClickListener(this);B8.setOnClickListener(this);
        B9.setOnClickListener(this);B10.setOnClickListener(this);B11.setOnClickListener(this);
        B12.setOnClickListener(this);B13.setOnClickListener(this);B14.setOnClickListener(this);
        B15.setOnClickListener(this);B16.setOnClickListener(this);B17.setOnClickListener(this);
        B18.setOnClickListener(this);B19.setOnClickListener(this);B20.setOnClickListener(this);
        B21.setOnClickListener(this);B22.setOnClickListener(this);B23.setOnClickListener(this);
        B24.setOnClickListener(this);B25.setOnClickListener(this);B26.setOnClickListener(this);
        B27.setOnClickListener(this);B28.setOnClickListener(this);B29.setOnClickListener(this);
        B30.setOnClickListener(this);B31.setOnClickListener(this);B32.setOnClickListener(this);
        B33.setOnClickListener(this);B34.setOnClickListener(this);B35.setOnClickListener(this);
        B36.setOnClickListener(this);B37.setOnClickListener(this);B38.setOnClickListener(this);
        B39.setOnClickListener(this);B40.setOnClickListener(this);B41.setOnClickListener(this);
        B42.setOnClickListener(this);B43.setOnClickListener(this);B44.setOnClickListener(this);
        B45.setOnClickListener(this);B46.setOnClickListener(this);B47.setOnClickListener(this);
        B48.setOnClickListener(this);B49.setOnClickListener(this);B50.setOnClickListener(this);
        B51.setOnClickListener(this);B52.setOnClickListener(this);B53.setOnClickListener(this);
        B54.setOnClickListener(this);B55.setOnClickListener(this);B56.setOnClickListener(this);
        B57.setOnClickListener(this);B58.setOnClickListener(this);B59.setOnClickListener(this);
        B60.setOnClickListener(this);B61.setOnClickListener(this);B62.setOnClickListener(this);
        B63.setOnClickListener(this);B64.setOnClickListener(this);B65.setOnClickListener(this);
        B66.setOnClickListener(this);B67.setOnClickListener(this);B68.setOnClickListener(this);
        B69.setOnClickListener(this);B70.setOnClickListener(this);B71.setOnClickListener(this);
        B72.setOnClickListener(this);B73.setOnClickListener(this);B74.setOnClickListener(this);
        B75.setOnClickListener(this);B76.setOnClickListener(this);B77.setOnClickListener(this);
        B78.setOnClickListener(this);B79.setOnClickListener(this);B80.setOnClickListener(this);
        B81.setOnClickListener(this);B82.setOnClickListener(this);B83.setOnClickListener(this);
        B84.setOnClickListener(this);B85.setOnClickListener(this);B86.setOnClickListener(this);
        B87.setOnClickListener(this);B88.setOnClickListener(this);B89.setOnClickListener(this);
        B90.setOnClickListener(this);B91.setOnClickListener(this);B92.setOnClickListener(this);
        B93.setOnClickListener(this);B94.setOnClickListener(this);B95.setOnClickListener(this);
        B96.setOnClickListener(this);B97.setOnClickListener(this);B98.setOnClickListener(this);
        B99.setOnClickListener(this);B100.setOnClickListener(this);B101.setOnClickListener(this);
        B102.setOnClickListener(this);B103.setOnClickListener(this);B104.setOnClickListener(this);
        B105.setOnClickListener(this);B106.setOnClickListener(this);B107.setOnClickListener(this);
        B108.setOnClickListener(this);B109.setOnClickListener(this);B110.setOnClickListener(this);

        ACTION = (Button) myView.findViewById(R.id.button27);ACTION.setOnClickListener(this);

        this.currentQuestion1 = loadQuestion(holder.question1);this.currentQuestion2 = loadQuestion(holder.question2);
        this.currentQuestion3 = loadQuestion(holder.question3);this.currentQuestion4 = loadQuestion(holder.question4);
        this.currentQuestion5 = loadQuestion(holder.question5);this.currentQuestion6 = loadQuestion(holder.question6);
        this.currentQuestion7 = loadQuestion(holder.question7);this.currentQuestion8 = loadQuestion(holder.question8);
        this.currentQuestion9 = loadQuestion(holder.question9);this.currentQuestion10 = loadQuestion(holder.question10);

        resetButtonColors();

        return myView;
    }

    /******************************************************
     * This method changes the view and updates the score *
     ******************************************************/

    public void next(){
        if (q1 + q2 + q3 + q4 + q5 + q6 + q7 + q8 + q9 + q10 == 10){
            update(currentQuestion1,q1);
            update(currentQuestion2,q2);
            update(currentQuestion3,q3);
            update(currentQuestion4,q4);
            update(currentQuestion5,q5);
            update(currentQuestion6,q6);
            update(currentQuestion7,q7);
            update(currentQuestion8,q8);
            update(currentQuestion9,q9);
            update(currentQuestion10,q10);
            currentQuestion1 = loadQuestion(holder.question1);
            currentQuestion2 = loadQuestion(holder.question2);
            currentQuestion3 = loadQuestion(holder.question3);
            currentQuestion4 = loadQuestion(holder.question4);
            currentQuestion5 = loadQuestion(holder.question5);
            currentQuestion6 = loadQuestion(holder.question6);
            currentQuestion7 = loadQuestion(holder.question7);
            currentQuestion8 = loadQuestion(holder.question8);
            currentQuestion9 = loadQuestion(holder.question9);
            currentQuestion10 = loadQuestion(holder.question10);
            resetScores();
            resetButtonColors();
            

        }
    }

    public void resetButtonColors(){
        B1.setBackgroundResource(R.drawable.button_profile_std);B2.setBackgroundResource(R.drawable.button_profile_std);
        B3.setBackgroundResource(R.drawable.button_profile_std);B4.setBackgroundResource(R.drawable.button_profile_std);
        B5.setBackgroundResource(R.drawable.button_profile_std);B6.setBackgroundResource(R.drawable.button_profile_std);
        B7.setBackgroundResource(R.drawable.button_profile_std);B8.setBackgroundResource(R.drawable.button_profile_std);
        B9.setBackgroundResource(R.drawable.button_profile_std);B10.setBackgroundResource(R.drawable.button_profile_std);
        B11.setBackgroundResource(R.drawable.button_profile_std);B12.setBackgroundResource(R.drawable.button_profile_std);
        B13.setBackgroundResource(R.drawable.button_profile_std);B14.setBackgroundResource(R.drawable.button_profile_std);
        B15.setBackgroundResource(R.drawable.button_profile_std);B16.setBackgroundResource(R.drawable.button_profile_std);
        B17.setBackgroundResource(R.drawable.button_profile_std);B18.setBackgroundResource(R.drawable.button_profile_std);
        B19.setBackgroundResource(R.drawable.button_profile_std);B20.setBackgroundResource(R.drawable.button_profile_std);
        B21.setBackgroundResource(R.drawable.button_profile_std);B22.setBackgroundResource(R.drawable.button_profile_std);
        B23.setBackgroundResource(R.drawable.button_profile_std);B24.setBackgroundResource(R.drawable.button_profile_std);
        B25.setBackgroundResource(R.drawable.button_profile_std);B26.setBackgroundResource(R.drawable.button_profile_std);
        B27.setBackgroundResource(R.drawable.button_profile_std);B28.setBackgroundResource(R.drawable.button_profile_std);
        B29.setBackgroundResource(R.drawable.button_profile_std);B30.setBackgroundResource(R.drawable.button_profile_std);
        B31.setBackgroundResource(R.drawable.button_profile_std);B32.setBackgroundResource(R.drawable.button_profile_std);
        B33.setBackgroundResource(R.drawable.button_profile_std);B34.setBackgroundResource(R.drawable.button_profile_std);
        B35.setBackgroundResource(R.drawable.button_profile_std);B36.setBackgroundResource(R.drawable.button_profile_std);
        B37.setBackgroundResource(R.drawable.button_profile_std);B38.setBackgroundResource(R.drawable.button_profile_std);
        B39.setBackgroundResource(R.drawable.button_profile_std);B40.setBackgroundResource(R.drawable.button_profile_std);
        B41.setBackgroundResource(R.drawable.button_profile_std);B42.setBackgroundResource(R.drawable.button_profile_std);
        B43.setBackgroundResource(R.drawable.button_profile_std);B44.setBackgroundResource(R.drawable.button_profile_std);
        B45.setBackgroundResource(R.drawable.button_profile_std);B46.setBackgroundResource(R.drawable.button_profile_std);
        B47.setBackgroundResource(R.drawable.button_profile_std);B48.setBackgroundResource(R.drawable.button_profile_std);
        B49.setBackgroundResource(R.drawable.button_profile_std);B50.setBackgroundResource(R.drawable.button_profile_std);
        B51.setBackgroundResource(R.drawable.button_profile_std);B52.setBackgroundResource(R.drawable.button_profile_std);
        B53.setBackgroundResource(R.drawable.button_profile_std);B54.setBackgroundResource(R.drawable.button_profile_std);
        B55.setBackgroundResource(R.drawable.button_profile_std);B56.setBackgroundResource(R.drawable.button_profile_std);
        B57.setBackgroundResource(R.drawable.button_profile_std);B58.setBackgroundResource(R.drawable.button_profile_std);
        B59.setBackgroundResource(R.drawable.button_profile_std);B60.setBackgroundResource(R.drawable.button_profile_std);
        B61.setBackgroundResource(R.drawable.button_profile_std);B62.setBackgroundResource(R.drawable.button_profile_std);
        B63.setBackgroundResource(R.drawable.button_profile_std);B64.setBackgroundResource(R.drawable.button_profile_std);
        B65.setBackgroundResource(R.drawable.button_profile_std);B66.setBackgroundResource(R.drawable.button_profile_std);
        B67.setBackgroundResource(R.drawable.button_profile_std);B68.setBackgroundResource(R.drawable.button_profile_std);
        B69.setBackgroundResource(R.drawable.button_profile_std);B70.setBackgroundResource(R.drawable.button_profile_std);
        B71.setBackgroundResource(R.drawable.button_profile_std);B72.setBackgroundResource(R.drawable.button_profile_std);
        B73.setBackgroundResource(R.drawable.button_profile_std);B74.setBackgroundResource(R.drawable.button_profile_std);
        B75.setBackgroundResource(R.drawable.button_profile_std);B76.setBackgroundResource(R.drawable.button_profile_std);
        B77.setBackgroundResource(R.drawable.button_profile_std);B78.setBackgroundResource(R.drawable.button_profile_std);
        B79.setBackgroundResource(R.drawable.button_profile_std);B80.setBackgroundResource(R.drawable.button_profile_std);
        B81.setBackgroundResource(R.drawable.button_profile_std);B82.setBackgroundResource(R.drawable.button_profile_std);
        B83.setBackgroundResource(R.drawable.button_profile_std);B84.setBackgroundResource(R.drawable.button_profile_std);
        B85.setBackgroundResource(R.drawable.button_profile_std);B86.setBackgroundResource(R.drawable.button_profile_std);
        B87.setBackgroundResource(R.drawable.button_profile_std);B88.setBackgroundResource(R.drawable.button_profile_std);
        B89.setBackgroundResource(R.drawable.button_profile_std);B90.setBackgroundResource(R.drawable.button_profile_std);
        B91.setBackgroundResource(R.drawable.button_profile_std);B92.setBackgroundResource(R.drawable.button_profile_std);
        B93.setBackgroundResource(R.drawable.button_profile_std);B94.setBackgroundResource(R.drawable.button_profile_std);
        B95.setBackgroundResource(R.drawable.button_profile_std);B96.setBackgroundResource(R.drawable.button_profile_std);
        B97.setBackgroundResource(R.drawable.button_profile_std);B98.setBackgroundResource(R.drawable.button_profile_std);
        B99.setBackgroundResource(R.drawable.button_profile_std);B100.setBackgroundResource(R.drawable.button_profile_std);
        B101.setBackgroundResource(R.drawable.button_profile_std);B102.setBackgroundResource(R.drawable.button_profile_std);
        B103.setBackgroundResource(R.drawable.button_profile_std);B104.setBackgroundResource(R.drawable.button_profile_std);
        B105.setBackgroundResource(R.drawable.button_profile_std);B106.setBackgroundResource(R.drawable.button_profile_std);
        B107.setBackgroundResource(R.drawable.button_profile_std);B108.setBackgroundResource(R.drawable.button_profile_std);
        B109.setBackgroundResource(R.drawable.button_profile_std);B110.setBackgroundResource(R.drawable.button_profile_std);




    }

    public void update(Question question, int score){
        test.setQuestionAnswered(question);
        test.setScore(question,score);
    }

    public void resetScores(){
        q1 = q2 = q3= q4 = q5 = q6 = q7 = q8 = q9 = q10 = 0;
    }

    public Question loadQuestion(TextView placeHolder) {
        current = test.QUEUELOGIC();
        if (current == null) {
            ACTION.setText("Se resultat");
            finished = true;


        } else {
            placeHolder.setText(current.getQuestion());

        }

        return current;
    }

    static class viewHolder{
        TextView question1, question2, question3, question4, question5, question6, question7, question8,question9,question10;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button150:
                B1.setBackgroundResource(R.drawable.button_primary_solid);
                B2.setBackgroundResource(R.drawable.button_profile_std);
                B3.setBackgroundResource(R.drawable.button_profile_std);
                B4.setBackgroundResource(R.drawable.button_profile_std);
                B5.setBackgroundResource(R.drawable.button_profile_std);
                B6.setBackgroundResource(R.drawable.button_profile_std);
                B7.setBackgroundResource(R.drawable.button_profile_std);
                B8.setBackgroundResource(R.drawable.button_profile_std);
                B9.setBackgroundResource(R.drawable.button_profile_std);
                B10.setBackgroundResource(R.drawable.button_profile_std);
                B11.setBackgroundResource(R.drawable.button_profile_std);
                q1 = 0;
                System.out.println("Q1= " + q1);
                break;
            case R.id.button48:
                B1.setBackgroundResource(R.drawable.button_profile_std);
                B2.setBackgroundResource(R.drawable.button_primary_solid);
                B3.setBackgroundResource(R.drawable.button_profile_std);
                B4.setBackgroundResource(R.drawable.button_profile_std);
                B5.setBackgroundResource(R.drawable.button_profile_std);
                B6.setBackgroundResource(R.drawable.button_profile_std);
                B7.setBackgroundResource(R.drawable.button_profile_std);
                B8.setBackgroundResource(R.drawable.button_profile_std);
                B9.setBackgroundResource(R.drawable.button_profile_std);
                B10.setBackgroundResource(R.drawable.button_profile_std);
                B11.setBackgroundResource(R.drawable.button_profile_std);
                q1 = 1;
                System.out.println("Q1= " + q1);
                break;
            case R.id.button47:
                B1.setBackgroundResource(R.drawable.button_profile_std);
                B2.setBackgroundResource(R.drawable.button_profile_std);
                B3.setBackgroundResource(R.drawable.button_primary_solid);
                B4.setBackgroundResource(R.drawable.button_profile_std);
                B5.setBackgroundResource(R.drawable.button_profile_std);
                B6.setBackgroundResource(R.drawable.button_profile_std);
                B7.setBackgroundResource(R.drawable.button_profile_std);
                B8.setBackgroundResource(R.drawable.button_profile_std);
                B9.setBackgroundResource(R.drawable.button_profile_std);
                B10.setBackgroundResource(R.drawable.button_profile_std);
                B11.setBackgroundResource(R.drawable.button_profile_std);
                q1 = 2;
                System.out.println("Q1= " + q1);
                break;
            case R.id.button30:
                B1.setBackgroundResource(R.drawable.button_profile_std);
                B2.setBackgroundResource(R.drawable.button_profile_std);
                B3.setBackgroundResource(R.drawable.button_profile_std);
                B4.setBackgroundResource(R.drawable.button_primary_solid);
                B5.setBackgroundResource(R.drawable.button_profile_std);
                B6.setBackgroundResource(R.drawable.button_profile_std);
                B7.setBackgroundResource(R.drawable.button_profile_std);
                B8.setBackgroundResource(R.drawable.button_profile_std);
                B9.setBackgroundResource(R.drawable.button_profile_std);
                B10.setBackgroundResource(R.drawable.button_profile_std);
                B11.setBackgroundResource(R.drawable.button_profile_std);
                q1 = 3;
                System.out.println("Q1= " + q1);
                break;
            case R.id.button31:
                B1.setBackgroundResource(R.drawable.button_profile_std);
                B2.setBackgroundResource(R.drawable.button_profile_std);
                B3.setBackgroundResource(R.drawable.button_profile_std);
                B4.setBackgroundResource(R.drawable.button_profile_std);
                B5.setBackgroundResource(R.drawable.button_primary_solid);
                B6.setBackgroundResource(R.drawable.button_profile_std);
                B7.setBackgroundResource(R.drawable.button_profile_std);
                B8.setBackgroundResource(R.drawable.button_profile_std);
                B9.setBackgroundResource(R.drawable.button_profile_std);
                B10.setBackgroundResource(R.drawable.button_profile_std);
                B11.setBackgroundResource(R.drawable.button_profile_std);
                q1 = 4;
                System.out.println("Q1= " + q1);
                break;
            case R.id.button41:
                B1.setBackgroundResource(R.drawable.button_profile_std);
                B2.setBackgroundResource(R.drawable.button_profile_std);
                B3.setBackgroundResource(R.drawable.button_profile_std);
                B4.setBackgroundResource(R.drawable.button_profile_std);
                B5.setBackgroundResource(R.drawable.button_profile_std);
                B6.setBackgroundResource(R.drawable.button_primary_solid);
                B7.setBackgroundResource(R.drawable.button_profile_std);
                B8.setBackgroundResource(R.drawable.button_profile_std);
                B9.setBackgroundResource(R.drawable.button_profile_std);
                B10.setBackgroundResource(R.drawable.button_profile_std);
                B11.setBackgroundResource(R.drawable.button_profile_std);
                q1 = 5;
                System.out.println("Q1= " + q1);
                break;
            case R.id.button42:
                B1.setBackgroundResource(R.drawable.button_profile_std);
                B2.setBackgroundResource(R.drawable.button_profile_std);
                B3.setBackgroundResource(R.drawable.button_profile_std);
                B4.setBackgroundResource(R.drawable.button_profile_std);
                B5.setBackgroundResource(R.drawable.button_profile_std);
                B6.setBackgroundResource(R.drawable.button_profile_std);
                B7.setBackgroundResource(R.drawable.button_primary_solid);
                B8.setBackgroundResource(R.drawable.button_profile_std);
                B9.setBackgroundResource(R.drawable.button_profile_std);
                B10.setBackgroundResource(R.drawable.button_profile_std);
                B11.setBackgroundResource(R.drawable.button_profile_std);
                q1 = 6;
                System.out.println("Q1= " + q1);
                break;
            case R.id.button43:
                B1.setBackgroundResource(R.drawable.button_profile_std);
                B2.setBackgroundResource(R.drawable.button_profile_std);
                B3.setBackgroundResource(R.drawable.button_profile_std);
                B4.setBackgroundResource(R.drawable.button_profile_std);
                B5.setBackgroundResource(R.drawable.button_profile_std);
                B6.setBackgroundResource(R.drawable.button_profile_std);
                B7.setBackgroundResource(R.drawable.button_profile_std);
                B8.setBackgroundResource(R.drawable.button_primary_solid);
                B9.setBackgroundResource(R.drawable.button_profile_std);
                B10.setBackgroundResource(R.drawable.button_profile_std);
                B11.setBackgroundResource(R.drawable.button_profile_std);
                q1 = 7;
                System.out.println("Q1= " + q1);
                break;
            case R.id.button44:
                B1.setBackgroundResource(R.drawable.button_profile_std);
                B2.setBackgroundResource(R.drawable.button_profile_std);
                B3.setBackgroundResource(R.drawable.button_profile_std);
                B4.setBackgroundResource(R.drawable.button_profile_std);
                B5.setBackgroundResource(R.drawable.button_profile_std);
                B6.setBackgroundResource(R.drawable.button_profile_std);
                B7.setBackgroundResource(R.drawable.button_profile_std);
                B8.setBackgroundResource(R.drawable.button_profile_std);
                B9.setBackgroundResource(R.drawable.button_primary_solid);
                B10.setBackgroundResource(R.drawable.button_profile_std);
                B11.setBackgroundResource(R.drawable.button_profile_std);
                q1 = 8;
                System.out.println("Q1= " + q1);
                break;
            case R.id.button45:
                B1.setBackgroundResource(R.drawable.button_profile_std);
                B2.setBackgroundResource(R.drawable.button_profile_std);
                B3.setBackgroundResource(R.drawable.button_profile_std);
                B4.setBackgroundResource(R.drawable.button_profile_std);
                B5.setBackgroundResource(R.drawable.button_profile_std);
                B6.setBackgroundResource(R.drawable.button_profile_std);
                B7.setBackgroundResource(R.drawable.button_profile_std);
                B8.setBackgroundResource(R.drawable.button_profile_std);
                B9.setBackgroundResource(R.drawable.button_profile_std);
                B10.setBackgroundResource(R.drawable.button_primary_solid);
                B11.setBackgroundResource(R.drawable.button_profile_std);
                q1 = 9;
                System.out.println("Q1= " + q1);
                break;
            case R.id.button46:
                B1.setBackgroundResource(R.drawable.button_profile_std);
                B2.setBackgroundResource(R.drawable.button_profile_std);
                B3.setBackgroundResource(R.drawable.button_profile_std);
                B4.setBackgroundResource(R.drawable.button_profile_std);
                B5.setBackgroundResource(R.drawable.button_profile_std);
                B6.setBackgroundResource(R.drawable.button_profile_std);
                B7.setBackgroundResource(R.drawable.button_profile_std);
                B8.setBackgroundResource(R.drawable.button_profile_std);
                B9.setBackgroundResource(R.drawable.button_profile_std);
                B10.setBackgroundResource(R.drawable.button_profile_std);
                B11.setBackgroundResource(R.drawable.button_primary_solid);
                q1 = 10;
                System.out.println("Q1= " + q1);
                break;
            case R.id.button149:
                B12.setBackgroundResource(R.drawable.button_primary_solid);
                B13.setBackgroundResource(R.drawable.button_profile_std);
                B14.setBackgroundResource(R.drawable.button_profile_std);
                B15.setBackgroundResource(R.drawable.button_profile_std);
                B16.setBackgroundResource(R.drawable.button_profile_std);
                B17.setBackgroundResource(R.drawable.button_profile_std);
                B18.setBackgroundResource(R.drawable.button_profile_std);
                B19.setBackgroundResource(R.drawable.button_profile_std);
                B20.setBackgroundResource(R.drawable.button_profile_std);
                B21.setBackgroundResource(R.drawable.button_profile_std);
                B22.setBackgroundResource(R.drawable.button_profile_std);
                q2 = 0;
                System.out.println("Q2= " + q2);
                break;
            case R.id.button59:
                B12.setBackgroundResource(R.drawable.button_profile_std);
                B13.setBackgroundResource(R.drawable.button_primary_solid);
                B14.setBackgroundResource(R.drawable.button_profile_std);
                B15.setBackgroundResource(R.drawable.button_profile_std);
                B16.setBackgroundResource(R.drawable.button_profile_std);
                B17.setBackgroundResource(R.drawable.button_profile_std);
                B18.setBackgroundResource(R.drawable.button_profile_std);
                B19.setBackgroundResource(R.drawable.button_profile_std);
                B20.setBackgroundResource(R.drawable.button_profile_std);
                B21.setBackgroundResource(R.drawable.button_profile_std);
                B22.setBackgroundResource(R.drawable.button_profile_std);
                q2 = 1;
                System.out.println("Q2= " + q2);
                break;
            case R.id.button58:
                B12.setBackgroundResource(R.drawable.button_profile_std);
                B13.setBackgroundResource(R.drawable.button_profile_std);
                B14.setBackgroundResource(R.drawable.button_primary_solid);
                B15.setBackgroundResource(R.drawable.button_profile_std);
                B16.setBackgroundResource(R.drawable.button_profile_std);
                B17.setBackgroundResource(R.drawable.button_profile_std);
                B18.setBackgroundResource(R.drawable.button_profile_std);
                B19.setBackgroundResource(R.drawable.button_profile_std);
                B20.setBackgroundResource(R.drawable.button_profile_std);
                B21.setBackgroundResource(R.drawable.button_profile_std);
                B22.setBackgroundResource(R.drawable.button_profile_std);
                q2 = 2;
                System.out.println("Q2= " + q2);
                break;
            case R.id.button57:
                B12.setBackgroundResource(R.drawable.button_profile_std);
                B13.setBackgroundResource(R.drawable.button_profile_std);
                B14.setBackgroundResource(R.drawable.button_profile_std);
                B15.setBackgroundResource(R.drawable.button_primary_solid);
                B16.setBackgroundResource(R.drawable.button_profile_std);
                B17.setBackgroundResource(R.drawable.button_profile_std);
                B18.setBackgroundResource(R.drawable.button_profile_std);
                B19.setBackgroundResource(R.drawable.button_profile_std);
                B20.setBackgroundResource(R.drawable.button_profile_std);
                B21.setBackgroundResource(R.drawable.button_profile_std);
                B22.setBackgroundResource(R.drawable.button_profile_std);
                q2 = 3;
                System.out.println("Q2= " + q2);
                break;
            case R.id.button56:
                B12.setBackgroundResource(R.drawable.button_profile_std);
                B13.setBackgroundResource(R.drawable.button_profile_std);
                B14.setBackgroundResource(R.drawable.button_profile_std);
                B15.setBackgroundResource(R.drawable.button_profile_std);
                B16.setBackgroundResource(R.drawable.button_primary_solid);
                B17.setBackgroundResource(R.drawable.button_profile_std);
                B18.setBackgroundResource(R.drawable.button_profile_std);
                B19.setBackgroundResource(R.drawable.button_profile_std);
                B20.setBackgroundResource(R.drawable.button_profile_std);
                B21.setBackgroundResource(R.drawable.button_profile_std);
                B22.setBackgroundResource(R.drawable.button_profile_std);
                q2 = 4;
                System.out.println("Q2= " + q2);
                break;
            case R.id.button55:
                B12.setBackgroundResource(R.drawable.button_profile_std);
                B13.setBackgroundResource(R.drawable.button_profile_std);
                B14.setBackgroundResource(R.drawable.button_profile_std);
                B15.setBackgroundResource(R.drawable.button_profile_std);
                B16.setBackgroundResource(R.drawable.button_profile_std);
                B17.setBackgroundResource(R.drawable.button_primary_solid);
                B18.setBackgroundResource(R.drawable.button_profile_std);
                B19.setBackgroundResource(R.drawable.button_profile_std);
                B20.setBackgroundResource(R.drawable.button_profile_std);
                B21.setBackgroundResource(R.drawable.button_profile_std);
                B22.setBackgroundResource(R.drawable.button_profile_std);
                q2 = 5;
                System.out.println("Q2= " + q2);
                break;
            case R.id.button54:
                B12.setBackgroundResource(R.drawable.button_profile_std);
                B13.setBackgroundResource(R.drawable.button_profile_std);
                B14.setBackgroundResource(R.drawable.button_profile_std);
                B15.setBackgroundResource(R.drawable.button_profile_std);
                B16.setBackgroundResource(R.drawable.button_profile_std);
                B17.setBackgroundResource(R.drawable.button_profile_std);
                B18.setBackgroundResource(R.drawable.button_primary_solid);
                B19.setBackgroundResource(R.drawable.button_profile_std);
                B20.setBackgroundResource(R.drawable.button_profile_std);
                B21.setBackgroundResource(R.drawable.button_profile_std);
                B22.setBackgroundResource(R.drawable.button_profile_std);
                q2 = 6;
                System.out.println("Q2= " + q2);
                break;
            case R.id.button52:
                B12.setBackgroundResource(R.drawable.button_profile_std);
                B13.setBackgroundResource(R.drawable.button_profile_std);
                B14.setBackgroundResource(R.drawable.button_profile_std);
                B15.setBackgroundResource(R.drawable.button_profile_std);
                B16.setBackgroundResource(R.drawable.button_profile_std);
                B17.setBackgroundResource(R.drawable.button_profile_std);
                B18.setBackgroundResource(R.drawable.button_profile_std);
                B19.setBackgroundResource(R.drawable.button_primary_solid);
                B20.setBackgroundResource(R.drawable.button_profile_std);
                B21.setBackgroundResource(R.drawable.button_profile_std);
                B22.setBackgroundResource(R.drawable.button_profile_std);
                q2 = 7;
                System.out.println("Q2= " + q2);
                break;
            case R.id.button51:
                B12.setBackgroundResource(R.drawable.button_profile_std);
                B13.setBackgroundResource(R.drawable.button_profile_std);
                B14.setBackgroundResource(R.drawable.button_profile_std);
                B15.setBackgroundResource(R.drawable.button_profile_std);
                B16.setBackgroundResource(R.drawable.button_profile_std);
                B17.setBackgroundResource(R.drawable.button_profile_std);
                B18.setBackgroundResource(R.drawable.button_profile_std);
                B19.setBackgroundResource(R.drawable.button_profile_std);
                B20.setBackgroundResource(R.drawable.button_primary_solid);
                B21.setBackgroundResource(R.drawable.button_profile_std);
                B22.setBackgroundResource(R.drawable.button_profile_std);
                q2 = 8;
                System.out.println("Q2= " + q2);
                break;
            case R.id.button50:
                B12.setBackgroundResource(R.drawable.button_profile_std);
                B13.setBackgroundResource(R.drawable.button_profile_std);
                B14.setBackgroundResource(R.drawable.button_profile_std);
                B15.setBackgroundResource(R.drawable.button_profile_std);
                B16.setBackgroundResource(R.drawable.button_profile_std);
                B17.setBackgroundResource(R.drawable.button_profile_std);
                B18.setBackgroundResource(R.drawable.button_profile_std);
                B19.setBackgroundResource(R.drawable.button_profile_std);
                B20.setBackgroundResource(R.drawable.button_profile_std);
                B21.setBackgroundResource(R.drawable.button_primary_solid);
                B22.setBackgroundResource(R.drawable.button_profile_std);
                q2 = 9;
                System.out.println("Q2= " + q2);
                break;
            case R.id.button49:
                B12.setBackgroundResource(R.drawable.button_profile_std);
                B13.setBackgroundResource(R.drawable.button_profile_std);
                B14.setBackgroundResource(R.drawable.button_profile_std);
                B15.setBackgroundResource(R.drawable.button_profile_std);
                B16.setBackgroundResource(R.drawable.button_profile_std);
                B17.setBackgroundResource(R.drawable.button_profile_std);
                B18.setBackgroundResource(R.drawable.button_profile_std);
                B19.setBackgroundResource(R.drawable.button_profile_std);
                B20.setBackgroundResource(R.drawable.button_profile_std);
                B21.setBackgroundResource(R.drawable.button_profile_std);
                B22.setBackgroundResource(R.drawable.button_primary_solid);
                q2 = 10;
                System.out.println("Q2= " + q2);
                break;
            case R.id.button148:
                B23.setBackgroundResource(R.drawable.button_primary_solid);
                B24.setBackgroundResource(R.drawable.button_profile_std);
                B25.setBackgroundResource(R.drawable.button_profile_std);
                B26.setBackgroundResource(R.drawable.button_profile_std);
                B27.setBackgroundResource(R.drawable.button_profile_std);
                B28.setBackgroundResource(R.drawable.button_profile_std);
                B29.setBackgroundResource(R.drawable.button_profile_std);
                B30.setBackgroundResource(R.drawable.button_profile_std);
                B31.setBackgroundResource(R.drawable.button_profile_std);
                B32.setBackgroundResource(R.drawable.button_profile_std);
                B33.setBackgroundResource(R.drawable.button_profile_std);
                q3 = 0;
                System.out.println("Q3= " + q3);
                break;
            case R.id.button70:
                B23.setBackgroundResource(R.drawable.button_profile_std);
                B24.setBackgroundResource(R.drawable.button_primary_solid);
                B25.setBackgroundResource(R.drawable.button_profile_std);
                B26.setBackgroundResource(R.drawable.button_profile_std);
                B27.setBackgroundResource(R.drawable.button_profile_std);
                B28.setBackgroundResource(R.drawable.button_profile_std);
                B29.setBackgroundResource(R.drawable.button_profile_std);
                B30.setBackgroundResource(R.drawable.button_profile_std);
                B31.setBackgroundResource(R.drawable.button_profile_std);
                B32.setBackgroundResource(R.drawable.button_profile_std);
                B33.setBackgroundResource(R.drawable.button_profile_std);
                q3 = 1;
                System.out.println("Q3= " + q3);
                break;
            case R.id.button69:
                B23.setBackgroundResource(R.drawable.button_profile_std);
                B24.setBackgroundResource(R.drawable.button_profile_std);
                B25.setBackgroundResource(R.drawable.button_primary_solid);
                B26.setBackgroundResource(R.drawable.button_profile_std);
                B27.setBackgroundResource(R.drawable.button_profile_std);
                B28.setBackgroundResource(R.drawable.button_profile_std);
                B29.setBackgroundResource(R.drawable.button_profile_std);
                B30.setBackgroundResource(R.drawable.button_profile_std);
                B31.setBackgroundResource(R.drawable.button_profile_std);
                B32.setBackgroundResource(R.drawable.button_profile_std);
                B33.setBackgroundResource(R.drawable.button_profile_std);
                q3 = 2;
                System.out.println("Q3= " + q3);
                break;
            case R.id.button68:
                B23.setBackgroundResource(R.drawable.button_profile_std);
                B24.setBackgroundResource(R.drawable.button_profile_std);
                B25.setBackgroundResource(R.drawable.button_profile_std);
                B26.setBackgroundResource(R.drawable.button_primary_solid);
                B27.setBackgroundResource(R.drawable.button_profile_std);
                B28.setBackgroundResource(R.drawable.button_profile_std);
                B29.setBackgroundResource(R.drawable.button_profile_std);
                B30.setBackgroundResource(R.drawable.button_profile_std);
                B31.setBackgroundResource(R.drawable.button_profile_std);
                B32.setBackgroundResource(R.drawable.button_profile_std);
                B33.setBackgroundResource(R.drawable.button_profile_std);
                q3 = 3;
                System.out.println("Q3= " + q3);
                break;
            case R.id.button67:
                B23.setBackgroundResource(R.drawable.button_profile_std);
                B24.setBackgroundResource(R.drawable.button_profile_std);
                B25.setBackgroundResource(R.drawable.button_profile_std);
                B26.setBackgroundResource(R.drawable.button_profile_std);
                B27.setBackgroundResource(R.drawable.button_primary_solid);
                B28.setBackgroundResource(R.drawable.button_profile_std);
                B29.setBackgroundResource(R.drawable.button_profile_std);
                B30.setBackgroundResource(R.drawable.button_profile_std);
                B31.setBackgroundResource(R.drawable.button_profile_std);
                B32.setBackgroundResource(R.drawable.button_profile_std);
                B33.setBackgroundResource(R.drawable.button_profile_std);
                q3 = 4;
                System.out.println("Q3= " + q3);
                break;
            case R.id.button66:
                B23.setBackgroundResource(R.drawable.button_profile_std);
                B24.setBackgroundResource(R.drawable.button_profile_std);
                B25.setBackgroundResource(R.drawable.button_profile_std);
                B26.setBackgroundResource(R.drawable.button_profile_std);
                B27.setBackgroundResource(R.drawable.button_profile_std);
                B28.setBackgroundResource(R.drawable.button_primary_solid);
                B29.setBackgroundResource(R.drawable.button_profile_std);
                B30.setBackgroundResource(R.drawable.button_profile_std);
                B31.setBackgroundResource(R.drawable.button_profile_std);
                B32.setBackgroundResource(R.drawable.button_profile_std);
                B33.setBackgroundResource(R.drawable.button_profile_std);
                q3 = 5;
                System.out.println("Q3= " + q3);
                break;
            case R.id.button65:
                B23.setBackgroundResource(R.drawable.button_profile_std);
                B24.setBackgroundResource(R.drawable.button_profile_std);
                B25.setBackgroundResource(R.drawable.button_profile_std);
                B26.setBackgroundResource(R.drawable.button_profile_std);
                B27.setBackgroundResource(R.drawable.button_profile_std);
                B28.setBackgroundResource(R.drawable.button_profile_std);
                B29.setBackgroundResource(R.drawable.button_primary_solid);
                B30.setBackgroundResource(R.drawable.button_profile_std);
                B31.setBackgroundResource(R.drawable.button_profile_std);
                B32.setBackgroundResource(R.drawable.button_profile_std);
                B33.setBackgroundResource(R.drawable.button_profile_std);
                q3 = 6;
                System.out.println("Q3= " + q3);;
                break;
            case R.id.button64:
                B23.setBackgroundResource(R.drawable.button_profile_std);
                B24.setBackgroundResource(R.drawable.button_profile_std);
                B25.setBackgroundResource(R.drawable.button_profile_std);
                B26.setBackgroundResource(R.drawable.button_profile_std);
                B27.setBackgroundResource(R.drawable.button_profile_std);
                B28.setBackgroundResource(R.drawable.button_profile_std);
                B29.setBackgroundResource(R.drawable.button_profile_std);
                B30.setBackgroundResource(R.drawable.button_primary_solid);
                B31.setBackgroundResource(R.drawable.button_profile_std);
                B32.setBackgroundResource(R.drawable.button_profile_std);
                B33.setBackgroundResource(R.drawable.button_profile_std);
                q3 = 7;
                System.out.println("Q3= " + q3);
                break;
            case R.id.button63:
                B23.setBackgroundResource(R.drawable.button_profile_std);
                B24.setBackgroundResource(R.drawable.button_profile_std);
                B25.setBackgroundResource(R.drawable.button_profile_std);
                B26.setBackgroundResource(R.drawable.button_profile_std);
                B27.setBackgroundResource(R.drawable.button_profile_std);
                B28.setBackgroundResource(R.drawable.button_profile_std);
                B29.setBackgroundResource(R.drawable.button_profile_std);
                B30.setBackgroundResource(R.drawable.button_profile_std);
                B31.setBackgroundResource(R.drawable.button_primary_solid);
                B32.setBackgroundResource(R.drawable.button_profile_std);
                B33.setBackgroundResource(R.drawable.button_profile_std);
                q3 = 8;
                System.out.println("Q3= " + q3);
                break;
            case R.id.button62:
                B23.setBackgroundResource(R.drawable.button_profile_std);
                B24.setBackgroundResource(R.drawable.button_profile_std);
                B25.setBackgroundResource(R.drawable.button_profile_std);
                B26.setBackgroundResource(R.drawable.button_profile_std);
                B27.setBackgroundResource(R.drawable.button_profile_std);
                B28.setBackgroundResource(R.drawable.button_profile_std);
                B29.setBackgroundResource(R.drawable.button_profile_std);
                B30.setBackgroundResource(R.drawable.button_profile_std);
                B31.setBackgroundResource(R.drawable.button_profile_std);
                B32.setBackgroundResource(R.drawable.button_primary_solid);
                B33.setBackgroundResource(R.drawable.button_profile_std);
                q3 = 9;
                System.out.println("Q3= " + q3);
                break;
            case R.id.button61:
                B23.setBackgroundResource(R.drawable.button_profile_std);
                B24.setBackgroundResource(R.drawable.button_profile_std);
                B25.setBackgroundResource(R.drawable.button_profile_std);
                B26.setBackgroundResource(R.drawable.button_profile_std);
                B27.setBackgroundResource(R.drawable.button_profile_std);
                B28.setBackgroundResource(R.drawable.button_profile_std);
                B29.setBackgroundResource(R.drawable.button_profile_std);
                B30.setBackgroundResource(R.drawable.button_profile_std);
                B31.setBackgroundResource(R.drawable.button_profile_std);
                B32.setBackgroundResource(R.drawable.button_profile_std);
                B33.setBackgroundResource(R.drawable.button_primary_solid);
                q3 = 10;
                System.out.println("Q3= " + q3);
                break;
            case R.id.button80:
                B34.setBackgroundResource(R.drawable.button_primary_solid);
                B35.setBackgroundResource(R.drawable.button_profile_std);
                B36.setBackgroundResource(R.drawable.button_profile_std);
                B37.setBackgroundResource(R.drawable.button_profile_std);
                B38.setBackgroundResource(R.drawable.button_profile_std);
                B39.setBackgroundResource(R.drawable.button_profile_std);
                B40.setBackgroundResource(R.drawable.button_profile_std);
                B41.setBackgroundResource(R.drawable.button_profile_std);
                B42.setBackgroundResource(R.drawable.button_profile_std);
                B43.setBackgroundResource(R.drawable.button_profile_std);
                B44.setBackgroundResource(R.drawable.button_profile_std);
                q4 = 0;
                System.out.println("Q4= " + q4);
                break;
            case R.id.button79:
                B34.setBackgroundResource(R.drawable.button_profile_std);
                B35.setBackgroundResource(R.drawable.button_primary_solid);
                B36.setBackgroundResource(R.drawable.button_profile_std);
                B37.setBackgroundResource(R.drawable.button_profile_std);
                B38.setBackgroundResource(R.drawable.button_profile_std);
                B39.setBackgroundResource(R.drawable.button_profile_std);
                B40.setBackgroundResource(R.drawable.button_profile_std);
                B41.setBackgroundResource(R.drawable.button_profile_std);
                B42.setBackgroundResource(R.drawable.button_profile_std);
                B43.setBackgroundResource(R.drawable.button_profile_std);
                B44.setBackgroundResource(R.drawable.button_profile_std);
                q4 = 1;
                System.out.println("Q4= " + q4);
                break;
            case R.id.button78:
                B34.setBackgroundResource(R.drawable.button_profile_std);
                B35.setBackgroundResource(R.drawable.button_profile_std);
                B36.setBackgroundResource(R.drawable.button_primary_solid);
                B37.setBackgroundResource(R.drawable.button_profile_std);
                B38.setBackgroundResource(R.drawable.button_profile_std);
                B39.setBackgroundResource(R.drawable.button_profile_std);
                B40.setBackgroundResource(R.drawable.button_profile_std);
                B41.setBackgroundResource(R.drawable.button_profile_std);
                B42.setBackgroundResource(R.drawable.button_profile_std);
                B43.setBackgroundResource(R.drawable.button_profile_std);
                B44.setBackgroundResource(R.drawable.button_profile_std);
                q4 = 2;
                System.out.println("Q4= " + q4);
                break;
            case R.id.button77:
                B34.setBackgroundResource(R.drawable.button_profile_std);
                B35.setBackgroundResource(R.drawable.button_profile_std);
                B36.setBackgroundResource(R.drawable.button_profile_std);
                B37.setBackgroundResource(R.drawable.button_primary_solid);
                B38.setBackgroundResource(R.drawable.button_profile_std);
                B39.setBackgroundResource(R.drawable.button_profile_std);
                B40.setBackgroundResource(R.drawable.button_profile_std);
                B41.setBackgroundResource(R.drawable.button_profile_std);
                B42.setBackgroundResource(R.drawable.button_profile_std);
                B43.setBackgroundResource(R.drawable.button_profile_std);
                B44.setBackgroundResource(R.drawable.button_profile_std);
                q4 = 3;
                System.out.println("Q4= " + q4);
                break;
            case R.id.button76:
                B34.setBackgroundResource(R.drawable.button_profile_std);
                B35.setBackgroundResource(R.drawable.button_profile_std);
                B36.setBackgroundResource(R.drawable.button_profile_std);
                B37.setBackgroundResource(R.drawable.button_profile_std);
                B38.setBackgroundResource(R.drawable.button_primary_solid);
                B39.setBackgroundResource(R.drawable.button_profile_std);
                B40.setBackgroundResource(R.drawable.button_profile_std);
                B41.setBackgroundResource(R.drawable.button_profile_std);
                B42.setBackgroundResource(R.drawable.button_profile_std);
                B43.setBackgroundResource(R.drawable.button_profile_std);
                B44.setBackgroundResource(R.drawable.button_profile_std);
                q4 = 4;
                System.out.println("Q4= " + q4);
                break;
            case R.id.button75:
                B34.setBackgroundResource(R.drawable.button_profile_std);
                B35.setBackgroundResource(R.drawable.button_profile_std);
                B36.setBackgroundResource(R.drawable.button_profile_std);
                B37.setBackgroundResource(R.drawable.button_profile_std);
                B38.setBackgroundResource(R.drawable.button_profile_std);
                B39.setBackgroundResource(R.drawable.button_primary_solid);
                B40.setBackgroundResource(R.drawable.button_profile_std);
                B41.setBackgroundResource(R.drawable.button_profile_std);
                B42.setBackgroundResource(R.drawable.button_profile_std);
                B43.setBackgroundResource(R.drawable.button_profile_std);
                B44.setBackgroundResource(R.drawable.button_profile_std);
                q4 = 5;
                System.out.println("Q4= " + q4);
                break;
            case R.id.button74:
                B34.setBackgroundResource(R.drawable.button_profile_std);
                B35.setBackgroundResource(R.drawable.button_profile_std);
                B36.setBackgroundResource(R.drawable.button_profile_std);
                B37.setBackgroundResource(R.drawable.button_profile_std);
                B38.setBackgroundResource(R.drawable.button_profile_std);
                B39.setBackgroundResource(R.drawable.button_profile_std);
                B40.setBackgroundResource(R.drawable.button_primary_solid);
                B41.setBackgroundResource(R.drawable.button_profile_std);
                B42.setBackgroundResource(R.drawable.button_profile_std);
                B43.setBackgroundResource(R.drawable.button_profile_std);
                B44.setBackgroundResource(R.drawable.button_profile_std);
                q4 = 6;
                System.out.println("Q4= " + q4);
                break;
            case R.id.button73:
                B34.setBackgroundResource(R.drawable.button_profile_std);
                B35.setBackgroundResource(R.drawable.button_profile_std);
                B36.setBackgroundResource(R.drawable.button_profile_std);
                B37.setBackgroundResource(R.drawable.button_profile_std);
                B38.setBackgroundResource(R.drawable.button_profile_std);
                B39.setBackgroundResource(R.drawable.button_profile_std);
                B40.setBackgroundResource(R.drawable.button_profile_std);
                B41.setBackgroundResource(R.drawable.button_primary_solid);
                B42.setBackgroundResource(R.drawable.button_profile_std);
                B43.setBackgroundResource(R.drawable.button_profile_std);
                B44.setBackgroundResource(R.drawable.button_profile_std);
                q4 = 7;
                System.out.println("Q4= " + q4);
                break;
            case R.id.button72:
                B34.setBackgroundResource(R.drawable.button_profile_std);
                B35.setBackgroundResource(R.drawable.button_profile_std);
                B36.setBackgroundResource(R.drawable.button_profile_std);
                B37.setBackgroundResource(R.drawable.button_profile_std);
                B38.setBackgroundResource(R.drawable.button_profile_std);
                B39.setBackgroundResource(R.drawable.button_profile_std);
                B40.setBackgroundResource(R.drawable.button_profile_std);
                B41.setBackgroundResource(R.drawable.button_profile_std);
                B42.setBackgroundResource(R.drawable.button_primary_solid);
                B43.setBackgroundResource(R.drawable.button_profile_std);
                B44.setBackgroundResource(R.drawable.button_profile_std);
                q4 = 8;
                System.out.println("Q4= " + q4);
                break;
            case R.id.button71:
                B34.setBackgroundResource(R.drawable.button_profile_std);
                B35.setBackgroundResource(R.drawable.button_profile_std);
                B36.setBackgroundResource(R.drawable.button_profile_std);
                B37.setBackgroundResource(R.drawable.button_profile_std);
                B38.setBackgroundResource(R.drawable.button_profile_std);
                B39.setBackgroundResource(R.drawable.button_profile_std);
                B40.setBackgroundResource(R.drawable.button_profile_std);
                B41.setBackgroundResource(R.drawable.button_profile_std);
                B42.setBackgroundResource(R.drawable.button_profile_std);
                B43.setBackgroundResource(R.drawable.button_primary_solid);
                B44.setBackgroundResource(R.drawable.button_profile_std);
                q4 = 9;
                System.out.println("Q4= " + q4);
                break;
            case R.id.button147:
                B34.setBackgroundResource(R.drawable.button_profile_std);
                B35.setBackgroundResource(R.drawable.button_profile_std);
                B36.setBackgroundResource(R.drawable.button_profile_std);
                B37.setBackgroundResource(R.drawable.button_profile_std);
                B38.setBackgroundResource(R.drawable.button_profile_std);
                B39.setBackgroundResource(R.drawable.button_profile_std);
                B40.setBackgroundResource(R.drawable.button_profile_std);
                B41.setBackgroundResource(R.drawable.button_profile_std);
                B42.setBackgroundResource(R.drawable.button_profile_std);
                B43.setBackgroundResource(R.drawable.button_profile_std);
                B44.setBackgroundResource(R.drawable.button_primary_solid);
                q4 = 10;
                System.out.println("Q4= " + q4);
                break;
            case R.id.button91:
                B45.setBackgroundResource(R.drawable.button_primary_solid);
                B46.setBackgroundResource(R.drawable.button_profile_std);
                B47.setBackgroundResource(R.drawable.button_profile_std);
                B48.setBackgroundResource(R.drawable.button_profile_std);
                B49.setBackgroundResource(R.drawable.button_profile_std);
                B50.setBackgroundResource(R.drawable.button_profile_std);
                B51.setBackgroundResource(R.drawable.button_profile_std);
                B52.setBackgroundResource(R.drawable.button_profile_std);
                B53.setBackgroundResource(R.drawable.button_profile_std);
                B54.setBackgroundResource(R.drawable.button_profile_std);
                B55.setBackgroundResource(R.drawable.button_profile_std);
                q5 = 0;
                System.out.println("Q5= " + q5);
                break;
            case R.id.button90:
                B45.setBackgroundResource(R.drawable.button_profile_std);
                B46.setBackgroundResource(R.drawable.button_primary_solid);
                B47.setBackgroundResource(R.drawable.button_profile_std);
                B48.setBackgroundResource(R.drawable.button_profile_std);
                B49.setBackgroundResource(R.drawable.button_profile_std);
                B50.setBackgroundResource(R.drawable.button_profile_std);
                B51.setBackgroundResource(R.drawable.button_profile_std);
                B52.setBackgroundResource(R.drawable.button_profile_std);
                B53.setBackgroundResource(R.drawable.button_profile_std);
                B54.setBackgroundResource(R.drawable.button_profile_std);
                B55.setBackgroundResource(R.drawable.button_profile_std);
                q5 = 1;
                System.out.println("Q5= " + q5);
                break;
            case R.id.button89:
                B45.setBackgroundResource(R.drawable.button_profile_std);
                B46.setBackgroundResource(R.drawable.button_profile_std);
                B47.setBackgroundResource(R.drawable.button_primary_solid);
                B48.setBackgroundResource(R.drawable.button_profile_std);
                B49.setBackgroundResource(R.drawable.button_profile_std);
                B50.setBackgroundResource(R.drawable.button_profile_std);
                B51.setBackgroundResource(R.drawable.button_profile_std);
                B52.setBackgroundResource(R.drawable.button_profile_std);
                B53.setBackgroundResource(R.drawable.button_profile_std);
                B54.setBackgroundResource(R.drawable.button_profile_std);
                B55.setBackgroundResource(R.drawable.button_profile_std);
                q5 = 2;
                System.out.println("Q5= " + q5);
                break;
            case R.id.button88:
                B45.setBackgroundResource(R.drawable.button_profile_std);
                B46.setBackgroundResource(R.drawable.button_profile_std);
                B47.setBackgroundResource(R.drawable.button_profile_std);
                B48.setBackgroundResource(R.drawable.button_primary_solid);
                B49.setBackgroundResource(R.drawable.button_profile_std);
                B50.setBackgroundResource(R.drawable.button_profile_std);
                B51.setBackgroundResource(R.drawable.button_profile_std);
                B52.setBackgroundResource(R.drawable.button_profile_std);
                B53.setBackgroundResource(R.drawable.button_profile_std);
                B54.setBackgroundResource(R.drawable.button_profile_std);
                B55.setBackgroundResource(R.drawable.button_profile_std);
                q5 = 3;
                System.out.println("Q5= " + q5);
                break;
            case R.id.button87:
                B45.setBackgroundResource(R.drawable.button_profile_std);
                B46.setBackgroundResource(R.drawable.button_profile_std);
                B47.setBackgroundResource(R.drawable.button_profile_std);
                B48.setBackgroundResource(R.drawable.button_profile_std);
                B49.setBackgroundResource(R.drawable.button_primary_solid);
                B50.setBackgroundResource(R.drawable.button_profile_std);
                B51.setBackgroundResource(R.drawable.button_profile_std);
                B52.setBackgroundResource(R.drawable.button_profile_std);
                B53.setBackgroundResource(R.drawable.button_profile_std);
                B54.setBackgroundResource(R.drawable.button_profile_std);
                B55.setBackgroundResource(R.drawable.button_profile_std);
                q5 = 4;
                System.out.println("Q5= " + q5);
                break;
            case R.id.button86:
                B45.setBackgroundResource(R.drawable.button_profile_std);
                B46.setBackgroundResource(R.drawable.button_profile_std);
                B47.setBackgroundResource(R.drawable.button_profile_std);
                B48.setBackgroundResource(R.drawable.button_profile_std);
                B49.setBackgroundResource(R.drawable.button_profile_std);
                B50.setBackgroundResource(R.drawable.button_primary_solid);
                B51.setBackgroundResource(R.drawable.button_profile_std);
                B52.setBackgroundResource(R.drawable.button_profile_std);
                B53.setBackgroundResource(R.drawable.button_profile_std);
                B54.setBackgroundResource(R.drawable.button_profile_std);
                B55.setBackgroundResource(R.drawable.button_profile_std);
                q5 = 5;
                System.out.println("Q5= " + q5);
                break;
            case R.id.button85:
                B45.setBackgroundResource(R.drawable.button_profile_std);
                B46.setBackgroundResource(R.drawable.button_profile_std);
                B47.setBackgroundResource(R.drawable.button_profile_std);
                B48.setBackgroundResource(R.drawable.button_profile_std);
                B49.setBackgroundResource(R.drawable.button_profile_std);
                B50.setBackgroundResource(R.drawable.button_profile_std);
                B51.setBackgroundResource(R.drawable.button_primary_solid);
                B52.setBackgroundResource(R.drawable.button_profile_std);
                B53.setBackgroundResource(R.drawable.button_profile_std);
                B54.setBackgroundResource(R.drawable.button_profile_std);
                B55.setBackgroundResource(R.drawable.button_profile_std);
                q5 = 6;
                System.out.println("Q5= " + q5);
                break;
            case R.id.button84:
                B45.setBackgroundResource(R.drawable.button_profile_std);
                B46.setBackgroundResource(R.drawable.button_profile_std);
                B47.setBackgroundResource(R.drawable.button_profile_std);
                B48.setBackgroundResource(R.drawable.button_profile_std);
                B49.setBackgroundResource(R.drawable.button_profile_std);
                B50.setBackgroundResource(R.drawable.button_profile_std);
                B51.setBackgroundResource(R.drawable.button_profile_std);
                B52.setBackgroundResource(R.drawable.button_primary_solid);
                B53.setBackgroundResource(R.drawable.button_profile_std);
                B54.setBackgroundResource(R.drawable.button_profile_std);
                B55.setBackgroundResource(R.drawable.button_profile_std);
                q5 = 7;
                System.out.println("Q5= " + q5);
                break;
            case R.id.button83:
                B45.setBackgroundResource(R.drawable.button_profile_std);
                B46.setBackgroundResource(R.drawable.button_profile_std);
                B47.setBackgroundResource(R.drawable.button_profile_std);
                B48.setBackgroundResource(R.drawable.button_profile_std);
                B49.setBackgroundResource(R.drawable.button_profile_std);
                B50.setBackgroundResource(R.drawable.button_profile_std);
                B51.setBackgroundResource(R.drawable.button_profile_std);
                B52.setBackgroundResource(R.drawable.button_profile_std);
                B53.setBackgroundResource(R.drawable.button_primary_solid);
                B54.setBackgroundResource(R.drawable.button_profile_std);
                B55.setBackgroundResource(R.drawable.button_profile_std);
                q5 = 8;
                System.out.println("Q5= " + q5);
                break;
            case R.id.button81:
                B45.setBackgroundResource(R.drawable.button_profile_std);
                B46.setBackgroundResource(R.drawable.button_profile_std);
                B47.setBackgroundResource(R.drawable.button_profile_std);
                B48.setBackgroundResource(R.drawable.button_profile_std);
                B49.setBackgroundResource(R.drawable.button_profile_std);
                B50.setBackgroundResource(R.drawable.button_profile_std);
                B51.setBackgroundResource(R.drawable.button_profile_std);
                B52.setBackgroundResource(R.drawable.button_profile_std);
                B53.setBackgroundResource(R.drawable.button_profile_std);
                B54.setBackgroundResource(R.drawable.button_primary_solid);
                B55.setBackgroundResource(R.drawable.button_profile_std);
                q5 = 9;
                System.out.println("Q5= " + q5);
                break;
            case R.id.button146:
                B45.setBackgroundResource(R.drawable.button_profile_std);
                B46.setBackgroundResource(R.drawable.button_profile_std);
                B47.setBackgroundResource(R.drawable.button_profile_std);
                B48.setBackgroundResource(R.drawable.button_profile_std);
                B49.setBackgroundResource(R.drawable.button_profile_std);
                B50.setBackgroundResource(R.drawable.button_profile_std);
                B51.setBackgroundResource(R.drawable.button_profile_std);
                B52.setBackgroundResource(R.drawable.button_profile_std);
                B53.setBackgroundResource(R.drawable.button_profile_std);
                B54.setBackgroundResource(R.drawable.button_profile_std);
                B55.setBackgroundResource(R.drawable.button_primary_solid);
                q5 = 10;
                System.out.println("Q5= " + q5);
                break;
            case R.id.button100:
                B56.setBackgroundResource(R.drawable.button_primary_solid);
                B57.setBackgroundResource(R.drawable.button_profile_std);
                B58.setBackgroundResource(R.drawable.button_profile_std);
                B59.setBackgroundResource(R.drawable.button_profile_std);
                B60.setBackgroundResource(R.drawable.button_profile_std);
                B61.setBackgroundResource(R.drawable.button_profile_std);
                B62.setBackgroundResource(R.drawable.button_profile_std);
                B63.setBackgroundResource(R.drawable.button_profile_std);
                B64.setBackgroundResource(R.drawable.button_profile_std);
                B65.setBackgroundResource(R.drawable.button_profile_std);
                B66.setBackgroundResource(R.drawable.button_profile_std);
                q6 = 0;
                System.out.println("Q6= " + q6);
                break;
            case R.id.button99:
                B56.setBackgroundResource(R.drawable.button_profile_std);
                B57.setBackgroundResource(R.drawable.button_primary_solid);
                B58.setBackgroundResource(R.drawable.button_profile_std);
                B59.setBackgroundResource(R.drawable.button_profile_std);
                B60.setBackgroundResource(R.drawable.button_profile_std);
                B61.setBackgroundResource(R.drawable.button_profile_std);
                B62.setBackgroundResource(R.drawable.button_profile_std);
                B63.setBackgroundResource(R.drawable.button_profile_std);
                B64.setBackgroundResource(R.drawable.button_profile_std);
                B65.setBackgroundResource(R.drawable.button_profile_std);
                B66.setBackgroundResource(R.drawable.button_profile_std);
                q6 = 1;
                System.out.println("Q6= " + q6);
                break;
            case R.id.button98:
                B56.setBackgroundResource(R.drawable.button_profile_std);
                B57.setBackgroundResource(R.drawable.button_profile_std);
                B58.setBackgroundResource(R.drawable.button_primary_solid);
                B59.setBackgroundResource(R.drawable.button_profile_std);
                B60.setBackgroundResource(R.drawable.button_profile_std);
                B61.setBackgroundResource(R.drawable.button_profile_std);
                B62.setBackgroundResource(R.drawable.button_profile_std);
                B63.setBackgroundResource(R.drawable.button_profile_std);
                B64.setBackgroundResource(R.drawable.button_profile_std);
                B65.setBackgroundResource(R.drawable.button_profile_std);
                B66.setBackgroundResource(R.drawable.button_profile_std);
                q6 = 2;
                System.out.println("Q6= " + q6);
                break;
            case R.id.button97:
                B56.setBackgroundResource(R.drawable.button_profile_std);
                B57.setBackgroundResource(R.drawable.button_profile_std);
                B58.setBackgroundResource(R.drawable.button_profile_std);
                B59.setBackgroundResource(R.drawable.button_primary_solid);
                B60.setBackgroundResource(R.drawable.button_profile_std);
                B61.setBackgroundResource(R.drawable.button_profile_std);
                B62.setBackgroundResource(R.drawable.button_profile_std);
                B63.setBackgroundResource(R.drawable.button_profile_std);
                B64.setBackgroundResource(R.drawable.button_profile_std);
                B65.setBackgroundResource(R.drawable.button_profile_std);
                B66.setBackgroundResource(R.drawable.button_profile_std);
                q6 = 3;
                System.out.println("Q6= " + q6);
                break;
            case R.id.button96:
                B56.setBackgroundResource(R.drawable.button_profile_std);
                B57.setBackgroundResource(R.drawable.button_profile_std);
                B58.setBackgroundResource(R.drawable.button_profile_std);
                B59.setBackgroundResource(R.drawable.button_profile_std);
                B60.setBackgroundResource(R.drawable.button_primary_solid);
                B61.setBackgroundResource(R.drawable.button_profile_std);
                B62.setBackgroundResource(R.drawable.button_profile_std);
                B63.setBackgroundResource(R.drawable.button_profile_std);
                B64.setBackgroundResource(R.drawable.button_profile_std);
                B65.setBackgroundResource(R.drawable.button_profile_std);
                B66.setBackgroundResource(R.drawable.button_profile_std);
                q6 = 4;
                System.out.println("Q6= " + q6);
                break;
            case R.id.button95:
                B56.setBackgroundResource(R.drawable.button_profile_std);
                B57.setBackgroundResource(R.drawable.button_profile_std);
                B58.setBackgroundResource(R.drawable.button_profile_std);
                B59.setBackgroundResource(R.drawable.button_profile_std);
                B60.setBackgroundResource(R.drawable.button_profile_std);
                B61.setBackgroundResource(R.drawable.button_primary_solid);
                B62.setBackgroundResource(R.drawable.button_profile_std);
                B63.setBackgroundResource(R.drawable.button_profile_std);
                B64.setBackgroundResource(R.drawable.button_profile_std);
                B65.setBackgroundResource(R.drawable.button_profile_std);
                B66.setBackgroundResource(R.drawable.button_profile_std);
                q6 = 5;
                System.out.println("Q6= " + q6);
                break;
            case R.id.button94:
                B56.setBackgroundResource(R.drawable.button_profile_std);
                B57.setBackgroundResource(R.drawable.button_profile_std);
                B58.setBackgroundResource(R.drawable.button_profile_std);
                B59.setBackgroundResource(R.drawable.button_profile_std);
                B60.setBackgroundResource(R.drawable.button_profile_std);
                B61.setBackgroundResource(R.drawable.button_profile_std);
                B62.setBackgroundResource(R.drawable.button_primary_solid);
                B63.setBackgroundResource(R.drawable.button_profile_std);
                B64.setBackgroundResource(R.drawable.button_profile_std);
                B65.setBackgroundResource(R.drawable.button_profile_std);
                B66.setBackgroundResource(R.drawable.button_profile_std);
                q6 = 6;
                System.out.println("Q6= " + q6);
                break;
            case R.id.button93:
                B56.setBackgroundResource(R.drawable.button_profile_std);
                B57.setBackgroundResource(R.drawable.button_profile_std);
                B58.setBackgroundResource(R.drawable.button_profile_std);
                B59.setBackgroundResource(R.drawable.button_profile_std);
                B60.setBackgroundResource(R.drawable.button_profile_std);
                B61.setBackgroundResource(R.drawable.button_profile_std);
                B62.setBackgroundResource(R.drawable.button_profile_std);
                B63.setBackgroundResource(R.drawable.button_primary_solid);
                B64.setBackgroundResource(R.drawable.button_profile_std);
                B65.setBackgroundResource(R.drawable.button_profile_std);
                B66.setBackgroundResource(R.drawable.button_profile_std);
                q6 = 7;
                System.out.println("Q6= " + q6);
                break;
            case R.id.button92:
                B56.setBackgroundResource(R.drawable.button_profile_std);
                B57.setBackgroundResource(R.drawable.button_profile_std);
                B58.setBackgroundResource(R.drawable.button_profile_std);
                B59.setBackgroundResource(R.drawable.button_profile_std);
                B60.setBackgroundResource(R.drawable.button_profile_std);
                B61.setBackgroundResource(R.drawable.button_profile_std);
                B62.setBackgroundResource(R.drawable.button_profile_std);
                B63.setBackgroundResource(R.drawable.button_profile_std);
                B64.setBackgroundResource(R.drawable.button_primary_solid);
                B65.setBackgroundResource(R.drawable.button_profile_std);
                B66.setBackgroundResource(R.drawable.button_profile_std);
                q6 = 8;
                System.out.println("Q6= " + q6);
                break;
            case R.id.button82:
                B56.setBackgroundResource(R.drawable.button_profile_std);
                B57.setBackgroundResource(R.drawable.button_profile_std);
                B58.setBackgroundResource(R.drawable.button_profile_std);
                B59.setBackgroundResource(R.drawable.button_profile_std);
                B60.setBackgroundResource(R.drawable.button_profile_std);
                B61.setBackgroundResource(R.drawable.button_profile_std);
                B62.setBackgroundResource(R.drawable.button_profile_std);
                B63.setBackgroundResource(R.drawable.button_profile_std);
                B64.setBackgroundResource(R.drawable.button_profile_std);
                B65.setBackgroundResource(R.drawable.button_primary_solid);
                B66.setBackgroundResource(R.drawable.button_profile_std);
                q6 = 9;
                System.out.println("Q6= " + q6);
                break;
            case R.id.button145:
                B56.setBackgroundResource(R.drawable.button_profile_std);
                B57.setBackgroundResource(R.drawable.button_profile_std);
                B58.setBackgroundResource(R.drawable.button_profile_std);
                B59.setBackgroundResource(R.drawable.button_profile_std);
                B60.setBackgroundResource(R.drawable.button_profile_std);
                B61.setBackgroundResource(R.drawable.button_profile_std);
                B62.setBackgroundResource(R.drawable.button_profile_std);
                B63.setBackgroundResource(R.drawable.button_profile_std);
                B64.setBackgroundResource(R.drawable.button_profile_std);
                B65.setBackgroundResource(R.drawable.button_profile_std);
                B66.setBackgroundResource(R.drawable.button_primary_solid);
                q6 = 10;
                System.out.println("Q6= " + q6);
                break;
            case R.id.button110:
                B67.setBackgroundResource(R.drawable.button_primary_solid);
                B68.setBackgroundResource(R.drawable.button_profile_std);
                B69.setBackgroundResource(R.drawable.button_profile_std);
                B70.setBackgroundResource(R.drawable.button_profile_std);
                B71.setBackgroundResource(R.drawable.button_profile_std);
                B72.setBackgroundResource(R.drawable.button_profile_std);
                B73.setBackgroundResource(R.drawable.button_profile_std);
                B74.setBackgroundResource(R.drawable.button_profile_std);
                B75.setBackgroundResource(R.drawable.button_profile_std);
                B76.setBackgroundResource(R.drawable.button_profile_std);
                B77.setBackgroundResource(R.drawable.button_profile_std);
                q7 = 0;
                System.out.println("Q7= " + q7);
                break;
            case R.id.button109:
                B67.setBackgroundResource(R.drawable.button_profile_std);
                B68.setBackgroundResource(R.drawable.button_primary_solid);
                B69.setBackgroundResource(R.drawable.button_profile_std);
                B70.setBackgroundResource(R.drawable.button_profile_std);
                B71.setBackgroundResource(R.drawable.button_profile_std);
                B72.setBackgroundResource(R.drawable.button_profile_std);
                B73.setBackgroundResource(R.drawable.button_profile_std);
                B74.setBackgroundResource(R.drawable.button_profile_std);
                B75.setBackgroundResource(R.drawable.button_profile_std);
                B76.setBackgroundResource(R.drawable.button_profile_std);
                B77.setBackgroundResource(R.drawable.button_profile_std);
                q7 = 1;
                System.out.println("Q7= " + q7);
                break;
            case R.id.button108:
                B67.setBackgroundResource(R.drawable.button_profile_std);
                B68.setBackgroundResource(R.drawable.button_profile_std);
                B69.setBackgroundResource(R.drawable.button_primary_solid);
                B70.setBackgroundResource(R.drawable.button_profile_std);
                B71.setBackgroundResource(R.drawable.button_profile_std);
                B72.setBackgroundResource(R.drawable.button_profile_std);
                B73.setBackgroundResource(R.drawable.button_profile_std);
                B74.setBackgroundResource(R.drawable.button_profile_std);
                B75.setBackgroundResource(R.drawable.button_profile_std);
                B76.setBackgroundResource(R.drawable.button_profile_std);
                B77.setBackgroundResource(R.drawable.button_profile_std);
                q7 = 2;
                System.out.println("Q7= " + q7);
                break;
            case R.id.button107:
                B67.setBackgroundResource(R.drawable.button_profile_std);
                B68.setBackgroundResource(R.drawable.button_profile_std);
                B69.setBackgroundResource(R.drawable.button_profile_std);
                B70.setBackgroundResource(R.drawable.button_primary_solid);
                B71.setBackgroundResource(R.drawable.button_profile_std);
                B72.setBackgroundResource(R.drawable.button_profile_std);
                B73.setBackgroundResource(R.drawable.button_profile_std);
                B74.setBackgroundResource(R.drawable.button_profile_std);
                B75.setBackgroundResource(R.drawable.button_profile_std);
                B76.setBackgroundResource(R.drawable.button_profile_std);
                B77.setBackgroundResource(R.drawable.button_profile_std);
                q7 = 3;
                System.out.println("Q7= " + q7);
                break;
            case R.id.button106:
                B67.setBackgroundResource(R.drawable.button_profile_std);
                B68.setBackgroundResource(R.drawable.button_profile_std);
                B69.setBackgroundResource(R.drawable.button_profile_std);
                B70.setBackgroundResource(R.drawable.button_profile_std);
                B71.setBackgroundResource(R.drawable.button_primary_solid);
                B72.setBackgroundResource(R.drawable.button_profile_std);
                B73.setBackgroundResource(R.drawable.button_profile_std);
                B74.setBackgroundResource(R.drawable.button_profile_std);
                B75.setBackgroundResource(R.drawable.button_profile_std);
                B76.setBackgroundResource(R.drawable.button_profile_std);
                B77.setBackgroundResource(R.drawable.button_profile_std);
                q7 = 4;
                System.out.println("Q7= " + q7);
                break;
            case R.id.button105:
                B67.setBackgroundResource(R.drawable.button_profile_std);
                B68.setBackgroundResource(R.drawable.button_profile_std);
                B69.setBackgroundResource(R.drawable.button_profile_std);
                B70.setBackgroundResource(R.drawable.button_profile_std);
                B71.setBackgroundResource(R.drawable.button_profile_std);
                B72.setBackgroundResource(R.drawable.button_primary_solid);
                B73.setBackgroundResource(R.drawable.button_profile_std);
                B74.setBackgroundResource(R.drawable.button_profile_std);
                B75.setBackgroundResource(R.drawable.button_profile_std);
                B76.setBackgroundResource(R.drawable.button_profile_std);
                B77.setBackgroundResource(R.drawable.button_profile_std);
                q7 = 5;
                System.out.println("Q7= " + q7);
                break;
            case R.id.button104:
                B67.setBackgroundResource(R.drawable.button_profile_std);
                B68.setBackgroundResource(R.drawable.button_profile_std);
                B69.setBackgroundResource(R.drawable.button_profile_std);
                B70.setBackgroundResource(R.drawable.button_profile_std);
                B71.setBackgroundResource(R.drawable.button_profile_std);
                B72.setBackgroundResource(R.drawable.button_profile_std);
                B73.setBackgroundResource(R.drawable.button_primary_solid);
                B74.setBackgroundResource(R.drawable.button_profile_std);
                B75.setBackgroundResource(R.drawable.button_profile_std);
                B76.setBackgroundResource(R.drawable.button_profile_std);
                B77.setBackgroundResource(R.drawable.button_profile_std);
                q7 = 6;
                System.out.println("Q7= " + q7);
                break;
            case R.id.button103:
                B67.setBackgroundResource(R.drawable.button_profile_std);
                B68.setBackgroundResource(R.drawable.button_profile_std);
                B69.setBackgroundResource(R.drawable.button_profile_std);
                B70.setBackgroundResource(R.drawable.button_profile_std);
                B71.setBackgroundResource(R.drawable.button_profile_std);
                B72.setBackgroundResource(R.drawable.button_profile_std);
                B73.setBackgroundResource(R.drawable.button_profile_std);
                B74.setBackgroundResource(R.drawable.button_primary_solid);
                B75.setBackgroundResource(R.drawable.button_profile_std);
                B76.setBackgroundResource(R.drawable.button_profile_std);
                B77.setBackgroundResource(R.drawable.button_profile_std);
                q7 = 7;
                System.out.println("Q7= " + q7);
                break;
            case R.id.button102:
                B67.setBackgroundResource(R.drawable.button_profile_std);
                B68.setBackgroundResource(R.drawable.button_profile_std);
                B69.setBackgroundResource(R.drawable.button_profile_std);
                B70.setBackgroundResource(R.drawable.button_profile_std);
                B71.setBackgroundResource(R.drawable.button_profile_std);
                B72.setBackgroundResource(R.drawable.button_profile_std);
                B73.setBackgroundResource(R.drawable.button_profile_std);
                B74.setBackgroundResource(R.drawable.button_profile_std);
                B75.setBackgroundResource(R.drawable.button_primary_solid);
                B76.setBackgroundResource(R.drawable.button_profile_std);
                B77.setBackgroundResource(R.drawable.button_profile_std);
                q7 = 8;
                System.out.println("Q7= " + q7);
                break;
            case R.id.button101:
                B67.setBackgroundResource(R.drawable.button_profile_std);
                B68.setBackgroundResource(R.drawable.button_profile_std);
                B69.setBackgroundResource(R.drawable.button_profile_std);
                B70.setBackgroundResource(R.drawable.button_profile_std);
                B71.setBackgroundResource(R.drawable.button_profile_std);
                B72.setBackgroundResource(R.drawable.button_profile_std);
                B73.setBackgroundResource(R.drawable.button_profile_std);
                B74.setBackgroundResource(R.drawable.button_profile_std);
                B75.setBackgroundResource(R.drawable.button_profile_std);
                B76.setBackgroundResource(R.drawable.button_primary_solid);
                B77.setBackgroundResource(R.drawable.button_profile_std);
                q7 = 9;
                System.out.println("Q7= " + q7);
                break;
            case R.id.button144:
                B67.setBackgroundResource(R.drawable.button_profile_std);
                B68.setBackgroundResource(R.drawable.button_profile_std);
                B69.setBackgroundResource(R.drawable.button_profile_std);
                B70.setBackgroundResource(R.drawable.button_profile_std);
                B71.setBackgroundResource(R.drawable.button_profile_std);
                B72.setBackgroundResource(R.drawable.button_profile_std);
                B73.setBackgroundResource(R.drawable.button_profile_std);
                B74.setBackgroundResource(R.drawable.button_profile_std);
                B75.setBackgroundResource(R.drawable.button_profile_std);
                B76.setBackgroundResource(R.drawable.button_profile_std);
                B77.setBackgroundResource(R.drawable.button_primary_solid);
                q7 = 10;
                System.out.println("Q7= " + q7);
                break;
            case R.id.button120:
                B78.setBackgroundResource(R.drawable.button_primary_solid);
                B79.setBackgroundResource(R.drawable.button_profile_std);
                B80.setBackgroundResource(R.drawable.button_profile_std);
                B81.setBackgroundResource(R.drawable.button_profile_std);
                B82.setBackgroundResource(R.drawable.button_profile_std);
                B83.setBackgroundResource(R.drawable.button_profile_std);
                B84.setBackgroundResource(R.drawable.button_profile_std);
                B85.setBackgroundResource(R.drawable.button_profile_std);
                B86.setBackgroundResource(R.drawable.button_profile_std);
                B87.setBackgroundResource(R.drawable.button_profile_std);
                B88.setBackgroundResource(R.drawable.button_profile_std);
                q8 = 0;
                System.out.println("Q8= " + q8);
                break;
            case R.id.button119:
                B78.setBackgroundResource(R.drawable.button_profile_std);
                B79.setBackgroundResource(R.drawable.button_primary_solid);
                B80.setBackgroundResource(R.drawable.button_profile_std);
                B81.setBackgroundResource(R.drawable.button_profile_std);
                B82.setBackgroundResource(R.drawable.button_profile_std);
                B83.setBackgroundResource(R.drawable.button_profile_std);
                B84.setBackgroundResource(R.drawable.button_profile_std);
                B85.setBackgroundResource(R.drawable.button_profile_std);
                B86.setBackgroundResource(R.drawable.button_profile_std);
                B87.setBackgroundResource(R.drawable.button_profile_std);
                B88.setBackgroundResource(R.drawable.button_profile_std);
                q8 = 1;
                System.out.println("Q8= " + q8);
                break;
            case R.id.button118:
                B78.setBackgroundResource(R.drawable.button_profile_std);
                B79.setBackgroundResource(R.drawable.button_profile_std);
                B80.setBackgroundResource(R.drawable.button_primary_solid);
                B81.setBackgroundResource(R.drawable.button_profile_std);
                B82.setBackgroundResource(R.drawable.button_profile_std);
                B83.setBackgroundResource(R.drawable.button_profile_std);
                B84.setBackgroundResource(R.drawable.button_profile_std);
                B85.setBackgroundResource(R.drawable.button_profile_std);
                B86.setBackgroundResource(R.drawable.button_profile_std);
                B87.setBackgroundResource(R.drawable.button_profile_std);
                B88.setBackgroundResource(R.drawable.button_profile_std);
                q8 = 2;
                System.out.println("Q8= " + q8);
                break;
            case R.id.button117:
                B78.setBackgroundResource(R.drawable.button_profile_std);
                B79.setBackgroundResource(R.drawable.button_profile_std);
                B80.setBackgroundResource(R.drawable.button_profile_std);
                B81.setBackgroundResource(R.drawable.button_primary_solid);
                B82.setBackgroundResource(R.drawable.button_profile_std);
                B83.setBackgroundResource(R.drawable.button_profile_std);
                B84.setBackgroundResource(R.drawable.button_profile_std);
                B85.setBackgroundResource(R.drawable.button_profile_std);
                B86.setBackgroundResource(R.drawable.button_profile_std);
                B87.setBackgroundResource(R.drawable.button_profile_std);
                B88.setBackgroundResource(R.drawable.button_profile_std);
                q8 = 3;
                System.out.println("Q8= " + q8);
                break;
            case R.id.button116:
                B78.setBackgroundResource(R.drawable.button_profile_std);
                B79.setBackgroundResource(R.drawable.button_profile_std);
                B80.setBackgroundResource(R.drawable.button_profile_std);
                B81.setBackgroundResource(R.drawable.button_profile_std);
                B82.setBackgroundResource(R.drawable.button_primary_solid);
                B83.setBackgroundResource(R.drawable.button_profile_std);
                B84.setBackgroundResource(R.drawable.button_profile_std);
                B85.setBackgroundResource(R.drawable.button_profile_std);
                B86.setBackgroundResource(R.drawable.button_profile_std);
                B87.setBackgroundResource(R.drawable.button_profile_std);
                B88.setBackgroundResource(R.drawable.button_profile_std);
                q8 = 4;
                System.out.println("Q8= " + q8);
                break;
            case R.id.button115:
                B78.setBackgroundResource(R.drawable.button_profile_std);
                B79.setBackgroundResource(R.drawable.button_profile_std);
                B80.setBackgroundResource(R.drawable.button_profile_std);
                B81.setBackgroundResource(R.drawable.button_profile_std);
                B82.setBackgroundResource(R.drawable.button_profile_std);
                B83.setBackgroundResource(R.drawable.button_primary_solid);
                B84.setBackgroundResource(R.drawable.button_profile_std);
                B85.setBackgroundResource(R.drawable.button_profile_std);
                B86.setBackgroundResource(R.drawable.button_profile_std);
                B87.setBackgroundResource(R.drawable.button_profile_std);
                B88.setBackgroundResource(R.drawable.button_profile_std);
                q8 = 5;
                System.out.println("Q8= " + q8);
                break;
            case R.id.button114:
                B78.setBackgroundResource(R.drawable.button_profile_std);
                B79.setBackgroundResource(R.drawable.button_profile_std);
                B80.setBackgroundResource(R.drawable.button_profile_std);
                B81.setBackgroundResource(R.drawable.button_profile_std);
                B82.setBackgroundResource(R.drawable.button_profile_std);
                B83.setBackgroundResource(R.drawable.button_profile_std);
                B84.setBackgroundResource(R.drawable.button_primary_solid);
                B85.setBackgroundResource(R.drawable.button_profile_std);
                B86.setBackgroundResource(R.drawable.button_profile_std);
                B87.setBackgroundResource(R.drawable.button_profile_std);
                B88.setBackgroundResource(R.drawable.button_profile_std);
                q8 = 6;
                System.out.println("Q8= " + q8);
                break;
            case R.id.button113:
                B78.setBackgroundResource(R.drawable.button_profile_std);
                B79.setBackgroundResource(R.drawable.button_profile_std);
                B80.setBackgroundResource(R.drawable.button_profile_std);
                B81.setBackgroundResource(R.drawable.button_profile_std);
                B82.setBackgroundResource(R.drawable.button_profile_std);
                B83.setBackgroundResource(R.drawable.button_profile_std);
                B84.setBackgroundResource(R.drawable.button_profile_std);
                B85.setBackgroundResource(R.drawable.button_primary_solid);
                B86.setBackgroundResource(R.drawable.button_profile_std);
                B87.setBackgroundResource(R.drawable.button_profile_std);
                B88.setBackgroundResource(R.drawable.button_profile_std);
                q8 = 7;
                System.out.println("Q8= " + q8);
                break;
            case R.id.button112:
                B78.setBackgroundResource(R.drawable.button_profile_std);
                B79.setBackgroundResource(R.drawable.button_profile_std);
                B80.setBackgroundResource(R.drawable.button_profile_std);
                B81.setBackgroundResource(R.drawable.button_profile_std);
                B82.setBackgroundResource(R.drawable.button_profile_std);
                B83.setBackgroundResource(R.drawable.button_profile_std);
                B84.setBackgroundResource(R.drawable.button_profile_std);
                B85.setBackgroundResource(R.drawable.button_profile_std);
                B86.setBackgroundResource(R.drawable.button_primary_solid);
                B87.setBackgroundResource(R.drawable.button_profile_std);
                B88.setBackgroundResource(R.drawable.button_profile_std);
                q8 = 8;
                System.out.println("Q8= " + q8);
                break;
            case R.id.button111:
                B78.setBackgroundResource(R.drawable.button_profile_std);
                B79.setBackgroundResource(R.drawable.button_profile_std);
                B80.setBackgroundResource(R.drawable.button_profile_std);
                B81.setBackgroundResource(R.drawable.button_profile_std);
                B82.setBackgroundResource(R.drawable.button_profile_std);
                B83.setBackgroundResource(R.drawable.button_profile_std);
                B84.setBackgroundResource(R.drawable.button_profile_std);
                B85.setBackgroundResource(R.drawable.button_profile_std);
                B86.setBackgroundResource(R.drawable.button_profile_std);
                B87.setBackgroundResource(R.drawable.button_primary_solid);
                B88.setBackgroundResource(R.drawable.button_profile_std);
                q8 = 9;
                System.out.println("Q8= " + q8);
                break;
            case R.id.button143:
                B78.setBackgroundResource(R.drawable.button_profile_std);
                B79.setBackgroundResource(R.drawable.button_profile_std);
                B80.setBackgroundResource(R.drawable.button_profile_std);
                B81.setBackgroundResource(R.drawable.button_profile_std);
                B82.setBackgroundResource(R.drawable.button_profile_std);
                B83.setBackgroundResource(R.drawable.button_profile_std);
                B84.setBackgroundResource(R.drawable.button_profile_std);
                B85.setBackgroundResource(R.drawable.button_profile_std);
                B86.setBackgroundResource(R.drawable.button_profile_std);
                B87.setBackgroundResource(R.drawable.button_profile_std);
                B88.setBackgroundResource(R.drawable.button_primary_solid);
                q8 = 10;
                System.out.println("Q8= " + q8);
                break;
            case R.id.button142:
                B89.setBackgroundResource(R.drawable.button_primary_solid);
                B90.setBackgroundResource(R.drawable.button_profile_std);
                B91.setBackgroundResource(R.drawable.button_profile_std);
                B92.setBackgroundResource(R.drawable.button_profile_std);
                B93.setBackgroundResource(R.drawable.button_profile_std);
                B94.setBackgroundResource(R.drawable.button_profile_std);
                B95.setBackgroundResource(R.drawable.button_profile_std);
                B96.setBackgroundResource(R.drawable.button_profile_std);
                B97.setBackgroundResource(R.drawable.button_profile_std);
                B98.setBackgroundResource(R.drawable.button_profile_std);
                B99.setBackgroundResource(R.drawable.button_profile_std);
                q9 = 0;
                System.out.println("Q9= " + q9);
                break;
            case R.id.button130:
                B89.setBackgroundResource(R.drawable.button_profile_std);
                B90.setBackgroundResource(R.drawable.button_primary_solid);
                B91.setBackgroundResource(R.drawable.button_profile_std);
                B92.setBackgroundResource(R.drawable.button_profile_std);
                B93.setBackgroundResource(R.drawable.button_profile_std);
                B94.setBackgroundResource(R.drawable.button_profile_std);
                B95.setBackgroundResource(R.drawable.button_profile_std);
                B96.setBackgroundResource(R.drawable.button_profile_std);
                B97.setBackgroundResource(R.drawable.button_profile_std);
                B98.setBackgroundResource(R.drawable.button_profile_std);
                B99.setBackgroundResource(R.drawable.button_profile_std);
                q9 = 1;
                System.out.println("Q9= " + q9);
                break;
            case R.id.button129:
                B89.setBackgroundResource(R.drawable.button_profile_std);
                B90.setBackgroundResource(R.drawable.button_profile_std);
                B91.setBackgroundResource(R.drawable.button_primary_solid);
                B92.setBackgroundResource(R.drawable.button_profile_std);
                B93.setBackgroundResource(R.drawable.button_profile_std);
                B94.setBackgroundResource(R.drawable.button_profile_std);
                B95.setBackgroundResource(R.drawable.button_profile_std);
                B96.setBackgroundResource(R.drawable.button_profile_std);
                B97.setBackgroundResource(R.drawable.button_profile_std);
                B98.setBackgroundResource(R.drawable.button_profile_std);
                B99.setBackgroundResource(R.drawable.button_profile_std);
                q9 = 2;
                System.out.println("Q9= " + q9);
                break;
            case R.id.button128:
                B89.setBackgroundResource(R.drawable.button_profile_std);
                B90.setBackgroundResource(R.drawable.button_profile_std);
                B91.setBackgroundResource(R.drawable.button_profile_std);
                B92.setBackgroundResource(R.drawable.button_primary_solid);
                B93.setBackgroundResource(R.drawable.button_profile_std);
                B94.setBackgroundResource(R.drawable.button_profile_std);
                B95.setBackgroundResource(R.drawable.button_profile_std);
                B96.setBackgroundResource(R.drawable.button_profile_std);
                B97.setBackgroundResource(R.drawable.button_profile_std);
                B98.setBackgroundResource(R.drawable.button_profile_std);
                B99.setBackgroundResource(R.drawable.button_profile_std);
                q9 = 3;
                System.out.println("Q9= " + q9);
                break;
            case R.id.button127:
                B89.setBackgroundResource(R.drawable.button_profile_std);
                B90.setBackgroundResource(R.drawable.button_profile_std);
                B91.setBackgroundResource(R.drawable.button_profile_std);
                B92.setBackgroundResource(R.drawable.button_profile_std);
                B93.setBackgroundResource(R.drawable.button_primary_solid);
                B94.setBackgroundResource(R.drawable.button_profile_std);
                B95.setBackgroundResource(R.drawable.button_profile_std);
                B96.setBackgroundResource(R.drawable.button_profile_std);
                B97.setBackgroundResource(R.drawable.button_profile_std);
                B98.setBackgroundResource(R.drawable.button_profile_std);
                B99.setBackgroundResource(R.drawable.button_profile_std);
                q9 = 4;
                System.out.println("Q9= " + q9);
                break;
            case R.id.button126:
                B89.setBackgroundResource(R.drawable.button_profile_std);
                B90.setBackgroundResource(R.drawable.button_profile_std);
                B91.setBackgroundResource(R.drawable.button_profile_std);
                B92.setBackgroundResource(R.drawable.button_profile_std);
                B93.setBackgroundResource(R.drawable.button_profile_std);
                B94.setBackgroundResource(R.drawable.button_primary_solid);
                B95.setBackgroundResource(R.drawable.button_profile_std);
                B96.setBackgroundResource(R.drawable.button_profile_std);
                B97.setBackgroundResource(R.drawable.button_profile_std);
                B98.setBackgroundResource(R.drawable.button_profile_std);
                B99.setBackgroundResource(R.drawable.button_profile_std);
                q9 = 5;
                System.out.println("Q9= " + q9);
                break;
            case R.id.button125:
                B89.setBackgroundResource(R.drawable.button_profile_std);
                B90.setBackgroundResource(R.drawable.button_profile_std);
                B91.setBackgroundResource(R.drawable.button_profile_std);
                B92.setBackgroundResource(R.drawable.button_profile_std);
                B93.setBackgroundResource(R.drawable.button_profile_std);
                B94.setBackgroundResource(R.drawable.button_profile_std);
                B95.setBackgroundResource(R.drawable.button_primary_solid);
                B96.setBackgroundResource(R.drawable.button_profile_std);
                B97.setBackgroundResource(R.drawable.button_profile_std);
                B98.setBackgroundResource(R.drawable.button_profile_std);
                B99.setBackgroundResource(R.drawable.button_profile_std);
                q9 = 6;
                System.out.println("Q9= " + q9);
                break;
            case R.id.button124:
                B89.setBackgroundResource(R.drawable.button_profile_std);
                B90.setBackgroundResource(R.drawable.button_profile_std);
                B91.setBackgroundResource(R.drawable.button_profile_std);
                B92.setBackgroundResource(R.drawable.button_profile_std);
                B93.setBackgroundResource(R.drawable.button_profile_std);
                B94.setBackgroundResource(R.drawable.button_profile_std);
                B95.setBackgroundResource(R.drawable.button_profile_std);
                B96.setBackgroundResource(R.drawable.button_primary_solid);
                B97.setBackgroundResource(R.drawable.button_profile_std);
                B98.setBackgroundResource(R.drawable.button_profile_std);
                B99.setBackgroundResource(R.drawable.button_profile_std);
                q9 = 7;
                System.out.println("Q9= " + q9);
                break;
            case R.id.button123:
                B89.setBackgroundResource(R.drawable.button_profile_std);
                B90.setBackgroundResource(R.drawable.button_profile_std);
                B91.setBackgroundResource(R.drawable.button_profile_std);
                B92.setBackgroundResource(R.drawable.button_profile_std);
                B93.setBackgroundResource(R.drawable.button_profile_std);
                B94.setBackgroundResource(R.drawable.button_profile_std);
                B95.setBackgroundResource(R.drawable.button_profile_std);
                B96.setBackgroundResource(R.drawable.button_profile_std);
                B97.setBackgroundResource(R.drawable.button_primary_solid);
                B98.setBackgroundResource(R.drawable.button_profile_std);
                B99.setBackgroundResource(R.drawable.button_profile_std);
                q9 = 8;
                System.out.println("Q9= " + q9);
                break;
            case R.id.button122:
                B89.setBackgroundResource(R.drawable.button_profile_std);
                B90.setBackgroundResource(R.drawable.button_profile_std);
                B91.setBackgroundResource(R.drawable.button_profile_std);
                B92.setBackgroundResource(R.drawable.button_profile_std);
                B93.setBackgroundResource(R.drawable.button_profile_std);
                B94.setBackgroundResource(R.drawable.button_profile_std);
                B95.setBackgroundResource(R.drawable.button_profile_std);
                B96.setBackgroundResource(R.drawable.button_profile_std);
                B97.setBackgroundResource(R.drawable.button_profile_std);
                B98.setBackgroundResource(R.drawable.button_primary_solid);
                B99.setBackgroundResource(R.drawable.button_profile_std);
                q9 = 9;
                System.out.println("Q9= " + q9);
                break;
            case R.id.button121:
                B89.setBackgroundResource(R.drawable.button_profile_std);
                B90.setBackgroundResource(R.drawable.button_profile_std);
                B91.setBackgroundResource(R.drawable.button_profile_std);
                B92.setBackgroundResource(R.drawable.button_profile_std);
                B93.setBackgroundResource(R.drawable.button_profile_std);
                B94.setBackgroundResource(R.drawable.button_profile_std);
                B95.setBackgroundResource(R.drawable.button_profile_std);
                B96.setBackgroundResource(R.drawable.button_profile_std);
                B97.setBackgroundResource(R.drawable.button_profile_std);
                B98.setBackgroundResource(R.drawable.button_profile_std);
                B99.setBackgroundResource(R.drawable.button_primary_solid);
                q9 = 10;
                System.out.println("Q9= " + q9);
                break;
            case R.id.button140:
                B100.setBackgroundResource(R.drawable.button_primary_solid);
                B101.setBackgroundResource(R.drawable.button_profile_std);
                B102.setBackgroundResource(R.drawable.button_profile_std);
                B103.setBackgroundResource(R.drawable.button_profile_std);
                B104.setBackgroundResource(R.drawable.button_profile_std);
                B105.setBackgroundResource(R.drawable.button_profile_std);
                B106.setBackgroundResource(R.drawable.button_profile_std);
                B107.setBackgroundResource(R.drawable.button_profile_std);
                B108.setBackgroundResource(R.drawable.button_profile_std);
                B109.setBackgroundResource(R.drawable.button_profile_std);
                B110.setBackgroundResource(R.drawable.button_profile_std);
                q10 = 0;
                System.out.println("Q10= " + q10);
                break;
            case R.id.button139:
                B100.setBackgroundResource(R.drawable.button_profile_std);
                B101.setBackgroundResource(R.drawable.button_primary_solid);
                B102.setBackgroundResource(R.drawable.button_profile_std);
                B103.setBackgroundResource(R.drawable.button_profile_std);
                B104.setBackgroundResource(R.drawable.button_profile_std);
                B105.setBackgroundResource(R.drawable.button_profile_std);
                B106.setBackgroundResource(R.drawable.button_profile_std);
                B107.setBackgroundResource(R.drawable.button_profile_std);
                B108.setBackgroundResource(R.drawable.button_profile_std);
                B109.setBackgroundResource(R.drawable.button_profile_std);
                B110.setBackgroundResource(R.drawable.button_profile_std);
                q10 = 1;
                System.out.println("Q10= " + q10);
                break;
            case R.id.button138:
                B100.setBackgroundResource(R.drawable.button_profile_std);
                B101.setBackgroundResource(R.drawable.button_profile_std);
                B102.setBackgroundResource(R.drawable.button_primary_solid);
                B103.setBackgroundResource(R.drawable.button_profile_std);
                B104.setBackgroundResource(R.drawable.button_profile_std);
                B105.setBackgroundResource(R.drawable.button_profile_std);
                B106.setBackgroundResource(R.drawable.button_profile_std);
                B107.setBackgroundResource(R.drawable.button_profile_std);
                B108.setBackgroundResource(R.drawable.button_profile_std);
                B109.setBackgroundResource(R.drawable.button_profile_std);
                B110.setBackgroundResource(R.drawable.button_profile_std);
                q10 = 2;
                System.out.println("Q10= " + q10);
                break;
            case R.id.button137:
                B100.setBackgroundResource(R.drawable.button_profile_std);
                B101.setBackgroundResource(R.drawable.button_profile_std);
                B102.setBackgroundResource(R.drawable.button_profile_std);
                B103.setBackgroundResource(R.drawable.button_primary_solid);
                B104.setBackgroundResource(R.drawable.button_profile_std);
                B105.setBackgroundResource(R.drawable.button_profile_std);
                B106.setBackgroundResource(R.drawable.button_profile_std);
                B107.setBackgroundResource(R.drawable.button_profile_std);
                B108.setBackgroundResource(R.drawable.button_profile_std);
                B109.setBackgroundResource(R.drawable.button_profile_std);
                B110.setBackgroundResource(R.drawable.button_profile_std);
                q10 = 3;
                System.out.println("Q10= " + q10);
                break;
            case R.id.button136:
                B100.setBackgroundResource(R.drawable.button_profile_std);
                B101.setBackgroundResource(R.drawable.button_profile_std);
                B102.setBackgroundResource(R.drawable.button_profile_std);
                B103.setBackgroundResource(R.drawable.button_profile_std);
                B104.setBackgroundResource(R.drawable.button_primary_solid);
                B105.setBackgroundResource(R.drawable.button_profile_std);
                B106.setBackgroundResource(R.drawable.button_profile_std);
                B107.setBackgroundResource(R.drawable.button_profile_std);
                B108.setBackgroundResource(R.drawable.button_profile_std);
                B109.setBackgroundResource(R.drawable.button_profile_std);
                B110.setBackgroundResource(R.drawable.button_profile_std);
                q10 = 4;
                System.out.println("Q10= " + q10);
                break;
            case R.id.button135:
                B100.setBackgroundResource(R.drawable.button_profile_std);
                B101.setBackgroundResource(R.drawable.button_profile_std);
                B102.setBackgroundResource(R.drawable.button_profile_std);
                B103.setBackgroundResource(R.drawable.button_profile_std);
                B104.setBackgroundResource(R.drawable.button_profile_std);
                B105.setBackgroundResource(R.drawable.button_primary_solid);
                B106.setBackgroundResource(R.drawable.button_profile_std);
                B107.setBackgroundResource(R.drawable.button_profile_std);
                B108.setBackgroundResource(R.drawable.button_profile_std);
                B109.setBackgroundResource(R.drawable.button_profile_std);
                B110.setBackgroundResource(R.drawable.button_profile_std);
                q10 = 5;
                System.out.println("Q10= " + q10);
                break;
            case R.id.button134:
                B100.setBackgroundResource(R.drawable.button_profile_std);
                B101.setBackgroundResource(R.drawable.button_profile_std);
                B102.setBackgroundResource(R.drawable.button_profile_std);
                B103.setBackgroundResource(R.drawable.button_profile_std);
                B104.setBackgroundResource(R.drawable.button_profile_std);
                B105.setBackgroundResource(R.drawable.button_profile_std);
                B106.setBackgroundResource(R.drawable.button_primary_solid);
                B107.setBackgroundResource(R.drawable.button_profile_std);
                B108.setBackgroundResource(R.drawable.button_profile_std);
                B109.setBackgroundResource(R.drawable.button_profile_std);
                B110.setBackgroundResource(R.drawable.button_profile_std);
                q10 = 6;
                System.out.println("Q10= " + q10);
                break;
            case R.id.button133:
                B100.setBackgroundResource(R.drawable.button_profile_std);
                B101.setBackgroundResource(R.drawable.button_profile_std);
                B102.setBackgroundResource(R.drawable.button_profile_std);
                B103.setBackgroundResource(R.drawable.button_profile_std);
                B104.setBackgroundResource(R.drawable.button_profile_std);
                B105.setBackgroundResource(R.drawable.button_profile_std);
                B106.setBackgroundResource(R.drawable.button_profile_std);
                B107.setBackgroundResource(R.drawable.button_primary_solid);
                B108.setBackgroundResource(R.drawable.button_profile_std);
                B109.setBackgroundResource(R.drawable.button_profile_std);
                B110.setBackgroundResource(R.drawable.button_profile_std);
                q10 = 7;
                System.out.println("Q10= " + q10);
                break;
            case R.id.button132:
                B100.setBackgroundResource(R.drawable.button_profile_std);
                B101.setBackgroundResource(R.drawable.button_profile_std);
                B102.setBackgroundResource(R.drawable.button_profile_std);
                B103.setBackgroundResource(R.drawable.button_profile_std);
                B104.setBackgroundResource(R.drawable.button_profile_std);
                B105.setBackgroundResource(R.drawable.button_profile_std);
                B106.setBackgroundResource(R.drawable.button_profile_std);
                B107.setBackgroundResource(R.drawable.button_profile_std);
                B108.setBackgroundResource(R.drawable.button_primary_solid);
                B109.setBackgroundResource(R.drawable.button_profile_std);
                B110.setBackgroundResource(R.drawable.button_profile_std);
                q10 = 8;
                System.out.println("Q10= " + q10);
                break;
            case R.id.button131:
                B100.setBackgroundResource(R.drawable.button_profile_std);
                B101.setBackgroundResource(R.drawable.button_profile_std);
                B102.setBackgroundResource(R.drawable.button_profile_std);
                B103.setBackgroundResource(R.drawable.button_profile_std);
                B104.setBackgroundResource(R.drawable.button_profile_std);
                B105.setBackgroundResource(R.drawable.button_profile_std);
                B106.setBackgroundResource(R.drawable.button_profile_std);
                B107.setBackgroundResource(R.drawable.button_profile_std);
                B108.setBackgroundResource(R.drawable.button_profile_std);
                B109.setBackgroundResource(R.drawable.button_primary_solid);
                B110.setBackgroundResource(R.drawable.button_profile_std);
                q10 = 9;
                System.out.println("Q10= " + q10);
                break;
            case R.id.button141:
                B100.setBackgroundResource(R.drawable.button_profile_std);
                B101.setBackgroundResource(R.drawable.button_profile_std);
                B102.setBackgroundResource(R.drawable.button_profile_std);
                B103.setBackgroundResource(R.drawable.button_profile_std);
                B104.setBackgroundResource(R.drawable.button_profile_std);
                B105.setBackgroundResource(R.drawable.button_profile_std);
                B106.setBackgroundResource(R.drawable.button_profile_std);
                B107.setBackgroundResource(R.drawable.button_profile_std);
                B108.setBackgroundResource(R.drawable.button_profile_std);
                B109.setBackgroundResource(R.drawable.button_profile_std);
                B110.setBackgroundResource(R.drawable.button_primary_solid);
                q10 = 10;
                System.out.println("Q10= " + q10);
                break;

            case R.id.button27:
                if (!finished) {
                    System.out.println(currentQuestion1.toString());
                    System.out.println(currentQuestion2.toString());
                    next();

                } else {
                    test.resolveFinishedDate();
                    MainMenu.getInstance().getUser().addToResults(test);
                    ResultListFragment nextFrag = new ResultListFragment();
                    this.getFragmentManager().beginTransaction()
                            .replace(R.id.article_fragment, nextFrag, null)
                            .addToBackStack(null)
                            .commit();
                }

                break;
        }
    }
}

