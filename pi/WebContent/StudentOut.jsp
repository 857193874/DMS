<%@page import="bean.Out"%>
<%@page import="bean.Maintain"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java"
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="style/css/style_2_common.css" />
	<link rel="stylesheet" type="text/css" href="style/css/style_2_portal_index.css" />
    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
	<link rel="stylesheet" href="style/css/exchange.css">	
	<link rel="stylesheet" href="style/css/exchange.css">
	<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
		<link rel="stylesheet" type="text/css" href="style/css/base.css" />
		
	<script src="style/js/eleFixed.min.js"></script>
	<script>document.documentElement.className="js";var supportsCssVars=function(){var e,t=document.createElement("style");return t.innerHTML="root: { --tmp-var: bold; }",document.head.appendChild(t),e=!!(window.CSS&&window.CSS.supports&&window.CSS.supports("font-weight","var(--tmp-var)")),t.parentNode.removeChild(t),e};supportsCssVars()||alert("Please view this demo in a modern browser that supports CSS Variables.");</script>
	<%
	ArrayList arr=new ArrayList<>();
	String id;
	Out temp=new Out();
	if(request.getAttribute("OutAll")!=null){
		arr=(ArrayList)request.getAttribute("OutAll");
		temp=(Out)arr.get(0);
		id=temp.getOutStudentid();
	}
	else{
		id="";
	}
	
%>
	<script type="text/javascript">
	
	function name() {
		 location.href="/DMS/StuAddOut?outStudentid=<%=id%>";
		/*  alert("aaa"); */
	}	
	 function xxx(){ setTimeout("name()", 850);}
	</script>
</head>
<body  style="width:800px;height:480px; background: url('style/images/bg2.jpg');" class="demo-1">
<div style="width:200px; height:auto; float:left; display:inline">
	<div class="grid__item theme-2" style="background: rgb(0,0,0,0); height: 480px;">
			<button class="action"><svg class="icon icon--rewind"><use xlink:href="#icon-rewind"></use></svg></button>
			<button class="particles-button" style="height: 480px; width: 200px; background: rgb(0,0,0,0);" onclick="xxx()">
				<p style="font-size: 38px; font-weight: bold;">提<br/>交<br/>外<br/>出</p>
			</button>
	</div>
</div> 
<div style="width:600px; height:auto; float:left; display:inline">
<div class="btn-toolbar list-toolbar">
  <div style="float: left;"><h4 style="padding-left: 250px; ">往期外出情况</h4></div>     
  <div style="float: right;"><button class="btn btn-primary" onclick="location.href='index.jsp'">X</button></div>     
  <div class="btn-group"></div>
</div>    
	<div  class="scroller" style="overflow-y:auto;width:600px; height: 440px;" id="kkk">       
	<table class="table" style=" -webkit-user-select:none;
	    -moz-user-select:none;
	    -ms-user-select:none;
	    user-select:none; width: 600px; font-size: 20px !important;color: white;" id="table">
	  <thead>
	    <tr>
	      <th>外出id</th>
	      <th>确认时间</th>
	      <th>状态</th>
	    </tr>
	  </thead>
	  <tbody>
	    <%for(int i=arr.size()-1;i>=0;i--){ 
	    temp=(Out)arr.get(i);%>
	    <tr>
	      <td><%=temp.getOutId() %></td>
	      <td><%=temp.getOutDate() %></td>
	      <td><%=temp.getOutRemark()%></td>
	    </tr>
	    <%} %>
	  </tbody>
	</table>
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
		<script src='style/js/anime.min.js'></script>
	    <script src='style/js/particles.js'></script>
	    <script src='style/js/demo.js'></script>	
</body>
</html>