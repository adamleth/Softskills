package com.grp12.softskilltools.Entities;

import com.grp12.softskilltools.resources.BELBIN_Data;


/**
 * Created by Mathiaslarsen on 18/11/2016.
 */

public class BELBIN extends AbstractItem {
    private final int totalQuestions = 70;
    private int PL,RI,CO,SH,ME,TW,IMP,CF,SP,DROP;
    private int Complete;
    public static Question[] questions;
    Question nextQuestion;

    public BELBIN(double cost, boolean isUsed, String productName, String description, testType type) {
        super(cost, isUsed, productName, description, type);
        PL = 0;
        RI = 0;
        CO = 0;
        SH = 0;
        ME = 0;
        TW = 0;
        IMP = 0;
        CF = 0;
        SP = 0;
        DROP = 0;
        this.Complete = 0;
        initialize();
    }

    public void setDROP(int DROP) {
        this.DROP += DROP;
    }

    public void setSP(int SP) {
        this.SP += SP;
    }

    public void setCF(int CF) {
        this.CF += CF;
    }

    public void setIMP(int IMP) {
        this.IMP += IMP;
    }

    public void setTW(int TW) {
        this.TW += TW;
    }

    public void setME(int ME) {
        this.ME += ME;
    }

    public void setSH(int SH) {
        this.SH += SH;
    }

    public void setCO(int CO) {
        this.CO += CO;
    }

    public void setRI(int RI) {
        this.RI += RI;
    }

    public void setPL(int PL) {
        this.PL += PL;
    }

    public int getPL() {
        return PL;
    }

    public int getRI() {
        return RI;
    }

    public int getCO() {
        return CO;
    }

    public int getSH() {
        return SH;
    }

    public int getME() {
        return ME;
    }

    public int getTW() {
        return TW;
    }

    public int getIMP() {
        return IMP;
    }

    public int getCF() {
        return CF;
    }

    public int getSP() {
        return SP;
    }

    public int getDROP() {
        return DROP;
    }

    public void initialize(){

        /*********************************************
         * The Belbin-test logic begins *
         *********************************************/

        questions = new Question[totalQuestions];
        for (int i = 0; i < totalQuestions; i++){
            questions[i] = new Question(BELBIN_Data.BelbinWord_Data[i],BELBIN_Data.QuestionNo_DATA[i],BELBIN_Data.BELBINTYPE_Data[i]);
        }
    }



    public Question QUEUELOGIC(){

        /**********************************************************************
         * This method will get the next question from the stack of questions *
         **********************************************************************/

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

        /**********************************************************
         * This method will set the score depending on the answer *
         **********************************************************/

        switch(question.getType()){

            case PL:
                setPL(score);
                break;
            case RI:
                setRI(score);
                break;
            case CO:
                setCO(score);
                break;
            case SH:
               setSH(score);
                break;
            case ME:
                setME(score);
                break;
            case TW:
                setTW(score);
                break;
            case IMP:
                setIMP(score);
                break;
            case CF:
                setCF(score);
                break;
            case SP:
                setSP(score);
                break;
            case DROP:
                setDROP(score);
                break;

        }
    }


    public int getCompletion(){

        /***************************************
         * This method will	get the completion *
         ***************************************/

        return Complete;
    }
    public void setQuestionAnswered(Question question){

        /*************************************************
         * This method will	set the question as answered *
         *************************************************/

        int questionNo = getQuestionNumber(question);
        questions[questionNo-1].setAnswered(true);
        calculateCompletion(totalQuestions,question.getQuestionNo());
    }


    private void calculateCompletion(int totalQuestions, int currentQuestionNo ){

        /*************************************************************
         * This method will	calculate if the result is in line with the
         * current question number and the total amount of questions *
         *************************************************************/

        int result = currentQuestionNo/totalQuestions*100;
        this.Complete = result;
    }

    private int getQuestionPosition(Question question){

        /*********************************************************
         * This method will	check for the position of a question *
         *********************************************************/

        int number  = 0;
        for(int i = 0; i < totalQuestions; i++){
            if(question == questions[i])
                number = i;
        }
        return number;

    }

    public int getQuestionNumber(Question question){

        /**************************************************
         * This method will	get the number of a questions *
         **************************************************/

        int number  = 0;
        for(int i = 0; i < totalQuestions; i++){
            if(question == questions[i])
                number = i;
        }
        return number;

        /****************************
         * The Belbin-test logic ends *
         ****************************/
    }

    @Override
    public String toString() {
        return "BELBIN{}";
    }
}
