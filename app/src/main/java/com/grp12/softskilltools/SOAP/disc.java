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

public class disc implements KvmSerializable {
    
    public boolean isUsed1;
    public int totalQuestions;
    public question nextQuestion;
    public int com;
    public Vectorquestion oldQuestions;
    public Vectorquestion questions;
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
    
    public disc(){}
    
    public disc(SoapObject soapObject)
    {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("isUsed1"))
        {
            Object obj = soapObject.getProperty("isUsed1");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                isUsed1 = Boolean.parseBoolean(j.toString());
            }else if (obj!= null && obj instanceof Boolean){
                isUsed1 = (Boolean) obj;
            }
        }
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
        if (soapObject.hasProperty("com"))
        {
            Object obj = soapObject.getProperty("com");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                com = Integer.parseInt(j.toString());
            }else if (obj!= null && obj instanceof Number){
                com = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("oldQuestions"))
        {
            SoapObject j = (SoapObject)soapObject.getProperty("oldQuestions");
            oldQuestions = new Vectorquestion(j);
        }
        if (soapObject.hasProperty("questions"))
        {
            SoapObject j = (SoapObject)soapObject.getProperty("questions");
            questions = new Vectorquestion(j);
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
                return isUsed1;
            case 1:
                return totalQuestions;
            case 2:
                return nextQuestion;
            case 3:
                return com;
            case 4:
                return oldQuestions;
            case 5:
                return questions;
            case 6:
                return cost;
            case 7:
                return isUsed;
            case 8:
                return firstRun;
            case 9:
                return type.toString();
            case 10:
                return typeSpecified;
            case 11:
                return productName;
            case 12:
                return description;
            case 13:
                return complete;
            case 14:
                return expirationDate;
            case 15:
                return finishedDate;
            case 16:
                return owner;
            case 17:
                return testType.toString();
            case 18:
                return testTypeSpecified;
        }
        return null;
    }
    
    @Override
    public int getPropertyCount() {
        return 19;
    }
    
    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        switch(index){
            case 0:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "isUsed1";
                break;
            case 1:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "totalQuestions";
                break;
            case 2:
                info.type = question.class;
                info.name = "nextQuestion";
                break;
            case 3:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "com";
                break;
            case 4:
                info.type = PropertyInfo.VECTOR_CLASS;
                info.name = "oldQuestions";
                break;
            case 5:
                info.type = PropertyInfo.VECTOR_CLASS;
                info.name = "questions";
                break;
            case 6:
                info.type = Double.class;
                info.name = "cost";
                break;
            case 7:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "isUsed";
                break;
            case 8:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "firstRun";
                break;
            case 9:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "type";
                break;
            case 10:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "typeSpecified";
                break;
            case 11:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "productName";
                break;
            case 12:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "description";
                break;
            case 13:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "Complete";
                break;
            case 14:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "expirationDate";
                break;
            case 15:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "finishedDate";
                break;
            case 16:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "owner";
                break;
            case 17:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "testType";
                break;
            case 18:
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
