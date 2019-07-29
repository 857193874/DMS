package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.NameValuePair;

import service.PostHttp;

/**
 * Servlet implementation class AddNewPower
 */
public class AddNewPower extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewPower() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String totalconsumption=request.getParameter("totalconsumption");
		String subsidyconsumption=request.getParameter("subsidyconsumption");
		String payconsumption=request.getParameter("payconsumption");
		String freeconsumption=request.getParameter("freeconsumption");
		String price=request.getParameter("price");
		String powerBuildingId =request.getParameter("powerBuildingId");
		NameValuePair[] data = { 
			    new NameValuePair("totalconsumption", totalconsumption),
			    new NameValuePair("subsidyconsumption", subsidyconsumption),
			    new NameValuePair("payconsumption", payconsumption),
			    new NameValuePair("freeconsumption", freeconsumption),
			    new NameValuePair("price", price),
			    new NameValuePair("powerBuildingId", powerBuildingId),
			  };
		for(int i=0;i<data.length;i++) {
			System.out.println(data[i].toString());
		}
		PostHttp.goPost("http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/power/save",data);
		response.sendRedirect("ReadPowerAll");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
