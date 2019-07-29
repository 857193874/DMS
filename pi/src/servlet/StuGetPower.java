package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Power;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.DoGetPost;

/**
 * Servlet implementation class StuGetPower
 */
public class StuGetPower extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuGetPower() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String buildingId =request.getParameter("buildingId");
		System.out.println(buildingId);
		JSONObject powerAll=DoGetPost.doGetStr("http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/power/query/bybuilding?buildingId="+buildingId);
		Map m;
		 m=powerAll;
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
		request.setAttribute("ID", buildingId);
		request.getRequestDispatcher("StudentElectric.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
