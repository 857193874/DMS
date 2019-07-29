package servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.NameValuePair;

import bean.AdminInfo;
import bean.Domitory;
import bean.StudentInfo;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.DoGetPost;
import service.PostHttp;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url;
		String username=request.getParameter("userName");
		String password=request.getParameter("password");
		String AorS;
		if(request.getParameter("isAdmin")!=null) {
			AorS=(String) request.getParameter("isAdmin");
		}else {
			AorS="no";
		}
		System.out.println(AorS);
		if(AorS.equals("isAdmin")){
			url="http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/admin/query/";
			JSONObject admin=DoGetPost.doGetStr(url+username);
			 Map m = admin;
			 admin=JSONObject.fromObject(m.get("data"));
			 m = admin;
			 AdminInfo adminInfo=(AdminInfo) JSONObject.toBean(JSONObject.fromObject(m.get("admin")), AdminInfo.class);
			// System.out.println(adminInfo.getAdminPassword());
			 if(adminInfo==null) {
				 System.out.println("����Ա�˺Ż��������");
			 } else if(adminInfo.getAdminPassword().equals(password)) {
				 System.out.println("����Ա��½�ɹ�");
				 request.getSession().setAttribute("loginName", adminInfo.getAdminId()+"_admin");
			 }else {
				 System.out.println("����Ա�˺Ż��������");
			 }
			 
		}
		else {
			NameValuePair[] data = { 
				    new NameValuePair("studentUsername", username),
				    new NameValuePair("studentPassword", password),
				  };
			url="http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/student/login";
		String ok=PostHttp.goPost(url, data);
		System.out.println(ok);
		JSONObject studentLogin=JSONObject.fromObject(ok);
		Map m = studentLogin;
		studentLogin=JSONObject.fromObject(m.get("data"));
		if(studentLogin.isEmpty()) {
			System.out.println("��¼ʧ��");
		}
		else {
			m=studentLogin;
			JSONArray info ;
			info=JSONArray.fromObject(m.get("student"));
			System.out.println(info);
			studentLogin=(JSONObject) info.get(0);
			StudentInfo stu=(StudentInfo) JSONObject.toBean(studentLogin, StudentInfo.class);
			
			info = JSONArray.fromObject(m.get("domitory"));
			System.out.println(info);
			studentLogin=(JSONObject) info.get(0);
			Domitory domitory = (Domitory) JSONObject.toBean(studentLogin,Domitory.class);
		
			request.getSession().setAttribute("domitory", domitory);
			request.getSession().setAttribute("loginName", stu.getStudentUsername()+"_student");
			request.getSession().setAttribute("stu", stu);
		}
		
	}
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
