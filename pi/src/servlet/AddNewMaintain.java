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
 * Servlet implementation class AddNewMaintain
 */
public class AddNewMaintain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewMaintain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String domitoryId=request.getParameter("domitoryId");
		String status=request.getParameter("status");
		String maintainTime=TimeUtil.getTime2();
		NameValuePair[] data = { 
			    new NameValuePair("domitoryId", domitoryId),
			    new NameValuePair("maintainTime", maintainTime),
			    new NameValuePair("status", status),
			  };
		for(int i=0;i<data.length;i++) {
			System.out.println(data[i].toString());
		}
		PostHttp.goPost("http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/maintain/save",data);
		response.sendRedirect("ReadMaintainAll");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
