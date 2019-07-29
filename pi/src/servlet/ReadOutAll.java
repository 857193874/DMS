package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Out;
import bean.StudentInfo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.DoGetPost;

/**
 * Servlet implementation class ReadOutAll
 */
public class ReadOutAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadOutAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject outAll=DoGetPost.doGetStr("http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/out/query/all?pn=1");
		 System.out.println(outAll);
		 Map m;
		 m=outAll;
		 outAll=JSONObject.fromObject(m.get("data"));
		 m = outAll;
		 outAll=JSONObject.fromObject(m.get("allOut"));
		 m = outAll;
		 JSONArray all ;
		 all=JSONArray.fromObject(m.get("list"));
		 int count=(int) m.get("pages");
		 ArrayList arr=new ArrayList<>();
		 int i=1;
		 while(true) {
			 for(int j=0;j<all.size();j++) {
				 JSONObject temp= (JSONObject) all.get(j);
				 Out ai=(Out) JSONObject.toBean(temp, Out.class);
				 arr.add(ai);
			 }
			 
			 if(i!=count) {
				 i++;
				 outAll=DoGetPost.doGetStr("http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/out/query/all?pn="+i);
				 m=outAll;
				 outAll=JSONObject.fromObject(m.get("data"));
				 m = outAll;
				 outAll=JSONObject.fromObject(m.get("allOut"));
				 m = outAll;
				 all=JSONArray.fromObject(m.get("list"));
			 }else {
				 break;
			 }
			
		 }
		 System.out.println(arr.size());
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
