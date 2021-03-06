package com.grp12.softskilltools.SOAP;

//------------------------------------------------------------------------------
// <wsdl2code-generated>
//    This code was generated by http://www.wsdl2code.com version  2.6
//
// Date Of Creation: 5/13/2017 3:12:55 PM
//    Please dont change this code, regeneration will override your changes
//</wsdl2code-generated>
//
//------------------------------------------------------------------------------
//
//This source code was auto-generated by Wsdl2Code  Version
//
import com.grp12.softskilltools.SOAP.WS_Enums.*;
import com.grp12.softskilltools.SOAP.question;
import com.grp12.softskilltools.SOAP.Vectorquestion;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import java.util.Hashtable;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

public class belbin implements KvmSerializable {
    
    public int totalQuestions;
    public question nextQuestion;
    public int cF;
    public int cO;
    public int dROP;
    public int iMP;
    public int mE;
    public int pL;
    public Vectorquestion questions;
    public int rI;
    public int sH;
    public int sP;
    public int tW;
    public double cost;
    public boolean isUsed;
    public boolean firstRun;
    public testType type;
    public boolean typeSpecified;
    public String productName;
    public String description;
    public int complete;
    public String expirationDate;
    public String finishedDate;
    public String owner;
    public testType testType;
    public boolean testTypeSpecified;
    
    public belbin(){}
    
