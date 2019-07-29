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
     * ��дGet����ķ�����
     * 
     * @param url ��Ҫ�����URL
     * @return ������URL�󷵻ص����ݣ�תΪJSON��ʽ����return
     */
    public static JSONObject doGetStr(String url) throws ClientProtocolException, IOException {
        DefaultHttpClient client = new DefaultHttpClient();//��ȡDefaultHttpClient����
        HttpGet httpGet = new HttpGet(url);//HttpGet��ʹ��Get��ʽ��������URL
        JSONObject jsonObject = null;
        HttpResponse response = client.execute(httpGet);//ʹ��HttpResponse����clientִ��httpGet�Ľ��
        HttpEntity entity = response.getEntity();//��response�л�ȡ���������ΪHttpEntity
        if(entity != null){
            String result = EntityUtils.toString(entity,"UTF-8");//HttpEntityתΪ�ַ�������
            jsonObject = JSONObject.fromObject(result);//�ַ�������תΪJSON����
        }
        return jsonObject;
    }

	/**
	 * ��дPost����ķ�����
	 * 
	 * @param url
	 *            ��Ҫ�����URL
	 * @param outStr
	 *            ��Ҫ���ݵĲ���
	 * @return ������URL�󷵻ص����ݣ�תΪJSON��ʽ����return
	 */
	public static JSONObject doPostStr(String url, String outStr) throws ClientProtocolException, IOException {
		DefaultHttpClient client = new DefaultHttpClient();// ��ȡDefaultHttpClient����
		HttpPost httpost = new HttpPost(url);// HttpPost��ʹ��post��ʽ��������URL
		JSONObject jsonObject = null;
		StringEntity entity=new StringEntity(outStr, "UTF-8");
		entity.setContentType("application/x-www-form-urlencoded");
		httpost.setEntity(entity);// ʹ��setEntity�����������Ǵ������Ĳ�������������
		System.out.println(httpost);
		HttpResponse response = client.execute(httpost);// ʹ��HttpResponse����clientִ��httpost�Ľ��
		String result = EntityUtils.toString(response.getEntity(), "UTF-8");// HttpEntityתΪ�ַ�������
		jsonObject = JSONObject.fromObject(result);// �ַ�������תΪJSON����
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