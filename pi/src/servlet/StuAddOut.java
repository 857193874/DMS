package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.NameValuePair;

import service.PostHttp;
import service.TimeUtil;

/**
 * Servlet implementation class StuAddOut
 */
public class StuAddOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuAddOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String outStudentid=request.getParameter("outStudentid");
		String outRemark=request.getParameter("outRemark");
		String outDate=TimeUtil.getTime2();
		NameValuePair[] data = { 
			    new NameValuePair("outStudentid", outStudentid),
			    new NameValuePair("outDate", outDate),
			    new NameValuePair("outRemark", "未处理"),
			  };
		for(int i=0;i<data.length;i++) {
			System.out.println(data[i].toString());
		}
		PostHttp.goPost("http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/out/save",data);
		response.sendRedirect("StuGetOut?studentUsername="+outStudentid);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
