<%@page import="bean.StudentInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> -->
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>DMS</title>
	<meta http-equiv="MSThemeCompatible" content="Yes" />
	<meta http-equiv ="X-UA-Compatible" content="IE=edge, chrome=1">
	<link rel="stylesheet" type="text/css" href="style/css/style_2_common.css" />
	<link rel="stylesheet" type="text/css" href="style/css/style_2_portal_index.css" />
    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
	<link rel="stylesheet" href="style/css/exchange.css">
	<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
	
	<script src="style/js/eleFixed.min.js"></script>
</head>
<%
	ArrayList arr=new ArrayList<>();
	if(request.getAttribute("studentAll")!=null){
		arr=(ArrayList)request.getAttribute("studentAll");
	}
	StudentInfo temp=new StudentInfo();
%>
<body>
<script src="style/js/week_nav.js" type="text/javascript"></script>
<div id="wp" class="wp">
</div>

<div class="wk_index_main page2" style="height: 480px " id="main"> 

<div class="" style="height: 480px;">	
<div class="main-content" style="font-size: 20px !important;color: white;">
<div id="t1" style="">
<div class="btn-toolbar list-toolbar">
   <button class="btn btn-primary" onclick="addEvent()"><i class="fa fa-plus"></i>添加新的学生</button>
   <button class="btn btn-primary" onclick="k2()"><i class="fa fa-plus"></i>搜索</button>
     <div style="float: right;"><button class="btn btn-primary" onclick="location.href='index.jsp'">X</button></div>     
  <div class="btn-group">
  </div>
</div>

<div  class="scroller" style="overflow-y:auto;height: 440px;" id="kkk">   
 
	<table class="table" style=" -webkit-user-select:none;
	    -moz-user-select:none;
	    -ms-user-select:none;height: 440px;
	    user-select:none;" id="table">
	  <thead>
	   <tr>
		      <th>用户名</th>
		      <th>班级id</th>
		      <th>学生姓名</th>
		      <th>性别</th>
		      <th>所在班级</th>
		      <th>状态</th>
		      <th style="width: 5em;">操作</th>
		    </tr>
	    </thead>
	  <tbody style="overflow-y:scroll;">
	    <%for(int i=0;i<arr.size();i++){ 
	    temp=(StudentInfo)arr.get(i);%>
	    <tr>
	      <td><%=temp.getStudentUsername() %></td>
	      <td><%=temp.getStudentDomitoryid() %></td>
	      <td><%=temp.getStudentName() %></td>
	      <td><%=temp.getStudentSex() %></td>
	      <td><%=temp.getStudentClass() %></td>
	      <td><%=temp.getStudentState() %></td>
	      <td style="display:none"><%=temp.getStudentPassword() %></td>
	      <td>
	          <a ><i class="fa fa-pencil"></i></a>
	          <a class="fa fa-delete"><i class="fa fa-trash-o"></i></a>
	      </td>
	    </tr>
	    <%} %>
	  </tbody>
	</table>
</div> 
<div class="modal small fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h3 id="myModalLabel">Delete Confirmation</h3>
        </div>
        <div class="modal-body">
            <p class="error-text"><i class="fa fa-warning modal-icon"></i>Are you sure you want to delete the user?<br>This cannot be undone.</p>
        </div>
        <div class="modal-footer">
            <button class="btn btn-default" data-dismiss="modal" aria-hidden="true">Cancel</button>
            <button class="btn btn-danger" data-dismiss="modal">Delete</button>
        </div>
      </div>
    </div>
</div>
        </div>

</div>
</div>
</div>
<div id="BackTop" style="position:fixed;bottom:60px;right:10px;display:none;cursor:pointer;"><img src="style/images/gotoTop.png"></div>
<script type="text/javascript"><!--侧边栏-->
	idBackTop=document.getElementById('BackTop');
	idBackTop.onclick=function (){
		container.scrollTop(0);
		sb();
	}
	$("div").scroll(sb);
	function sb(){
		var element = document.getElementById('kkk');
		if(element.scrollTop==0){
			idBackTop.style.display="none";
		}else{
			idBackTop.style.display="block";
		}
	}
