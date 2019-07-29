<%@page import="bean.Domitory"%>
<%@page import="bean.StudentInfo"%>
<%@page language="java"
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8"
%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>DMS</title>
	<meta name="description" content="网站描述" />
	<meta name="keywords" content="关键词" />
	<meta name="author" content="order by" />
	<meta http-equiv="MSThemeCompatible" content="Yes" />
	<meta http-equiv ="X-UA-Compatible" content="IE=edge, chrome=1"/>
	<link rel="stylesheet" type="text/css" href="style/css/style_2_common.css" />
	<link rel="stylesheet" type="text/css" href="style/css/style_2_portal_index.css" />
	<script src="style/js/jquery-1.7.2.js" type="text/javascript"></script>
	<script src="style/js/common.js" type="text/javascript"></script>
	<script src="style/js/pace.js" type="text/javascript"></script>
	<link href="style/css/style.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous"/>
	<link rel="stylesheet" type="text/css" href="style/css/demo.css"/>
	<link rel="stylesheet" href="style/css/softkeys-0.0.1.css"/>
</head>
<body style="html { overflow: hidden; }"><!-- style="height: 680px; width: 800px;" -->
<script src="style/js/week_nav.js" type="text/javascript"></script>
<div id="wp" class="wp">
<script src="style/js/jquery-1.7.2.js" type="text/javascript"></script> 
<script src="style/js/jquery.fullpage.min.js" type="text/javascript"></script> 
<script src="style/js/scoll.js" type="text/javascript"></script> 
<script src="style/js/addons.js" type="text/javascript"></script> 
<script src="style/js/case.js" type="text/javascript"></script> 
<script src="style/js/tab.lib.js" type="text/javascript"></script>  
<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
</div>
<%
	String name;
	String []number=new String [2];
	if(request.getSession().getAttribute("loginName")!=null){
		name=(String)request.getSession().getAttribute("loginName");		
		number=name.split("_");
	}
	else {
		name="未登录用户";
	}
	
