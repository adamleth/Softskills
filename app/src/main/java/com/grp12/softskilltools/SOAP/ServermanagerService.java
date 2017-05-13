package com.grp12.softskilltools.SOAP;


import android.os.AsyncTask;

import com.grp12.softskilltools.SOAP.WS_Enums.*;

import org.ksoap2.HeaderProperty;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.MarshalFloat;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.List;

public class ServermanagerService {
    
    public String NAMESPACE ="http://Service/";
    public String url="";
    public int timeOut = 1800;
    public IWsdl2CodeEvents eventHandler;
    public SoapProtocolVersion soapVersion;
    
    public ServermanagerService(){}
    
    public ServermanagerService(IWsdl2CodeEvents eventHandler)
    {
        this.eventHandler = eventHandler;
    }
    public ServermanagerService(IWsdl2CodeEvents eventHandler,String url)
    {
        this.eventHandler = eventHandler;
        this.url = url;
    }
    public ServermanagerService(IWsdl2CodeEvents eventHandler,String url,int timeOutInSeconds)
    {
        this.eventHandler = eventHandler;
        this.url = url;
        this.setTimeOut(timeOutInSeconds);
    }
    public void setTimeOut(int seconds){
        this.timeOut = seconds * 1000;
    }
    public void setUrl(String url){
        this.url = url;
    }
    public void setNotifikationerAsync(boolean arg0) throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        setNotifikationerAsync(arg0, null);
    }
    
    public void setNotifikationerAsync(final boolean arg0,final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected Void doInBackground(Void... params) {
                setNotifikationer(arg0, headers);
                return null;
            }
            @Override
            protected void onPostExecute(Void result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("setNotifikationer", result);
                }
            }
        }.execute();
    }
    
    public void setNotifikationer(boolean arg0){
        setNotifikationer(arg0, null);
    }
    
    public void setNotifikationer(boolean arg0,List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://Service/","setNotifikationer");
        soapReq.addProperty("arg0",arg0);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://Service/ServerI/setNotifikationerRequest", soapEnvelope,headers);
            }else{
                httpTransport.call("http://Service/ServerI/setNotifikationerRequest", soapEnvelope);
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
    }
    
    public void setInverterAsync(boolean arg0) throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        setInverterAsync(arg0, null);
    }
    
    public void setInverterAsync(final boolean arg0,final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected Void doInBackground(Void... params) {
                setInverter(arg0, headers);
                return null;
            }
            @Override
            protected void onPostExecute(Void result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("setInverter", result);
                }
            }
        }.execute();
    }
    
    public void setInverter(boolean arg0){
        setInverter(arg0, null);
    }
    
    public void setInverter(boolean arg0,List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://Service/","setInverter");
        soapReq.addProperty("arg0",arg0);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://Service/ServerI/setInverterRequest", soapEnvelope,headers);
            }else{
                httpTransport.call("http://Service/ServerI/setInverterRequest", soapEnvelope);
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
    }
    
    public void getNameAsync() throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        getNameAsync(null);
    }
    
    public void getNameAsync(final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, String>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected String doInBackground(Void... params) {
                return getName(headers);
            }
            @Override
            protected void onPostExecute(String result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("getName", result);
                }
            }
        }.execute();
    }
    
    public String getName(){
        return getName(null);
    }
    
    public String getName(List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://Service/","getName");
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://Service/ServerI/getNameRequest", soapEnvelope,headers);
            }else{
                httpTransport.call("http://Service/ServerI/getNameRequest", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                        SoapPrimitive j =(SoapPrimitive) obj;
                        String resultVariable = j.toString();
                        return resultVariable;
                    }else if (obj!= null && obj instanceof String){
                        String resultVariable = (String) obj;
                        return resultVariable;
                    }
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return "";
    }
    
    public void setNameAsync(String arg0,String arg1) throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        setNameAsync(arg0, arg1, null);
    }
    
    public void setNameAsync(final String arg0,final String arg1,final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected Void doInBackground(Void... params) {
                setName(arg0, arg1, headers);
                return null;
            }
            @Override
            protected void onPostExecute(Void result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("setName", result);
                }
            }
        }.execute();
    }
    
    public void setName(String arg0,String arg1){
        setName(arg0, arg1, null);
    }
    
    public void setName(String arg0,String arg1,List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://Service/","setName");
        soapReq.addProperty("arg0",arg0);
        soapReq.addProperty("arg1",arg1);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://Service/ServerI/setNameRequest", soapEnvelope,headers);
            }else{
                httpTransport.call("http://Service/ServerI/setNameRequest", soapEnvelope);
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
    }
    
    public void addProductToUserAsync(abstractItem arg0,user arg1,int arg2) throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        addProductToUserAsync(arg0, arg1, arg2, null);
    }
    
    public void addProductToUserAsync(final abstractItem arg0,final user arg1,final int arg2,final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected Void doInBackground(Void... params) {
                addProductToUser(arg0, arg1, arg2, headers);
                return null;
            }
            @Override
            protected void onPostExecute(Void result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("addProductToUser", result);
                }
            }
        }.execute();
    }
    
    public void addProductToUser(abstractItem arg0,user arg1,int arg2){
        addProductToUser(arg0, arg1, arg2, null);
    }
    
    public void addProductToUser(abstractItem arg0,user arg1,int arg2,List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://Service/","addProductToUser");
        soapEnvelope.addMapping("http://Service/","arg0",new abstractItem().getClass());
        MarshalFloat marshalFloat = new MarshalFloat();
        marshalFloat.register(soapEnvelope);
        soapEnvelope.addMapping("http://Service/","arg1",new user().getClass());
        soapReq.addProperty("arg0",arg0);
        soapReq.addProperty("arg1",arg1);
        soapReq.addProperty("arg2",arg2);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://Service/ServerI/addProductToUserRequest", soapEnvelope,headers);
            }else{
                httpTransport.call("http://Service/ServerI/addProductToUserRequest", soapEnvelope);
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
    }
    
    public void addToResultsAsync(user arg0,abstractItem arg1) throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        addToResultsAsync(arg0, arg1, null);
    }
    
    public void addToResultsAsync(final user arg0,final abstractItem arg1,final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected Void doInBackground(Void... params) {
                addToResults(arg0, arg1, headers);
                return null;
            }
            @Override
            protected void onPostExecute(Void result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("addToResults", result);
                }
            }
        }.execute();
    }
    
    public void addToResults(user arg0,abstractItem arg1){
        addToResults(arg0, arg1, null);
    }
    
    public void addToResults(user arg0,abstractItem arg1,List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://Service/","addToResults");
        soapEnvelope.addMapping("http://Service/","arg0",new user().getClass());
        soapEnvelope.addMapping("http://Service/","arg1",new abstractItem().getClass());
        MarshalFloat marshalFloat = new MarshalFloat();
        marshalFloat.register(soapEnvelope);
        soapReq.addProperty("arg0",arg0);
        soapReq.addProperty("arg1",arg1);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://Service/ServerI/addToResultsRequest", soapEnvelope,headers);
            }else{
                httpTransport.call("http://Service/ServerI/addToResultsRequest", soapEnvelope);
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
    }
    
    public void getSurNameAsync() throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        getSurNameAsync(null);
    }
    
    public void getSurNameAsync(final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, String>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected String doInBackground(Void... params) {
                return getSurName(headers);
            }
            @Override
            protected void onPostExecute(String result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("getSurName", result);
                }
            }
        }.execute();
    }
    
    public String getSurName(){
        return getSurName(null);
    }
    
    public String getSurName(List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://Service/","getSurName");
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://Service/ServerI/getSurNameRequest", soapEnvelope,headers);
            }else{
                httpTransport.call("http://Service/ServerI/getSurNameRequest", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                        SoapPrimitive j =(SoapPrimitive) obj;
                        String resultVariable = j.toString();
                        return resultVariable;
                    }else if (obj!= null && obj instanceof String){
                        String resultVariable = (String) obj;
                        return resultVariable;
                    }
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return "";
    }
    
    public void setEmailAsync(String arg0) throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        setEmailAsync(arg0, null);
    }
    
    public void setEmailAsync(final String arg0,final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected Void doInBackground(Void... params) {
                setEmail(arg0, headers);
                return null;
            }
            @Override
            protected void onPostExecute(Void result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("setEmail", result);
                }
            }
        }.execute();
    }
    
    public void setEmail(String arg0){
        setEmail(arg0, null);
    }
    
    public void setEmail(String arg0,List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://Service/","setEmail");
        soapReq.addProperty("arg0",arg0);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://Service/ServerI/setEmailRequest", soapEnvelope,headers);
            }else{
                httpTransport.call("http://Service/ServerI/setEmailRequest", soapEnvelope);
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
    }
    
    public void getEmailAsync() throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        getEmailAsync(null);
    }
    
    public void getEmailAsync(final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, String>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected String doInBackground(Void... params) {
                return getEmail(headers);
            }
            @Override
            protected void onPostExecute(String result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("getEmail", result);
                }
            }
        }.execute();
    }
    
    public String getEmail(){
        return getEmail(null);
    }
    
    public String getEmail(List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://Service/","getEmail");
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://Service/ServerI/getEmailRequest", soapEnvelope,headers);
            }else{
                httpTransport.call("http://Service/ServerI/getEmailRequest", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                        SoapPrimitive j =(SoapPrimitive) obj;
                        String resultVariable = j.toString();
                        return resultVariable;
                    }else if (obj!= null && obj instanceof String){
                        String resultVariable = (String) obj;
                        return resultVariable;
                    }
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return "";
    }
    
    public void setRetningAsync(String arg0) throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        setRetningAsync(arg0, null);
    }
    
    public void setRetningAsync(final String arg0,final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected Void doInBackground(Void... params) {
                setRetning(arg0, headers);
                return null;
            }
            @Override
            protected void onPostExecute(Void result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("setRetning", result);
                }
            }
        }.execute();
    }
    
    public void setRetning(String arg0){
        setRetning(arg0, null);
    }
    
    public void setRetning(String arg0,List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://Service/","setRetning");
        soapReq.addProperty("arg0",arg0);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://Service/ServerI/setRetningRequest", soapEnvelope,headers);
            }else{
                httpTransport.call("http://Service/ServerI/setRetningRequest", soapEnvelope);
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
    }
    
    public void getRetningAsync() throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        getRetningAsync(null);
    }
    
    public void getRetningAsync(final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, String>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected String doInBackground(Void... params) {
                return getRetning(headers);
            }
            @Override
            protected void onPostExecute(String result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("getRetning", result);
                }
            }
        }.execute();
    }
    
    public String getRetning(){
        return getRetning(null);
    }
    
    public String getRetning(List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://Service/","getRetning");
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://Service/ServerI/getRetningRequest", soapEnvelope,headers);
            }else{
                httpTransport.call("http://Service/ServerI/getRetningRequest", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                        SoapPrimitive j =(SoapPrimitive) obj;
                        String resultVariable = j.toString();
                        return resultVariable;
                    }else if (obj!= null && obj instanceof String){
                        String resultVariable = (String) obj;
                        return resultVariable;
                    }
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return "";
    }
    
    public void retrieveSafeObjectsAsync() throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        retrieveSafeObjectsAsync(null);
    }
    
    public void retrieveSafeObjectsAsync(final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, VectorabstractItem>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected VectorabstractItem doInBackground(Void... params) {
                return retrieveSafeObjects(headers);
            }
            @Override
            protected void onPostExecute(VectorabstractItem result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("retrieveSafeObjects", result);
                }
            }
        }.execute();
    }
    
    public VectorabstractItem retrieveSafeObjects(){
        return retrieveSafeObjects(null);
    }
    
    public VectorabstractItem retrieveSafeObjects(List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://Service/","retrieveSafeObjects");
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://Service/ServerI/retrieveSafeObjectsRequest", soapEnvelope,headers);
            }else{
                httpTransport.call("http://Service/ServerI/retrieveSafeObjectsRequest", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    SoapObject j = (SoapObject)obj;
                    VectorabstractItem resultVariable = new VectorabstractItem(j);
                    return resultVariable;
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return null;
    }
    
    public void getSafeAsync() throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        getSafeAsync(null);
    }
    
    public void getSafeAsync(final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, safe>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected safe doInBackground(Void... params) {
                return getSafe(headers);
            }
            @Override
            protected void onPostExecute(safe result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("getSafe", result);
                }
            }
        }.execute();
    }
    
    public safe getSafe(){
        return getSafe(null);
    }
    
    public safe getSafe(List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://Service/","getSafe");
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://Service/ServerI/getSafeRequest", soapEnvelope,headers);
            }else{
                httpTransport.call("http://Service/ServerI/getSafeRequest", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    SoapObject j = (SoapObject)obj;
                    safe resultVariable =  new safe (j);
                    return resultVariable;
                    
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return null;
    }
    
    public void getSafeSizeAsync() throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        getSafeSizeAsync(null);
    }
    
    public void getSafeSizeAsync(final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, String>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected String doInBackground(Void... params) {
                return getSafeSize(headers);
            }
            @Override
            protected void onPostExecute(String result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("getSafeSize", result);
                }
            }
        }.execute();
    }
    
    public String getSafeSize(){
        return getSafeSize(null);
    }
    
    public String getSafeSize(List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://Service/","getSafeSize");
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://Service/ServerI/getSafeSizeRequest", soapEnvelope,headers);
            }else{
                httpTransport.call("http://Service/ServerI/getSafeSizeRequest", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                        SoapPrimitive j =(SoapPrimitive) obj;
                        String resultVariable = j.toString();
                        return resultVariable;
                    }else if (obj!= null && obj instanceof String){
                        String resultVariable = (String) obj;
                        return resultVariable;
                    }
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return "";
    }
    
    public void setSafeAsync(safe arg0) throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        setSafeAsync(arg0, null);
    }
    
    public void setSafeAsync(final safe arg0,final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected Void doInBackground(Void... params) {
                setSafe(arg0, headers);
                return null;
            }
            @Override
            protected void onPostExecute(Void result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("setSafe", result);
                }
            }
        }.execute();
    }
    
    public void setSafe(safe arg0){
        setSafe(arg0, null);
    }
    
    public void setSafe(safe arg0,List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://Service/","setSafe");
        soapEnvelope.addMapping("http://Service/","arg0",new safe().getClass());
        soapReq.addProperty("arg0",arg0);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://Service/ServerI/setSafeRequest", soapEnvelope,headers);
            }else{
                httpTransport.call("http://Service/ServerI/setSafeRequest", soapEnvelope);
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
    }
    
    public void setfullNameAsync() throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        setfullNameAsync(null);
    }
    
    public void setfullNameAsync(final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected Void doInBackground(Void... params) {
                setfullName(headers);
                return null;
            }
            @Override
            protected void onPostExecute(Void result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("setfullName", result);
                }
            }
        }.execute();
    }
    
    public void setfullName(){
        setfullName(null);
    }
    
    public void setfullName(List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://Service/","setfullName");
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://Service/ServerI/setfullNameRequest", soapEnvelope,headers);
            }else{
                httpTransport.call("http://Service/ServerI/setfullNameRequest", soapEnvelope);
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
    }
    
    public void hentResultsAsync() throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        hentResultsAsync(null);
    }
    
    public void hentResultsAsync(final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, VectorabstractItem>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected VectorabstractItem doInBackground(Void... params) {
                return hentResults(headers);
            }
            @Override
            protected void onPostExecute(VectorabstractItem result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("hentResults", result);
                }
            }
        }.execute();
    }
    
    public VectorabstractItem hentResults(){
        return hentResults(null);
    }
    
    public VectorabstractItem hentResults(List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://Service/","hentResults");
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://Service/ServerI/hentResultsRequest", soapEnvelope,headers);
            }else{
                httpTransport.call("http://Service/ServerI/hentResultsRequest", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    SoapObject j = (SoapObject)obj;
                    VectorabstractItem resultVariable = new VectorabstractItem(j);
                    return resultVariable;
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return null;
    }
    
    public void getFullNameAsync() throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        getFullNameAsync(null);
    }
    
    public void getFullNameAsync(final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, String>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected String doInBackground(Void... params) {
                return getFullName(headers);
            }
            @Override
            protected void onPostExecute(String result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("getFullName", result);
                }
            }
        }.execute();
    }
    
    public String getFullName(){
        return getFullName(null);
    }
    
    public String getFullName(List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://Service/","getFullName");
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://Service/ServerI/getFullNameRequest", soapEnvelope,headers);
            }else{
                httpTransport.call("http://Service/ServerI/getFullNameRequest", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                        SoapPrimitive j =(SoapPrimitive) obj;
                        String resultVariable = j.toString();
                        return resultVariable;
                    }else if (obj!= null && obj instanceof String){
                        String resultVariable = (String) obj;
                        return resultVariable;
                    }
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return "";
    }
    
    public void addToSafeAsync(abstractItem arg0,int arg1) throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        addToSafeAsync(arg0, arg1, null);
    }
    
    public void addToSafeAsync(final abstractItem arg0,final int arg1,final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected Void doInBackground(Void... params) {
                addToSafe(arg0, arg1, headers);
                return null;
            }
            @Override
            protected void onPostExecute(Void result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("addToSafe", result);
                }
            }
        }.execute();
    }
    
    public void addToSafe(abstractItem arg0,int arg1){
        addToSafe(arg0, arg1, null);
    }
    
    public void addToSafe(abstractItem arg0,int arg1,List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://Service/","addToSafe");
        soapEnvelope.addMapping("http://Service/","arg0",new abstractItem().getClass());
        MarshalFloat marshalFloat = new MarshalFloat();
        marshalFloat.register(soapEnvelope);
        soapReq.addProperty("arg0",arg0);
        soapReq.addProperty("arg1",arg1);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://Service/ServerI/addToSafeRequest", soapEnvelope,headers);
            }else{
                httpTransport.call("http://Service/ServerI/addToSafeRequest", soapEnvelope);
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
    }
    
    public void setFirstRunAsync(boolean arg0,boolean arg0Specified) throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        setFirstRunAsync(arg0, arg0Specified, null);
    }
    
    public void setFirstRunAsync(final boolean arg0,final boolean arg0Specified,final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected Void doInBackground(Void... params) {
                setFirstRun(arg0, arg0Specified, headers);
                return null;
            }
            @Override
            protected void onPostExecute(Void result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("setFirstRun", result);
                }
            }
        }.execute();
    }
    
    public void setFirstRun(boolean arg0,boolean arg0Specified){
        setFirstRun(arg0, arg0Specified, null);
    }
    
    public void setFirstRun(boolean arg0,boolean arg0Specified,List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://Service/","setFirstRun");
        soapReq.addProperty("arg0",arg0);
        soapReq.addProperty("arg0Specified",arg0Specified);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://Service/ServerI/setFirstRunRequest", soapEnvelope,headers);
            }else{
                httpTransport.call("http://Service/ServerI/setFirstRunRequest", soapEnvelope);
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
    }
    
    public void getFirstRunAsync() throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        getFirstRunAsync(null);
    }
    
    public void getFirstRunAsync(final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, Boolean>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected Boolean doInBackground(Void... params) {
                return getFirstRun(headers);
            }
            @Override
            protected void onPostExecute(Boolean result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("getFirstRun", result);
                }
            }
        }.execute();
    }
    
    public boolean getFirstRun(){
        return getFirstRun(null);
    }
    
    public boolean getFirstRun(List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://Service/","getFirstRun");
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://Service/ServerI/getFirstRunRequest", soapEnvelope,headers);
            }else{
                httpTransport.call("http://Service/ServerI/getFirstRunRequest", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                        SoapPrimitive j =(SoapPrimitive) obj;
                        boolean resultVariable = Boolean.parseBoolean(j.toString());
                        return resultVariable;
                    }else if (obj!= null && obj instanceof Boolean){
                        boolean resultVariable = (Boolean) obj;
                        return resultVariable;
                    }
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return false;
    }
    
    public void getAdministrativAsync() throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        getAdministrativAsync(null);
    }
    
    public void getAdministrativAsync(final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, Boolean>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected Boolean doInBackground(Void... params) {
                return getAdministrativ(headers);
            }
            @Override
            protected void onPostExecute(Boolean result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("getAdministrativ", result);
                }
            }
        }.execute();
    }
    
    public boolean getAdministrativ(){
        return getAdministrativ(null);
    }
    
    public boolean getAdministrativ(List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://Service/","getAdministrativ");
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://Service/ServerI/getAdministrativRequest", soapEnvelope,headers);
            }else{
                httpTransport.call("http://Service/ServerI/getAdministrativRequest", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                        SoapPrimitive j =(SoapPrimitive) obj;
                        boolean resultVariable = Boolean.parseBoolean(j.toString());
                        return resultVariable;
                    }else if (obj!= null && obj instanceof Boolean){
                        boolean resultVariable = (Boolean) obj;
                        return resultVariable;
                    }
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return false;
    }
    
    public void getNotifikationerAsync() throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        getNotifikationerAsync(null);
    }
    
    public void getNotifikationerAsync(final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, Boolean>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected Boolean doInBackground(Void... params) {
                return getNotifikationer(headers);
            }
            @Override
            protected void onPostExecute(Boolean result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("getNotifikationer", result);
                }
            }
        }.execute();
    }
    
    public boolean getNotifikationer(){
        return getNotifikationer(null);
    }
    
    public boolean getNotifikationer(List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://Service/","getNotifikationer");
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://Service/ServerI/getNotifikationerRequest", soapEnvelope,headers);
            }else{
                httpTransport.call("http://Service/ServerI/getNotifikationerRequest", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                        SoapPrimitive j =(SoapPrimitive) obj;
                        boolean resultVariable = Boolean.parseBoolean(j.toString());
                        return resultVariable;
                    }else if (obj!= null && obj instanceof Boolean){
                        boolean resultVariable = (Boolean) obj;
                        return resultVariable;
                    }
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return false;
    }
    
    public void getInverterAsync() throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        getInverterAsync(null);
    }
    
    public void getInverterAsync(final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, Boolean>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected Boolean doInBackground(Void... params) {
                return getInverter(headers);
            }
            @Override
            protected void onPostExecute(Boolean result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("getInverter", result);
                }
            }
        }.execute();
    }
    
    public boolean getInverter(){
        return getInverter(null);
    }
    
    public boolean getInverter(List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://Service/","getInverter");
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://Service/ServerI/getInverterRequest", soapEnvelope,headers);
            }else{
                httpTransport.call("http://Service/ServerI/getInverterRequest", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                        SoapPrimitive j =(SoapPrimitive) obj;
                        boolean resultVariable = Boolean.parseBoolean(j.toString());
                        return resultVariable;
                    }else if (obj!= null && obj instanceof Boolean){
                        boolean resultVariable = (Boolean) obj;
                        return resultVariable;
                    }
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return false;
    }
    
    public void setAdministrativAsync(boolean arg0) throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        setAdministrativAsync(arg0, null);
    }
    
    public void setAdministrativAsync(final boolean arg0,final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected Void doInBackground(Void... params) {
                setAdministrativ(arg0, headers);
                return null;
            }
            @Override
            protected void onPostExecute(Void result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("setAdministrativ", result);
                }
            }
        }.execute();
    }
    
    public void setAdministrativ(boolean arg0){
        setAdministrativ(arg0, null);
    }
    
    public void setAdministrativ(boolean arg0,List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://Service/","setAdministrativ");
        soapReq.addProperty("arg0",arg0);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://Service/ServerI/setAdministrativRequest", soapEnvelope,headers);
            }else{
                httpTransport.call("http://Service/ServerI/setAdministrativRequest", soapEnvelope);
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
    }
    
    public void CheckConnectionAsync() throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        CheckConnectionAsync(null);
    }
    
    public void CheckConnectionAsync(final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, String>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected String doInBackground(Void... params) {
                return CheckConnection(headers);
            }
            @Override
            protected void onPostExecute(String result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("CheckConnection", result);
                }
            }
        }.execute();
    }
    
    public String CheckConnection(){
        return CheckConnection(null);
    }
    
    public String CheckConnection(List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://Service/","CheckConnection");
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://Service/ServerI/CheckConnectionRequest", soapEnvelope,headers);
            }else{
                httpTransport.call("http://Service/ServerI/CheckConnectionRequest", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                        SoapPrimitive j =(SoapPrimitive) obj;
                        String resultVariable = j.toString();
                        return resultVariable;
                    }else if (obj!= null && obj instanceof String){
                        String resultVariable = (String) obj;
                        return resultVariable;
                    }
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return "";
    }
    
    public void loginAsync(String arg0,String arg1) throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        loginAsync(arg0, arg1, null);
    }
    
    public void loginAsync(final String arg0,final String arg1,final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, Boolean>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected Boolean doInBackground(Void... params) {
                return login(arg0, arg1, headers);
            }
            @Override
            protected void onPostExecute(Boolean result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("login", result);
                }
            }
        }.execute();
    }
    
    public boolean login(String arg0,String arg1){
        return login(arg0, arg1, null);
    }
    
    public boolean login(String arg0,String arg1,List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://Service/","login");
        soapReq.addProperty("arg0",arg0);
        soapReq.addProperty("arg1",arg1);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://Service/ServerI/loginRequest", soapEnvelope,headers);
            }else{
                httpTransport.call("http://Service/ServerI/loginRequest", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                        SoapPrimitive j =(SoapPrimitive) obj;
                        boolean resultVariable = Boolean.parseBoolean(j.toString());
                        return resultVariable;
                    }else if (obj!= null && obj instanceof Boolean){
                        boolean resultVariable = (Boolean) obj;
                        return resultVariable;
                    }
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return false;
    }
    
    public void createGroupAsync(String arg0,Vectoruser arg1,int arg2) throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        createGroupAsync(arg0, arg1, arg2, null);
    }
    
    public void createGroupAsync(final String arg0,final Vectoruser arg1,final int arg2,final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected Void doInBackground(Void... params) {
                createGroup(arg0, arg1, arg2, headers);
                return null;
            }
            @Override
            protected void onPostExecute(Void result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("createGroup", result);
                }
            }
        }.execute();
    }
    
    public void createGroup(String arg0,Vectoruser arg1,int arg2){
        createGroup(arg0, arg1, arg2, null);
    }
    
    public void createGroup(String arg0,Vectoruser arg1,int arg2,List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://Service/","createGroup");
        soapReq.addProperty("arg0",arg0);
        soapReq.addProperty("arg1",arg1);
        soapReq.addProperty("arg2",arg2);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://Service/ServerI/createGroupRequest", soapEnvelope,headers);
            }else{
                httpTransport.call("http://Service/ServerI/createGroupRequest", soapEnvelope);
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
    }
    
    public void getGroupAsync(String arg0) throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        getGroupAsync(arg0, null);
    }
    
    public void getGroupAsync(final String arg0,final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, group>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected group doInBackground(Void... params) {
                return getGroup(arg0, headers);
            }
            @Override
            protected void onPostExecute(group result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("getGroup", result);
                }
            }
        }.execute();
    }
    
    public group getGroup(String arg0){
        return getGroup(arg0, null);
    }
    
    public group getGroup(String arg0,List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://Service/","getGroup");
        soapReq.addProperty("arg0",arg0);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://Service/ServerI/getGroupRequest", soapEnvelope,headers);
            }else{
                httpTransport.call("http://Service/ServerI/getGroupRequest", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    SoapObject j = (SoapObject)obj;
                    group resultVariable =  new group (j);
                    return resultVariable;
                    
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return null;
    }
    
    public void deleteGroupAsync(String arg0) throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        deleteGroupAsync(arg0, null);
    }
    
    public void deleteGroupAsync(final String arg0,final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, Boolean>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected Boolean doInBackground(Void... params) {
                return deleteGroup(arg0, headers);
            }
            @Override
            protected void onPostExecute(Boolean result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("deleteGroup", result);
                }
            }
        }.execute();
    }
    
    public boolean deleteGroup(String arg0){
        return deleteGroup(arg0, null);
    }
    
    public boolean deleteGroup(String arg0,List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://Service/","deleteGroup");
        soapReq.addProperty("arg0",arg0);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://Service/ServerI/deleteGroupRequest", soapEnvelope,headers);
            }else{
                httpTransport.call("http://Service/ServerI/deleteGroupRequest", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                        SoapPrimitive j =(SoapPrimitive) obj;
                        boolean resultVariable = Boolean.parseBoolean(j.toString());
                        return resultVariable;
                    }else if (obj!= null && obj instanceof Boolean){
                        boolean resultVariable = (Boolean) obj;
                        return resultVariable;
                    }
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return false;
    }
    
    public void getAllUsersAsync() throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        getAllUsersAsync(null);
    }
    
    public void getAllUsersAsync(final List<HeaderProperty> headers) throws Exception{
        
        new AsyncTask<Void, Void, Vectoruser>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            };
            @Override
            protected Vectoruser doInBackground(Void... params) {
                return getAllUsers(headers);
            }
            @Override
            protected void onPostExecute(Vectoruser result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("getAllUsers", result);
                }
            }
        }.execute();
    }
    
    public Vectoruser getAllUsers(){
        return getAllUsers(null);
    }
    
    public Vectoruser getAllUsers(List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://Service/","getAllUsers");
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://Service/ServerI/getAllUsersRequest", soapEnvelope,headers);
            }else{
                httpTransport.call("http://Service/ServerI/getAllUsersRequest", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    SoapObject j = (SoapObject)obj;
                    Vectoruser resultVariable = new Vectoruser(j);
                    return resultVariable;
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return null;
    }
    
}
