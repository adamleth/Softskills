package com.grp12.softskilltools.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.galgespil.stvhendeop.menuapp.R;
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
        ACTION = (Button) myView.findViewById(R.id.button27);

        this.currentQuestion1 = loadQuestion(holder.question1);this.currentQuestion2 = loadQuestion(holder.question2);
        this.currentQuestion3 = loadQuestion(holder.question3);this.currentQuestion4 = loadQuestion(holder.question4);
        this.currentQuestion5 = loadQuestion(holder.question5);this.currentQuestion6 = loadQuestion(holder.question6);
        this.currentQuestion7 = loadQuestion(holder.question7);this.currentQuestion8 = loadQuestion(holder.question8);
        this.currentQuestion9 = loadQuestion(holder.question9);this.currentQuestion10 = loadQuestion(holder.question10);







        return myView;
    }

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
            q1 = 0;q2 = 0;q3 = 0;q4 = 0;q5 = 0;
            q6 = 0;q7 = 0;q8 = 0;q9 = 0;q10 = 0;

        }
    }

    public void update(Question question, int score){
        test.setQuestionAnswered(question);
        test.setScore(question,score);
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

    }
}