</script>
<script type="text/javascript">
eleFixed.push({
    target: document.getElementsByTagName('thead')[0], // it must be a HTMLElement
    offsetTop: 40 // height from window offsetTop
})
////////////////////////////////////////
$('.scroller').mousemove( 
	    function(e) {
	        var rightEdge = $(this).position().left + $(this).width();
	        console.log('r: ' + rightEdge);
	        console.log('mx: ' + e.pageX + ' my:' + e.pageY);
	        if (e.pageX >= (rightEdge  - 12) && e.pageX <= rightEdge)
	            $(this).addClass('scrollbarhover');
	        else
	            $(this).removeClass('scrollbarhover');
	    }
	);

	$('.scroller').mouseleave( function() {
	    $(this).removeClass('scrollbarhover');
	});
/////////////////////////////////////////////////////////////////////////////
        	var moveValue = 10; //scroll threshold value
        	var mouseY = 0; //Y coordinate
        	var container = $('div');
        	$(function(){
        	    disableSelection(document.body);
        	    $('#kkk').bind('mousedown',function(event){
        	    	/* alert("1111"); */
        	        flag = true;
        	    }).bind('mouseup',function(event){
        	        flag = false;
        	    }).bind('mousemove',function(event){        	    	
        	        if(!flag) return;        	 
        	        if(mouseY < event.clientY){	
        	        	/* container.scrollTop(100);//滚动到div 100px */      	        	 
        	        	container.scrollTop(GetPageScroll().Y - moveValue);    
        	        } else {
        	        	container.scrollTop(GetPageScroll().Y + moveValue);    
        	        }
        	    mouseY = event.clientY;
        	    });
        	});

        	function GetPageScroll() {
        	  var x, y;
        	  var element = document.getElementById('kkk');
  				y = element.scrollTop;
  				x = document.body.scrollLeft;
        	  
        	 /*   alert(y);  */
        	  return {X:x, Y:y};
        	}
        	 
        	function disableSelection(target){
        	  if (typeof target.onselectstart!="undefined") //IE 
        	    target.onselectstart=function(){return false;}
        	  else if (typeof target.style.MozUserSelect!="undefined") //Firefox 
        	    target.style.MozUserSelect="none";
        	  else //All other ie: Opera
        	    target.onmousedown=function(){return false}
        	  target.style.cursor = "default"
        	}

        </script>
<!-- 登录弹出框 -->
<div id="login" style="display: none; position: absolute; left: 80px; height: 170px;" >
<div class="hide-center" >
    <div id="formhead" style="width:640px !important;">
        <div id="formhead-title" style="position: absolute; left: 70px;">新增学生</div>
        <button type="button" id="close" style="float:right">X</button>
    </div>
    <div id="formbody" style="height:250px !important; width: 640px !important;">
    <form action="AddNewStudent" id="form" style="width: 640px !important;">
        <div class="loginUserName" style="padding-left: 15px;">
            <input style="width: 200px;" onclick="test1()" id="studentUsername" name="studentUsername" class="loginInput" placeholder="学号" type="text" value=""/>
			<input style="width: 200px; padding-left: 20px;" onclick="test2()" id="studentName" name="studentName" class="loginInput" placeholder="学生姓名" type="text" value=""/>
			<input style="width: 200px; padding-left: 20px;" onclick="test3()" id="studentPassword" name="studentPassword" class="loginInput" placeholder="密码" type="test" />
        </div>
        <div class="loginUserName"style="padding-left: 15px;">           
            <input  style="width: 200px;" onclick="test4()" id="studentSex" name="studentSex" class="loginInput" placeholder="性别" type="text" value="">
            <input style="width: 200px; padding-left: 20px;" onclick="test5()" id="studentDomitoryid" name="studentDomitoryid" class="loginInput" placeholder="班级编号" type="text" value="">
            <input style="width: 200px; padding-left: 20px;" onclick="test6()" id="studentClass" name="studentClass" class="loginInput" placeholder="所在班级" type="text" value="">
            <input id="studentState" name="studentState" class="loginInput" placeholder="状态" type="text" value="" style="display: none;">
        </div>
        <div id="formfoot" style="width: 640px !important;">
            <button id="BSignIn" type="submit" style="width: 570px;">添加</button>
        </div>
        </form>
    </div>
</div>
</div>
<!-- 登录弹出框结束 -->

