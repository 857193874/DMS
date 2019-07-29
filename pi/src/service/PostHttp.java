




























































































































































































































































package service;

import java.io.IOException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class PostHttp {
	public static String goPost(String url,NameValuePair [] data) {
		  // TODO Auto-generated method stub
		  HttpClient httpClient = new HttpClient();
		  PostMethod postMethod = new UTF8PostMethod(url);
		  String str = "";
		//   ������ֵ����postMethod��
		  postMethod.setRequestBody(data);
		//   ִ��postMethod
		  int statusCode = 0;
		  try {
		   statusCode = httpClient.executeMethod(postMethod);
		  } catch (HttpException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  } catch (IOException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
		//   HttpClient����Ҫ����ܺ�̷����������POST��PUT�Ȳ����Զ�����ת��
		//   301����302
		  if (statusCode == HttpStatus.SC_MOVED_PERMANENTLY || statusCode == HttpStatus.SC_MOVED_TEMPORARILY)
		  {
		   //   ��ͷ��ȡ��ת��ĵ�ַ
		   Header locationHeader = postMethod.getResponseHeader("location");
		   String location = null;
		   if (locationHeader != null) {
		    location = locationHeader.getValue();
		    System.out.println("The page was redirected to:" + location);
		   }
		   else {
		    System.err.println("Location field value is null.");
		   }
		   return "err";
		  }
		  else
		  {
		      str = postMethod.getResponseBodyAsString();         
		  }
		  postMethod.releaseConnection();
		        return str;
	}

}