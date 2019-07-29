package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Maintain;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.DoGetPost;

/**
 * Servlet implementation class ReadMaintainAll
 */
public class ReadMaintainAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadMaintainAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject maintain=DoGetPost.doGetStr("http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/maintain/query/all");
		 System.out.println(maintain);
		 Map m;
		 m=maintain;
		 maintain=JSONObject.fromObject(m.get("data"));
		 m = maintain;
		 JSONArray all ;
		 all=JSONArray.fromObject(m.get("allMaintain"));
		 ArrayList arr=new ArrayList<>();
		 for(int i=0;i<all.size();i++) {
			 JSONObject temp= (JSONObject) all.get(i);
			 Maintain ai=(Maintain) JSONObject.toBean(temp, Maintain.class);
			 arr.add(ai);
		 }
		 request.setAttribute("MaintainAll", arr);
		 request.getRequestDispatcher("manageMaintain.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