<!-- 登录弹出框 -->
<div id="search" style="display: none; position: absolute; left: 240px; height: 170px;" >
<div class="hide-center">
    <div id="formhead" style="width:300px;
	height:42px;
	margin:0;
	padding-top:12px;
	padding-bottom:-30px;
	border-top-left-radius:10px;
	border-top-right-radius:10px;
	background-color:#101010;">
        <div id="formhead-title" style="width:80px;
	height:24px;
	margin-left:100px;
	margin-right:36px;
	color:#bfbfbf;
	font-weight:900;
	display:inline-block;">查找学生</div>
        <button type="button" id="closeo" style="width:35px;
	height:20px;
	border:0;
	margin-left:45px;
	border-radius:20%;
	background-color:red;
	color:white;
	display:inline-block;">X</button>
    </div>
    <div id="formbody" style="width:300px ;height:170px ">
    <form action="SearchStudent" id="form">
        <div class="loginUserName">
            <input id="studentUsername1" name="studentUsername" onclick="test7()" class="loginInput" placeholder="学号" type="text" value="">
        </div>
        <div id="formfoot">
            <button id="BSignIn" type="submit">查找</button>
        </div>
        </form>
    </div>
</div>
</div>
<!-- 登录弹出框结束 -->
<div class=" " style="position: absolute;top: 290px;left: 0px; ">
 <!-- 	<div class="softkeys1" id="pas" data-target="input[name='userName']" style="position:absolute; left:0px; width: 800px; height: 120px; align:left;"></div>
 	<div class="softkeys2" id="pas2" data-target="input[name='password']" style="position:absolute; left:0px; width: 800px; height: 120px; align:left; display: none;"></div> -->
	<div class="keyboard" id="softkey1"></div>
	<div class="keyboard" id="softkey2"></div> 
	<div class="keyboard" id="softkey3" ></div>
	<div class="keyboard" id="softkey4"></div> 
	<div class="keyboard" id="softkey5" ></div>
	<div class="keyboard" id="softkey6"></div> 
	<div class="keyboard" id="softkey7"></div> 
</div>

<script type="text/javascript" src="vk_loader.js?vk_layout=CN%20Chinese%20Simpl.%20Pinyin&vk_skin=flat_gray" ></script>
<script type="text/javascript">
 var k=0;
 var time=0;
