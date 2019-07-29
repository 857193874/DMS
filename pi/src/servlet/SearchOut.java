package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Maintain;
import bean.Out;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.DoGetPost;

/**
 * Servlet implementation class SearchOut
 */
public class SearchOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentUsername=request.getParameter("studentUsername");
		if(request.getParameter("studentUsername").equals("")) {
			response.sendRedirect("ReadOutAll");
			return;
		}
		JSONObject out=DoGetPost.doGetStr("http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/out/query/bystudentusername?studentUsername="+studentUsername);
		Map m;
		 m=out;
		 if(m.get("status").toString().equals("100")) {
				request.getRequestDispatcher("manageOut.jsp").forward(request, response);
				return;
			}
		 out=JSONObject.fromObject(m.get("data"));
		 m = out;
		 JSONArray all ;
		 all=JSONArray.fromObject(m.get("out"));
		 ArrayList arr=new ArrayList<>();
		 for(int i=0;i<all.size();i++) {
			 JSONObject temp= (JSONObject) all.get(i);
			 Out ai=(Out) JSONObject.toBean(temp, Out.class);
			 arr.add(ai);
		 }
		 request.setAttribute("OutAll", arr);
		 request.getRequestDispatcher("manageOut.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
