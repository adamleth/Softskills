package com.grp12.softskilltools.Entities;

import com.grp12.softskilltools.resources.DISC_Data;

import java.util.Date;

/**
 * Created by mathiaslarsen on 18/11/2016.
 */

public class DISC extends AbstractItem {
    private int Dom,Inf,Sta,Com;
    private boolean isUsed;
    private int Complete;
    public final int totalQuestions = 72;
    private static Question[] questions;

    Question nextQuestion;


    public DISC(double cost, boolean isUsed, String productName, String description, testType type ) {
        super(cost, isUsed, productName, description, type);
        Dom = 0;
        Inf = 0;
        Sta = 0;
        Com = 0;
        this.Complete =  getCompletion();

        initialize();

    }


    public int getDom() {

        return Dom;
    }

    private void setDom(int dom) {

        this.Dom += dom;
    }

    public int getInf() {

        return Inf;
    }

    private void setInf(int inf) {

        this.Inf += inf;
    }

    public int getSta() {

        return Sta;
    }

    private void setSta(int sta) {

        this.Sta += sta;
    }

    public int getCom() {

        return Com;
    }

    public void setCom(int com) {

        this.Com += com;
    }



    /**********************************************
     * This method will	begin the DISC-test logic *
     **********************************************/

    private void initialize(){

        questions = new Question[totalQuestions];
        for (int i = 0; i < totalQuestions; i++){
            questions[i] = new Question(DISC_Data.DISCWord_Data[i],DISC_Data.QuestionNo_DATA[i],DISC_Data.DISCTYPE_Data[i]);
        }
    }

    /*************************************************************
     * This method will	get the next question from the questions *
     *************************************************************/

    public Question QUEUELOGIC() {

            this.nextQuestion = questions[0];
            if (!nextQuestion.getAnswered()) {
                //ACTION
                for (int i = 0; i < (questions.length - 1); i++) {
                    questions[i] = questions[i + 1];
                }
                questions[questions.length-1] = this.nextQuestion;
            }

        else {
                return null;
                }

        System.out.println(Inf + " "+ Com + " " +Sta + " " +Dom);
            return nextQuestion;
        }

    /**********************************
     * This method will	set the score *
     *********************************/

    public void setScore(Question question,int score){

    switch(question.getType()){

        case Com:
            setCom(score);
            break;
        case Sta:
            setSta(score);
            break;
        case Inf:
            setInf(score);
            break;
        case Dom:
            setDom(score);
            break;
    }
    }

    /**********************************************************
     * This method will	set the answered question as answered *
     **********************************************************/

    public void setQuestionAnswered(Question question){

        int position = getQuestionPosition(question);
        questions[position].setAnswered(true);
        calculateCompletion(totalQuestions,question.getQuestionNo());
        getCompletion();
    }

    /***************************************
     * This method will	get the completion *
     ***************************************/

    public int getCompletion(){
        System.out.println("Progress " + super.getCompletion());
        return super.Complete;
    }

    /*********************************************
     * This method will	calculate the completion *
     *********************************************/

    public void calculateCompletion(int totalQuestions, int currentQuestionNo ){
        super.calculateCompletion(totalQuestions,currentQuestionNo);
    }

    /*********************************************************
     * This method will	check for the position of a question *
     *********************************************************/

    private int getQuestionPosition(Question question){

        int number  = 0;
        for(int i = 0; i < totalQuestions; i++){
            if(question == questions[i])
                number = i;
        }
        return number;

    }
    public int getQuestionNumber(Question question){
        int position = getQuestionPosition(question);
        return questions[position].getQuestionNo();

    }

    /****************************
     * The DISC-test logic ends *
     ****************************/

    @Override
    public String toString() {
        return "DISC{" +
                "Dom=" + Dom +
                ", Inf=" + Inf +
                ", Sta=" + Sta +
                ", Com=" + Com +
                ", isUsed=" + isUsed +
                ", Complete=" + Complete +
                ", totalQuestions=" + totalQuestions +
                '}';
    }
}
