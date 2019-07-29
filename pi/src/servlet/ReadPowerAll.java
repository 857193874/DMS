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
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.DoGetPost;

/**
 * Servlet implementation class ReadPowerAll
 */
public class ReadPowerAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadPowerAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject powerAll=DoGetPost.doGetStr("http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/power/query/all?pn=1");
		 System.out.println(powerAll);
		 Map m;
		 m=powerAll;
		 powerAll=JSONObject.fromObject(m.get("data"));
		 m = powerAll;
		 powerAll=JSONObject.fromObject(m.get("allPower"));
		 m = powerAll;
		 JSONArray all ;
		 all=JSONArray.fromObject(m.get("list"));
		 int count=(int) m.get("pages");
		 ArrayList arr=new ArrayList<>();
		 int i=1;
		 while(true) {
			 for(int j=0;j<all.size();j++) {
				 JSONObject temp= (JSONObject) all.get(j);
				 Power ai=(Power) JSONObject.toBean(temp, Power.class);
				 arr.add(ai);
			 }
			 
			 if(i!=count) {
				 i++;
				 powerAll=DoGetPost.doGetStr("http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/power/query/all?pn="+i);
				 m=powerAll;
				 powerAll=JSONObject.fromObject(m.get("data"));
				 m = powerAll;
				 powerAll=JSONObject.fromObject(m.get("allPower"));
				 m = powerAll;
				 all=JSONArray.fromObject(m.get("list"));
			 }else {
				 break;
			 }
			
		 }
		 ArrayList tempList=new ArrayList<>();
		 for(int j=0;j<arr.size();j++) {
			Power temp=(Power) arr.get(j);
			tempList.add(temp.getPowerBuildingId());
		 }
		 ArrayList buildingIdList=new ArrayList<>();
		 for (int k=0; k<tempList.size();k++) {
			 if(!buildingIdList.contains(tempList.get(k))) {
				 buildingIdList.add(tempList.get(k));
			 }
		 }
		 request.setAttribute("buildingIdList", buildingIdList);
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
