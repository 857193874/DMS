package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.NameValuePair;

import service.PostHttp;

/**
 * Servlet implementation class AddNewStudent
 */
public class AddNewStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentUsername=request.getParameter("studentUsername");
		String studentDomitoryid=request.getParameter("studentDomitoryid");
		String studentPassword=request.getParameter("studentPassword");
		String studentName=request.getParameter("studentName");
		String studentSex=request.getParameter("studentSex");
		String studentClass=request.getParameter("studentClass");
		/*String studentState=request.getParameter("studentState");*/
		String studentState="��У";
		NameValuePair[] data = { 
			    new NameValuePair("studentUsername", studentUsername),
			    new NameValuePair("studentDomitoryid", studentDomitoryid),
			    new NameValuePair("studentPassword", studentPassword),
			    new NameValuePair("studentName", studentName),
			    new NameValuePair("studentSex", studentSex),
			    new NameValuePair("studentClass", studentClass),
			    new NameValuePair("studentState", studentState),
			  };
		for(int i=0;i<data.length;i++) {
			System.out.println(data[i].toString());
		}
		PostHttp.goPost("http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/student/save",data);
		response.sendRedirect("ReadStudentAll");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
