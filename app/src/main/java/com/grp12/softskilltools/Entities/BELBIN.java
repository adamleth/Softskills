package com.grp12.softskilltools.Entities;

import com.grp12.softskilltools.resources.BELBIN_Data;


/**
 * Created by mathiaslarsen on 18/11/2016.
 */

public class BELBIN extends AbstractItem {
    private final int totalQuestions = 70;
    private int PL,RI,CO,SH,ME,TW,IMP,CF,SP,DROP;
    public static Question[] questions;

    public BELBIN(double cost, boolean isUsed, String productName, String description) {
        super(cost, isUsed, productName, description);
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
        questions = new Question[totalQuestions];
        for (int i = 0; i < totalQuestions; i++){
            questions[i] = new Question(BELBIN_Data.BelbinWord_Data[i],BELBIN_Data.QuestionNo_DATA[i],BELBIN_Data.BELBINTYPE_Data[i]);
        }
    }

    public void setScore(Question question,int score){
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

    public void setQuestionAnswered(Question question){
        int questionNo = getQuestionNumber(question);
        questions[questionNo-1].setAnswered(true);
    }
    public int getCompletion(int totalQuestions, int currentQuestionNo ){
        int result = currentQuestionNo/totalQuestions*100;
        return result;
    }
    public int getQuestionNumber(Question question){
        int number  = 0;
        for(int i = 0; i < totalQuestions; i++){
            if(question == questions[i])
                number = i;
        }
        return number;

    }

    @Override
    public String toString() {
        return "BELBIN{}";
    }
}
