package com.grp12.softskilltools.Entities;

import com.grp12.softskilltools.resources.DISC_Data;

/**
 * Created by mathiaslarsen on 18/11/2016.
 */

public class DISC extends AbstractItem {
    private int Dom,Inf,Sta,Com;
    private boolean isUsed;
    private int Complete;
    private final int totalQuestions = 72;
    public static Question[] questions;


    public DISC(double cost, boolean isUsed, String productName, String description ) {
        super(cost, isUsed, productName, description);
        Dom = 0;
        Inf = 0;
        Sta = 0;
        Com = 0;
        this.Complete = getCompletion();

        initialize();

    }

    public int getDom() {

        return Dom;
    }

    public void setDom(int dom) {

        this.Dom += dom;
    }

    public int getInf() {

        return Inf;
    }

    public void setInf(int inf) {

        this.Inf += inf;
    }

    public int getSta() {

        return Sta;
    }

    public void setSta(int sta) {

        this.Sta += sta;
    }

    public int getCom() {

        return Com;
    }

    public void setCom(int com) {

        this.Com += com;
    }




    /**DISC TEST LOGIC BEGIN**/
    public void initialize(){
        questions = new Question[totalQuestions];
        for (int i = 0; i < totalQuestions; i++){
            questions[i] = new Question(DISC_Data.DISCWord_Data[i],DISC_Data.QuestionNo_DATA[i],DISC_Data.DISCTYPE_Data[i]);
        }
    }

    public Question QUEUELOGIC(){
        /**Get next question from questions**/

        Question nextQuestion;

            nextQuestion = questions[0];
            if (nextQuestion.getAnswered() == false) {
                //ACTION
                for (int i = 0; i < (questions.length - 1); i++) {
                    questions[i] = questions[i + 1];
                }
                questions[questions.length - 1] = nextQuestion;
                return nextQuestion;
            }
            isUsed = true;
            //Lav et resultat
            return null;
        }

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

    public void setQuestionAnswered(Question question){
        int questionNo = getQuestionNumber(question);
        questions[questionNo-1].setAnswered(true);
        calculateCompletion(totalQuestions,questionNo);
    }
    public int getCompletion(){

        return Complete;
    }
    public void calculateCompletion(int totalQuestions, int currentQuestionNo ){
        int result = currentQuestionNo/totalQuestions*100;
        this.Complete = result;
    }
    public int getQuestionNumber(Question question){
        int number  = 0;
        for(int i = 0; i < totalQuestions; i++){
            if(question == questions[i])
                number = i;
        }
        return number;

    }

    /**DISC TEST LOGIC END**/

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
