package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AdminInfo;
import bean.Out;
import bean.StudentInfo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.DoGetPost;

/**
 * Servlet implementation class ReadStudentAll
 */
public class ReadStudentAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadStudentAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 JSONObject studentAll=DoGetPost.doGetStr("http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/student/query/all?pn=1");
		 System.out.println(studentAll);
		 Map m;
		 m=studentAll;
		 studentAll=JSONObject.fromObject(m.get("data"));
		 m = studentAll;
		 studentAll=JSONObject.fromObject(m.get("allStudentInfo"));
		 m = studentAll;
		 JSONArray all ;
		 all=JSONArray.fromObject(m.get("list"));
		 int count=(int) m.get("pages");
		 ArrayList arr=new ArrayList<>();
		 int j=1;
		 while(true) {
			 for(int i=0;i<all.size();i++) {
				 JSONObject temp= (JSONObject) all.get(i);
				 StudentInfo ai=(StudentInfo) JSONObject.toBean(temp, StudentInfo.class);
				 arr.add(ai);
			 }
			 
			 if(j!=count) {
				 j++;
				 studentAll=DoGetPost.doGetStr("http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/student/query/all?pn="+j);
				 m=studentAll;
				 studentAll=JSONObject.fromObject(m.get("data"));
				 System.out.println(studentAll);
				 m = studentAll;
				 studentAll=JSONObject.fromObject(m.get("allStudentInfo"));
				 m = studentAll;
				 all=JSONArray.fromObject(m.get("list"));
			 }else {
				 break;
			 }
			
		 }
		 request.setAttribute("studentAll", arr);
		 request.getRequestDispatcher("manageStudent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
