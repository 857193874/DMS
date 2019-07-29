package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.StudentInfo;
import net.sf.json.JSONObject;
import service.DoGetPost;

/**
 * Servlet implementation class SearchStudent
 */
public class SearchStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentUsername=request.getParameter("studentUsername");
		if(request.getParameter("studentUsername").equals("")) {
			response.sendRedirect("ReadStudentAll");
			return;
		}
		JSONObject student=DoGetPost.doGetStr("http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/student/query/"+studentUsername);
		Map m = student;
		if(m.get("status").toString().equals("100")) {
			request.getRequestDispatcher("manageStudent.jsp").forward(request, response);
			return;
		}
		student=JSONObject.fromObject(m.get("data"));
		m = student;
		StudentInfo stu=(StudentInfo) JSONObject.toBean(JSONObject.fromObject(m.get("studentInfo")), StudentInfo.class);
		System.out.println(stu.getStudentName());
		ArrayList arr=new ArrayList<>();
		arr.add(stu);
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