%>
<div class="wk_index_main page2" style="height: 480px !important;" id="main"> 
 
  <div class="" style="height: 480px !important;">

  
  <div class="section page2" >
    <div class="wk_fwxm" style="height: 480px !important;">
      <ul style="height: 100% !important;" id="te1">
        <li class="wk_li1"   style="height: 100% !important; width: 200px !important;margin-bottom:0px;">
          <div class="wk_fwxm_bg"></div>
          <%if(name.equals("未登录用户")) {%>
          <div class="wk_fwxm_main" onclick="k1()">
            <div class="wk_fwxm_ico"></div>
            <h2>用户登录</h2>
            <p>LOGIN</p>
            <div class="wk_fwxm_des"></div>
            <div class="wk_ljzx"></div>
          </div>
          <%}else if(number[1].equals("student")){ 
          		StudentInfo stu=(StudentInfo)request.getSession().getAttribute("stu");
          		Domitory domitory = (Domitory)request.getSession().getAttribute("domitory");
          %>         	
          <div class="wk_fwxm_main" >
            <div class="wk_fwxm_ico"></div>
            <h2><%=stu.getStudentUsername() %></h2>
            <p><%=stu.getStudentName() %></p>
            <div class="wk_fwxm_des">
            	<div style="text-align: left; margin-left: 45px;">性别：<%=stu.getStudentSex() %></div>
            	<div style="text-align: left; margin-left: 45px;">楼号：<%=domitory.getDomitoryBuildingid() %></div>
            	<div style="text-align: left; margin-left: 45px;">班级：<%=stu.getStudentClass() %></div>           	 	
            </div>
            <div class="wk_ljzx" ><a href="/DMS/LogoutServlet" target="_blank">退出登录</a></div>
          </div>
          <%}else{%>
           <div class="wk_fwxm_main" onclick="location.href='/DMS/ReadStudentAll'">
            <div class="wk_fwxm_ico"></div>
            <h2>人员管理</h2>
            <p>MEN</p>
            <div class="wk_fwxm_des">对学生信息进行管理</div>
            <div class="wk_ljzx" ><a href="/DMS/LogoutServlet" target="_blank">退出登录</a></div>
          </div>
          <%} %>
        </li>
        <!-- ******************************************************************** -->
        <li class="wk_li2" style=" width: 200px !important;">
        <%if(name.equals("未登录用户")) {%>
         <div class="wk_fwxm_bg"></div>
          <div class="wk_fwxm_main">
            <div class="wk_fwxm_ico"></div>
            <h2>电量查询</h2>
            <p>ELECTIC</p>
            <div class="wk_fwxm_des"></div>
            <div class="wk_ljzx" > <a target="_blank" onclick="k1()">请先登录</a></div>
          </div>
          <%}else if(number[1].equals("student")){
        		StudentInfo stu=(StudentInfo)request.getSession().getAttribute("stu");       
        		Domitory domitory = (Domitory)request.getSession().getAttribute("domitory");
          %>         	
         <div class="wk_fwxm_bg"></div>
          <div class="wk_fwxm_main"  onclick="location.href='/DMS/StuGetPower?buildingId=<%=domitory.getDomitoryBuildingid()%>'">
            <div class="wk_fwxm_ico"></div>
            <h2>电量查询</h2>
            <p>ELECTIC</p>
            <div class="wk_fwxm_des" >查看本楼电量及费用信息</div>
            <div class="wk_ljzx" > <a href="/DMS/LogoutServlet" target="_blank">退出登录</a></div>
          </div>
          <%}else{%>
          <div class="wk_fwxm_bg"></div>
          <div class="wk_fwxm_main" onclick="location.href='/DMS/ReadPowerAll'">
            <div class="wk_fwxm_ico"></div>
            <h2>电量管理</h2>
            <p>ELECTIC</p>
            <div class="wk_fwxm_des">对各宿舍楼电量进行管理</div>
            <div class="wk_ljzx" > <a href="/DMS/LogoutServlet" target="_blank">退出登录</a></div>
          </div>
          <%} %>
          
        </li>
        <!-- ******************************************************************** -->
        <li class="wk_li3" style=" width: 200px !important;" ><!-- onclick="myFunction()" -->
         <%if(name.equals("未登录用户")) {%>
        <div class="wk_fwxm_bg"></div>
          <div class="wk_fwxm_main">
            <div class="wk_fwxm_ico"></div>
            <h2>保修管理</h2>
            <p>FIX</p>
            <div class="wk_fwxm_des"></div>
            <div class="wk_ljzx" > <a onclick="k1()" target="_blank">请先登录</a></div>
          </div>
          <%}else if(number[1].equals("student")){
        		StudentInfo stu=(StudentInfo)request.getSession().getAttribute("stu");  
          %>         	
        <div class="wk_fwxm_bg"></div>
          <div class="wk_fwxm_main"  onclick="location.href='/DMS/StuGetMaintain?domitoryId=<%=stu.getStudentDomitoryid()%>'">
            <div class="wk_fwxm_ico"></div>
            <h2>保修管理</h2>
            <p>FIX</p>
            <div class="wk_fwxm_des">提交及查看保修情况</div>
            <div class="wk_ljzx" > <a href="/DMS/LogoutServlet" target="_blank">退出登录</a></div>
          </div>
          <%}else{%>
          <div class="wk_fwxm_bg"></div>
          <div class="wk_fwxm_main"  onclick="location.href='/DMS/ReadMaintainAll'">
            <div class="wk_fwxm_ico"></div>
            <h2>保修管理</h2>
            <p>FIX</p>
            <div class="wk_fwxm_des">对保修请求进行处理</div>
            <div class="wk_ljzx" > <a href="/DMS/LogoutServlet" target="_blank">退出登录</a></div>
          </div>
          <%} %>  
        </li>
        <!-- ******************************************************************** -->       
        <li class="wk_li4" style=" width: 200px !important;">
         <%if(name.equals("未登录用户")) {%>
        <div class="wk_fwxm_bg"></div>
          <div class="wk_fwxm_main">
            <div class="wk_fwxm_ico"></div>
            <h2>外出管理</h2>
            <p>OUT</p>
            <div class="wk_fwxm_des"></div>
            <div class="wk_ljzx" > <a onclick="k1()" target="_blank">请先登录</a></div>
          </div>
          <%}else if(number[1].equals("student")){
        	  StudentInfo stu=(StudentInfo)request.getSession().getAttribute("stu");  
          %>         	
        <div class="wk_fwxm_bg"></div>
          <div class="wk_fwxm_main" onclick="location.href='/DMS/StuGetOut?studentUsername=<%=stu.getStudentUsername()%>'">
            <div class="wk_fwxm_ico"></div>
            <h2>外出管理</h2>
            <p>OUT</p>
            <div class="wk_fwxm_des">提交及查看外出申请情况</div>
            <div class="wk_ljzx" > <a href="/DMS/LogoutServlet" target="_blank">退出登录</a></div>
          </div>
          <%}else{%>
          <div class="wk_fwxm_bg"></div>
          <div class="wk_fwxm_main" onclick="location.href='/DMS/ReadOutAll'">
            <div class="wk_fwxm_ico"></div>
            <h2>外出管理</h2>
            <p>OUT</p>
            <div class="wk_fwxm_des">对外出请求进行处理</div>
            <div class="wk_ljzx" > <a href="/DMS/LogoutServlet" target="_blank">退出登录</a></div>
          </div>
          <%} %>  
        </li>
      </ul>
    </div>
  </div> 
  </div>
</div>
<div id="login" style="display: none;" >

<!-- 登录弹出框 -->
<div class="hide-center" style="margin-top: 10 !important; left: 240px;">
    <div id="formhead">
        <div id="formhead-title">
            User Login
        </div>
        <button type="button" id="close">X</button>
    </div>
    <div id="formbody">
    <form action="LoginServlet" >
        <div class="loginUserName">
            <input id="input-topright-loginInput" onclick="test1()"   autocomplete="off" name="userName" class="loginInput" placeholder="userName" type="text" value="admin" />
        </div>
        <div class="loginPassword">
            <input id="input-bottomright-loginInput" name="password"  autocomplete="off" class="loginInput" placeholder="password" type="password" style="border-bottom-right-radius:5px;" onclick="test2()"/>       	
        </div>
        <div id="formfoot">
        	<input type="checkbox" id="isAdmin" name="isAdmin" value="isAdmin"/><label style="color:red" for="isAdmin">以管理员身份登录</label>
            <button id="BSignIn" type="submit">Sign In</button>
        </div>
        </form>
        
    </div> 
  
