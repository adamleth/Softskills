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




    /**DISC TEST LOGIC BEGIN**/
    private void initialize(){
        questions = new Question[totalQuestions];
        for (int i = 0; i < totalQuestions; i++){
            questions[i] = new Question(DISC_Data.DISCWord_Data[i],DISC_Data.QuestionNo_DATA[i],DISC_Data.DISCTYPE_Data[i]);
        }
    }

    public Question QUEUELOGIC(){
        /**Get next question from questions**/



            this.nextQuestion = questions[0];
            if (!nextQuestion.getAnswered()) {
                //ACTION
                for (int i = 0; i < (questions.length - 1); i++) {
                    questions[i] = questions[i + 1];
                }
                questions[questions.length-1] = this.nextQuestion;



            }
        else{
                return null;
                }

            return nextQuestion;
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
        int position = getQuestionPosition(question);
        questions[position].setAnswered(true);
        calculateCompletion(totalQuestions,question.getQuestionNo());
    }
    public int getCompletion(){

        return Complete;
    }
    private void calculateCompletion(int totalQuestions, int currentQuestionNo ){
        int result = currentQuestionNo/totalQuestions*100;
        this.Complete = result;
    }
    private int getQuestionPosition(Question question){
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
