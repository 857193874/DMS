package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Out;
import bean.Power;
import bean.StudentInfo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.DoGetPost;

/**
 * Servlet implementation class SearchPower
 */
public class SearchPower extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPower() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String buildingId =request.getParameter("buildingId");
		if(request.getParameter("buildingId").equals("")) {
			response.sendRedirect("ReadPowerAll");
			return;
		}
		JSONObject powerAll=DoGetPost.doGetStr("http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/power/query/bybuilding?buildingId="+buildingId);
		Map m;
		 m=powerAll;
		 if(m.get("status").toString().equals("100")) {
				request.getRequestDispatcher("managePower.jsp").forward(request, response);
				return;
			}
		 powerAll=JSONObject.fromObject(m.get("data"));
		 m = powerAll;
		 JSONArray all ;
		 all=JSONArray.fromObject(m.get("power"));
		 ArrayList arr=new ArrayList<>();
		 for(int i=0;i<all.size();i++) {
			 JSONObject temp= (JSONObject) all.get(i);
			 Power ai=(Power) JSONObject.toBean(temp, Power.class);
			 arr.add(ai);
		 }
		 request.setAttribute("PowerAll", arr);
		 request.getRequestDispatcher("managePower.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