</div>
 <div class=" " style="position: absolute;top: 290px;left: 0px; ">
 <!-- 	<div class="softkeys1" id="pas" data-target="input[name='userName']" style="position:absolute; left:0px; width: 800px; height: 120px; align:left;"></div>
 	<div class="softkeys2" id="pas2" data-target="input[name='password']" style="position:absolute; left:0px; width: 800px; height: 120px; align:left; display: none;"></div> -->
	<div class="keyboard" id="softkey1" ></div>
	<div class="keyboard" id="softkey2"></div> 
	</div>
<!-- 登录弹出框结束 -->
</div>
<script type="text/javascript" src="vk_loader.js?vk_layout=CN%20Chinese%20Simpl.%20Pinyin&vk_skin=flat_gray" ></script>

<!-- 相关函数 -->
	<script>
	function test1(){
		$(".keyboard").fadeIn("slow");
		VirtualKeyboard.toggle('input-topright-loginInput', 'softkey1');
		$("#kb_langselector,#kb_mappingselector,#copyrights").css("display", "none");
	}
	function test2(){
		$(".keyboard").fadeIn("slow");
		VirtualKeyboard.toggle('input-bottomright-loginInput', 'softkey2');
		$("#kb_langselector,#kb_mappingselector,#copyrights").css("display", "none");
	}
	
	function myFunction()
	{
		document.getElementById('te1').style.display="none";
		document.getElementById('login').style.display="block";
		document.getElementById('softkey1').style.display="block";
		document.getElementById('softkey2').style.display="block";
		 $(".keyboard").fadeOut(0);
	    $(".hide-center").fadeIn("slow");
	    $(".hide-left").fadeIn("slow");
	    $(".overCurtain").fadeIn("slow");
	}
	function k1()
	{
		setTimeout("myFunction()", 680);
	}
	$("#close").click(function () {
	    $(".hide-center").fadeOut("fast");
	    $(".hide-left").fadeOut("fast");
	    $(".overCurtain").fadeOut("fast");
	    document.getElementById('te1').style.display="block";
	    document.getElementById('softkey1').style.display="none";
	    document.getElementById('softkey2').style.display="none";
	})
</script>

<!-- <script src="style/js/jquery-1.11.0.min.js" type="text/javascript"></script>
	<script src="style/js/softkeys-0.0.1.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
                $('.softkeys1').softkeys({
                    target : $('.softkeys1').data('target'),
                    layout : [
                        [
                          /*   ['`','~'], */
                            ['1','!'],
                            ['2','@'],
                            ['3','#'],
                            ['4','$'],
                            ['5','%'],
                            ['6','^'],
                            ['7','&amp;'],
                            ['8','*'],
                            ['9','('],
                            ['0',')'],
                            'z','x','c','v',.
                          /*   ['-', '_'],  
                            ['=','+'], */
                            'delete'
                        ],
                        [
                            'q','w','e','r','t','y','u','i','o','p',  'b','n','m'
                         /*    ['[','{'],
                            [']','}'] */
                        ],
                        [
                            'capslock',
                            'a','s','d','f','g','h','j','k','l',
                          
                         /*    [';',':'],
                            ["'",'&quot;'],+
                            ['\\','|'] */
                        ],
                        [
                         /*    'shift', */
                          /*   'z','x','c','v','b','n','m', */
                       /*      [',','&lt;'],
                            ['.','&gt;'],
                            ['/','?'],
                            ['@'] */
                        ]
                    ]
                });
                $('.softkeys2').softkeys({
                    target : $('.softkeys2').data('target'),
                    layout : [
                        [
                          /*   ['`','~'], */
                            ['1','!'],
                            ['2','@'],
                            ['3','#'],
                            ['4','$'],
                            ['5','%'],
                            ['6','^'],
                            ['7','&amp;'],
                            ['8','*'],
                            ['9','('],
                            ['0',')'],
                            'z','x','c','v',
                          /*   ['-', '_'],
                            ['=','+'], */
                            'delete'
                        ],
                        [
                            'q','w','e','r','t','y','u','i','o','p',  'b','n','m'
                         /*    ['[','{'],
                            [']','}'] */
                        ],
                        [
                            'capslock',
                            'a','s','d','f','g','h','j','k','l',
                          
                         /*    [';',':'],
                            ["'",'&quot;'],+
                            ['\\','|'] */
                        ],
                        [
                         /*    'shift', */
                          /*   'z','x','c','v','b','n','m', */
                       /*      [',','&lt;'],
                            ['.','&gt;'],
                            ['/','?'],
                            ['@'] */
                        ]
                    ]
                });
            });
	</script> -->
<!-- 相关函数结束 -->
</body>
</html>