    public belbin(SoapObject soapObject)
    {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("totalQuestions"))
        {
            Object obj = soapObject.getProperty("totalQuestions");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                totalQuestions = Integer.parseInt(j.toString());
            }else if (obj!= null && obj instanceof Number){
                totalQuestions = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("nextQuestion"))
        {
            SoapObject j = (SoapObject)soapObject.getProperty("nextQuestion");
            nextQuestion =  new question (j);
            
        }
        if (soapObject.hasProperty("CF"))
        {
            Object obj = soapObject.getProperty("CF");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                cF = Integer.parseInt(j.toString());
            }else if (obj!= null && obj instanceof Number){
                cF = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("CO"))
        {
            Object obj = soapObject.getProperty("CO");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                cO = Integer.parseInt(j.toString());
            }else if (obj!= null && obj instanceof Number){
                cO = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("DROP"))
        {
            Object obj = soapObject.getProperty("DROP");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                dROP = Integer.parseInt(j.toString());
            }else if (obj!= null && obj instanceof Number){
                dROP = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("IMP"))
        {
            Object obj = soapObject.getProperty("IMP");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                iMP = Integer.parseInt(j.toString());
            }else if (obj!= null && obj instanceof Number){
                iMP = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("ME"))
        {
            Object obj = soapObject.getProperty("ME");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                mE = Integer.parseInt(j.toString());
            }else if (obj!= null && obj instanceof Number){
                mE = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("PL"))
        {
            Object obj = soapObject.getProperty("PL");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                pL = Integer.parseInt(j.toString());
            }else if (obj!= null && obj instanceof Number){
                pL = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("questions"))
        {
            SoapObject j = (SoapObject)soapObject.getProperty("questions");
            questions = new Vectorquestion(j);
        }
        if (soapObject.hasProperty("RI"))
        {
            Object obj = soapObject.getProperty("RI");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                rI = Integer.parseInt(j.toString());
            }else if (obj!= null && obj instanceof Number){
                rI = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("SH"))
        {
            Object obj = soapObject.getProperty("SH");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                sH = Integer.parseInt(j.toString());
            }else if (obj!= null && obj instanceof Number){
                sH = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("SP"))
        {
            Object obj = soapObject.getProperty("SP");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                sP = Integer.parseInt(j.toString());
            }else if (obj!= null && obj instanceof Number){
                sP = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("TW"))
        {
            Object obj = soapObject.getProperty("TW");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                tW = Integer.parseInt(j.toString());
            }else if (obj!= null && obj instanceof Number){
                tW = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("cost"))
        {
            Object obj = soapObject.getProperty("cost");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                cost = Double.parseDouble(j.toString());
            }else if (obj!= null && obj instanceof Number){
                cost = (Double) obj;
            }
        }
        if (soapObject.hasProperty("isUsed"))
        {
            Object obj = soapObject.getProperty("isUsed");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                isUsed = Boolean.parseBoolean(j.toString());
            }else if (obj!= null && obj instanceof Boolean){
                isUsed = (Boolean) obj;
            }
        }
        if (soapObject.hasProperty("firstRun"))
        {
            Object obj = soapObject.getProperty("firstRun");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                firstRun = Boolean.parseBoolean(j.toString());
            }else if (obj!= null && obj instanceof Boolean){
                firstRun = (Boolean) obj;
            }
        }
        if (soapObject.hasProperty("type"))
        {
            Object obj = soapObject.getProperty("type");
            if (obj!= null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive)obj;
                type = testType.fromString(j.toString());
            }
        }
        if (soapObject.hasProperty("typeSpecified"))
        {
            Object obj = soapObject.getProperty("typeSpecified");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                typeSpecified = Boolean.parseBoolean(j.toString());
            }else if (obj!= null && obj instanceof Boolean){
                typeSpecified = (Boolean) obj;
            }
        }
        if (soapObject.hasProperty("productName"))
        {
            Object obj = soapObject.getProperty("productName");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                productName = j.toString();
            }else if (obj!= null && obj instanceof String){
                productName = (String) obj;
            }
        }
        if (soapObject.hasProperty("description"))
        {
            Object obj = soapObject.getProperty("description");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                description = j.toString();
            }else if (obj!= null && obj instanceof String){
                description = (String) obj;
            }
        }
        if (soapObject.hasProperty("Complete"))
        {
            Object obj = soapObject.getProperty("Complete");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                complete = Integer.parseInt(j.toString());
            }else if (obj!= null && obj instanceof Number){
                complete = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("expirationDate"))
        {
            Object obj = soapObject.getProperty("expirationDate");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                expirationDate = j.toString();
            }else if (obj!= null && obj instanceof String){
                expirationDate = (String) obj;
            }
        }
        if (soapObject.hasProperty("finishedDate"))
        {
            Object obj = soapObject.getProperty("finishedDate");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                finishedDate = j.toString();
            }else if (obj!= null && obj instanceof String){
                finishedDate = (String) obj;
            }
        }
        if (soapObject.hasProperty("owner"))
        {
            Object obj = soapObject.getProperty("owner");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                owner = j.toString();
            }else if (obj!= null && obj instanceof String){
                owner = (String) obj;
            }
        }
        if (soapObject.hasProperty("testType"))
        {
            Object obj = soapObject.getProperty("testType");
            if (obj!= null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive)obj;
                testType = testType.fromString(j.toString());
            }
        }
        if (soapObject.hasProperty("testTypeSpecified"))
        {
            Object obj = soapObject.getProperty("testTypeSpecified");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                testTypeSpecified = Boolean.parseBoolean(j.toString());
            }else if (obj!= null && obj instanceof Boolean){
                testTypeSpecified = (Boolean) obj;
            }
        }
    }
    @Override
    public Object getProperty(int arg0) {
        switch(arg0){
            case 0:
                return totalQuestions;
            case 1:
                return nextQuestion;
            case 2:
                return cF;
            case 3:
                return cO;
            case 4:
                return dROP;
            case 5:
                return iMP;
            case 6:
                return mE;
            case 7:
                return pL;
            case 8:
                return questions;
            case 9:
                return rI;
            case 10:
                return sH;
            case 11:
                return sP;
            case 12:
                return tW;
            case 13:
                return cost;
            case 14:
                return isUsed;
            case 15:
                return firstRun;
            case 16:
                return type.toString();
            case 17:
                return typeSpecified;
            case 18:
                return productName;
            case 19:
                return description;
            case 20:
                return complete;
            case 21:
                return expirationDate;
            case 22:
                return finishedDate;
            case 23:
                return owner;
            case 24:
                return testType.toString();
            case 25:
                return testTypeSpecified;
        }
        return null;
    }
    
    @Override
    public int getPropertyCount() {
        return 26;
    }
    
    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        switch(index){
            case 0:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "totalQuestions";
                break;
            case 1:
                info.type = question.class;
                info.name = "nextQuestion";
                break;
            case 2:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "CF";
                break;
            case 3:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "CO";
                break;
            case 4:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "DROP";
                break;
            case 5:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "IMP";
                break;
            case 6:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "ME";
                break;
            case 7:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "PL";
                break;
            case 8:
                info.type = PropertyInfo.VECTOR_CLASS;
                info.name = "questions";
                break;
            case 9:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "RI";
                break;
            case 10:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "SH";
                break;
            case 11:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "SP";
                break;
            case 12:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "TW";
                break;
            case 13:
                info.type = Double.class;
                info.name = "cost";
                break;
            case 14:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "isUsed";
                break;
            case 15:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "firstRun";
                break;
            case 16:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "type";
                break;
            case 17:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "typeSpecified";
                break;
            case 18:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "productName";
                break;
            case 19:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "description";
                break;
            case 20:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "Complete";
                break;
            case 21:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "expirationDate";
                break;
            case 22:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "finishedDate";
                break;
            case 23:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "owner";
                break;
            case 24:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "testType";
                break;
            case 25:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "testTypeSpecified";
                break;
        }
    }
    

    public String getInnerText() {
        return null;
    }
    
    

    public void setInnerText(String s) {
    }
    
    
    @Override
    public void setProperty(int arg0, Object arg1) {
    }
    
}
