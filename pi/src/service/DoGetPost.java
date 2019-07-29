package service;

import java.io.IOException;
import java.util.Map;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import bean.AdminInfo;
import bean.StudentInfo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DoGetPost {

	/**
     * 编写Get请求的方法。
     * 
     * @param url 需要请求的URL
     * @return 将请求URL后返回的数据，转为JSON格式，并return
     */
    public static JSONObject doGetStr(String url) throws ClientProtocolException, IOException {
        DefaultHttpClient client = new DefaultHttpClient();//获取DefaultHttpClient请求
        HttpGet httpGet = new HttpGet(url);//HttpGet将使用Get方式发送请求URL
        JSONObject jsonObject = null;
        HttpResponse response = client.execute(httpGet);//使用HttpResponse接收client执行httpGet的结果
        HttpEntity entity = response.getEntity();//从response中获取结果，类型为HttpEntity
        if(entity != null){
            String result = EntityUtils.toString(entity,"UTF-8");//HttpEntity转为字符串类型
            jsonObject = JSONObject.fromObject(result);//字符串类型转为JSON类型
        }
        return jsonObject;
    }

	/**
	 * 编写Post请求的方法。
	 * 
	 * @param url
	 *            需要请求的URL
	 * @param outStr
	 *            需要传递的参数
	 * @return 将请求URL后返回的数据，转为JSON格式，并return
	 */
	public static JSONObject doPostStr(String url, String outStr) throws ClientProtocolException, IOException {
		DefaultHttpClient client = new DefaultHttpClient();// 获取DefaultHttpClient请求
		HttpPost httpost = new HttpPost(url);// HttpPost将使用post方式发送请求URL
		JSONObject jsonObject = null;
		StringEntity entity=new StringEntity(outStr, "UTF-8");
		entity.setContentType("application/x-www-form-urlencoded");
		httpost.setEntity(entity);// 使用setEntity方法，将我们传进来的参数放入请求中
		System.out.println(httpost);
		HttpResponse response = client.execute(httpost);// 使用HttpResponse接收client执行httpost的结果
		String result = EntityUtils.toString(response.getEntity(), "UTF-8");// HttpEntity转为字符串类型
		jsonObject = JSONObject.fromObject(result);// 字符串类型转为JSON类型
		return jsonObject;
	}
	

	public static void main(String [] args) throws ClientProtocolException, IOException{
		 JSONObject student=doGetStr("http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/student/query/152100666");
		 Map m = student;
		 student=JSONObject.fromObject(m.get("data"));
		 m = student;
		 StudentInfo stu=(StudentInfo) JSONObject.toBean(JSONObject.fromObject(m.get("studentInfo")), StudentInfo.class);
		 System.out.println(stu.getStudentName());
		 
		 
		 JSONObject adminAll=doGetStr("http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/admin/query/all");
		 System.out.println(adminAll);
		 m=adminAll;
		 adminAll=JSONObject.fromObject(m.get("data"));
		 m = adminAll;
		 JSONArray all ;
		 all=JSONArray.fromObject(m.get("alladmins"));
		 for(int i=0;i<all.size();i++) {
			 JSONObject temp= (JSONObject) all.get(i);
			 AdminInfo ai=(AdminInfo) JSONObject.toBean(temp, AdminInfo.class);
			 System.out.println(ai.getAdminName());
		 }
	}
}