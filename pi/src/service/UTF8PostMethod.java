package service;

import org.apache.commons.httpclient.methods.PostMethod;

//����PostMethod���������ñ����ʽ  
public class UTF8PostMethod extends PostMethod{       
    public UTF8PostMethod(String url){       
    super(url);       
    }       
    @Override       
    public String getRequestCharSet() {       
        //return super.getRequestCharSet();       
        return "UTF-8";       
    }    
}  