function test1(){
	$(".keyboard").fadeIn(0);
	VirtualKeyboard.toggle('studentUsername', 'softkey1');
	$("#kb_langselector,#kb_mappingselector,#copyrights").css("display", "none");
	k=1;
	time=time+1;
}
function test2(){
	$(".keyboard").fadeIn(0);
	VirtualKeyboard.toggle('studentName', 'softkey2');
	$("#kb_langselector,#kb_mappingselector,#copyrights").css("display", "none");
	k=2;
	time=time+1;
}
function test3(){
	$(".keyboard").fadeIn(0);
	VirtualKeyboard.toggle('studentPassword', 'softkey3');
	$("#kb_langselector,#kb_mappingselector,#copyrights").css("display", "none");
	k=3;
	time=time+1;
}
function test4(){
	$(".keyboard").fadeIn(0);
	VirtualKeyboard.toggle('studentSex', 'softkey4');
	$("#kb_langselector,#kb_mappingselector,#copyrights").css("display", "none");
	k=4;
	time=time+1;
}
function test5(){
	$(".keyboard").fadeIn(0);
	VirtualKeyboard.toggle('studentDomitoryid', 'softkey5');
	$("#kb_langselector,#kb_mappingselector,#copyrights").css("display", "none");
	k=5;
	time++;
}
function test6(){
	$(".keyboard").fadeIn(0);
	VirtualKeyboard.toggle('studentClass', 'softkey6');
	$("#kb_langselector,#kb_mappingselector,#copyrights").css("display", "none");
	k=6;
	time++;
}
function test7(){
	$(".keyboard").fadeIn(0);
	VirtualKeyboard.toggle('studentUsername1', 'softkey7');
	$("#kb_langselector,#kb_mappingselector,#copyrights").css("display", "none");
	k=7;
	time++;
}
</script>
<script type="text/javascript">
function myFunction()
{
	document.getElementById('t1').style.display="none";
	document.getElementById('login').style.display="block";
	
    document.getElementById('search').style.display="none";
    document.getElementById('softkey1').style.display="block";
	document.getElementById('softkey2').style.display="block";
	document.getElementById('softkey3').style.display="block";
	document.getElementById('softkey4').style.display="block";
	document.getElementById('softkey5').style.display="block";
	document.getElementById('softkey6').style.display="block";
	
	 $(".keyboard").fadeOut(0);
	 $(".hide-center").fadeIn("slow");
	 $(".overCurtain").fadeIn("slow");
}
function myFunction1()
{
	document.getElementById('t1').style.display="none";
	
	document.getElementById('search').style.display="block";
	document.getElementById('softkey7').style.display="block";
    $(".hide-center").fadeIn("slow");
    $(".overCurtain").fadeIn("slow");
    document.getElementById('login').style.display="none";
}
function addEvent(){
	document.getElementById('formhead-title').innerHTML="新增学生";
    document.getElementById('form').action="AddNewStudent";
    document.getElementById('BSignIn').innerHTML="添加";
    $('#studentUsername').removeAttr("readonly");
    $('#studentUsername').removeAttr("disabled"); 
    $('#studentDomitoryid').removeAttr("disabled"); 
    $('#studentName').removeAttr("disabled"); 
    $('#studentSex').removeAttr("disabled"); 
    $('#studentClass').removeAttr("disabled"); 
    $('#studentState').removeAttr("disabled"); 
    $('#studentPassword').removeAttr("disabled"); 
    
    document.getElementById('studentUsername').value="";
    document.getElementById('studentDomitoryid').value="";
    document.getElementById('studentName').value="";
    document.getElementById('studentSex').value="";
    document.getElementById('studentClass').value="";
    document.getElementById('studentState').value="";;
    document.getElementById('studentPassword').value="";
	k1();
}
function k1()
{
	setTimeout("myFunction()", 100);
}
function k2() {
	setTimeout("myFunction1()", 100);
}
$("#close").click(function () {
    $(".hide-center").fadeOut("fast")
    $(".overCurtain").fadeOut("fast")
    document.getElementById('t1').style.display="block";
    if(time%2==1&&k!=0){
    	//alert(time);
	    if(k==1){
			test1();
		}
	    else if(k==2){
	    	test2();
	    }
	    else if(k==3){
	    	test3();
	    }
	    else if(k==4){
	    	test4();
	    }
	    else if(k==5){
	    	test5();
	    }
	    else if(k==6){
	    	test6();
	    }
    }
    document.getElementById('softkey1').style.display="none";
	document.getElementById('softkey2').style.display="none";
	document.getElementById('softkey3').style.display="none";
	document.getElementById('softkey4').style.display="none";
	document.getElementById('softkey5').style.display="none";
	document.getElementById('softkey6').style.display="none";
	////////
	time=0;
	k=0;
})
$("#closeo").click(function () {
    $(".hide-center").fadeOut("fast")
    $(".overCurtain").fadeOut("fast")
    if(time%2==1&&k!=0){
    	test7();
    }
	document.getElementById('softkey7').style.display="none";
    document.getElementById('t1').style.display="block";
})

$("table").on("click","tr",function(e){
	   if($(e.target).attr("class")=="fa fa-delete"||
			   $(e.target).attr("class")=="fa fa-trash-o"){   
			  document.getElementById('formhead-title').innerHTML="删除";
		      document.getElementById('form').action="DeleteStudent";
		      document.getElementById('BSignIn').innerHTML="删除";
		      document.getElementById('studentUsername').readonly="readonly";
		      document.getElementById('studentDomitoryid').disabled="true";
		      document.getElementById('studentName').disabled="true";
		      document.getElementById('studentSex').disabled="true";
		      document.getElementById('studentClass').disabled="true";
		      document.getElementById('studentState').disabled="true";
		      document.getElementById('studentPassword').disabled="true";
		  }else if($(e.target).attr("class")=="fa fa-pencil"){
			  document.getElementById('formhead-title').innerHTML="修改学生";
		      document.getElementById('form').action="ExchangeStudent";
		      document.getElementById('BSignIn').innerHTML="修改";
		      document.getElementById('studentUsername').readonly="readonly";
		  }
       if(document.getElementById('formhead-title').innerHTML=="新增学生"){
    	   
       }else if(document.getElementById('formhead-title').innerHTML=="删除"
    		   ||document.getElementById('formhead-title').innerHTML=="修改学生"){
    	   var arr = []
           $(this).children().map(function(el){
               arr.push($(this)[0].innerText)
           })
           document.getElementById('studentUsername').value=arr[0];
           document.getElementById('studentDomitoryid').value=arr[1];
           document.getElementById('studentName').value=arr[2];
           document.getElementById('studentSex').value=arr[3];
           document.getElementById('studentClass').value=arr[4];
           document.getElementById('studentState').value=arr[5];
           document.getElementById('studentPassword').value=arr[6];
           /* alert(arr); */
           k1();
       }
    })

</script>

</body>

</html>