<%@page import="bean.Power"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java"
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv ="X-UA-Compatible" content="IE=edge, chrome=1">
	<title>Insert title here</title>
	<script type="text/javascript" src="style/js/jquery2.js"></script>	
	<script type="text/javascript" src="style/js/highcharts.js"></script>
	<script type="text/javascript" src="js/exporting.js"></script>
	
	
	<link rel="stylesheet" type="text/css" href="style/css/style_2_common.css" />
	<link rel="stylesheet" type="text/css" href="style/css/style_2_portal_index.css" />
    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
	<link rel="stylesheet" href="style/css/exchange.css">
<style type="text/css">
	#b2 {
		position: absolute;
		left: 389px;
		width:35px;
		height:40px;
		border:0;
		margin-left:45px;
		border-radius:20%;
		background-color:red;
		color:white;
		display:inline-block;
	}

</style>
<script type="text/javascript">
<%
	ArrayList arr=new ArrayList<>();
	if(request.getAttribute("PowerAll")!=null){
		arr=(ArrayList)request.getAttribute("PowerAll");
	}
	Power temp=new Power();
	int k;
	if(request.getAttribute("ID")!=null){
		k=Integer.parseInt((String)request.getAttribute("ID"));
	}else{
		k=0;
	}
%>
$(function () {                                                               
    $('#container').highcharts({                                          
        chart: {  
        	backgroundColor: 'rgba(0,0,0,0)'
        },                                                                
        title: {    
        	useHTML: true,
            text: '第<%=k%>号宿舍电力综合图<button id="b2" >X</button>',
            style: {
                     color: 'white',      //字体颜色
                     fontWeight: 'bold'
                 }
        },  
		//x轴
        xAxis: {                                                          
            categories: ['总电量', '补助电量', '花费电量', '免费电量', '价格'],
            labels:{
                y:30,//向下离坐标轴30px，可以自己调整
                style: {
                	  color: 'white',      //字体颜色
        	          fontWeight: 'bold'
                 }  
            }
        }, 
        yAxis: {                                                          
            labels:{
               x:-10,//向下离坐标轴30px，可以自己调整
                style: {
                	  color: 'white',      //字体颜色
        	          fontWeight: 'bold'
                 }  
            }
        }, 
        legend: {
        	  
        	  // 图例项样式
        	  itemStyle: {
        		  color: 'green',      //字体颜色
  	            fontWeight: 'bold'
        	  },
        	},
        tooltip: {                                                        
            formatter: function() {                                       
                var s;                                                    
                if (this.point.name) { // the pie chart                   
                    s = ''+ this.point.name +': '+ this.y +'元';         
                } else {       
                    s = ''+ this.x  +': '+ this.y;                            
                }                                                         
                return s;                                                 
            }                                                             
        },                                                                
         labels: {
            items: [{                                                     
                html: '花费价格',                          
                style: {                                                  
                    left: '615px',                                         
                    top: '8px',                                           
                    color: 'white', 
                    fontWeight: 'bold'
                }                                                         
            }]                                                            
        },  
        series: [
        <%
        float zong=0;
        float bu=0;
        float hua=0;
        float mian=0;
        float jia=0;
        for(int i=0;i<arr.size();i++){
        	temp=(Power)arr.get(i);
        	zong=zong+Float.parseFloat(temp.getTotalconsumption());
        	bu=bu+Float.parseFloat(temp.getSubsidyconsumption());
        	hua=hua+Float.parseFloat(temp.getPayconsumption());
        	mian=mian+Float.parseFloat(temp.getFreeconsumption());
        	jia=jia+Float.parseFloat(temp.getPrice());
        %>	
        {    
        	
            type: 'column',                                               
            name: '<%=temp.getPowerId() %>',                                                 
            data: [<%=temp.getTotalconsumption() %>,<%=temp.getSubsidyconsumption() %>,<%=temp.getPayconsumption() %>,<%=temp.getFreeconsumption() %>,<%=temp.getPrice() %>]                                         
        },
        <%}%>
        {                                                              
            type: 'spline',                                               
            name: '平均值',                                              
            data: [<%=zong/arr.size()%>,<%=bu/arr.size()%>,<%=hua/arr.size()%>,<%=mian/arr.size()%>,<%=jia/arr.size()%>],                               
            marker: {                                                     
            	lineWidth: 4,                                               
            	lineColor: Highcharts.getOptions().colors[10],               
            	fillColor: 'white'                                          
            }                                                             
        }, {                                                              
            type: 'pie',                                                  
            name: 'Total consumption',                                    
            data: [
            <%for(int i=0;i<arr.size();i++){
          		   temp=(Power)arr.get(i);
          		float z=(Float.parseFloat(temp.getPayconsumption())-Float.parseFloat(temp.getSubsidyconsumption())-Float.parseFloat(temp.getFreeconsumption()))*Float.parseFloat(temp.getPrice());
                if(z<0){z=0;}
          		/*  System.out.print(z);   */  
                     %>
                     {                                                      
                         name: '<%=temp.getPowerId()%>',                                             
                         y: <%=z%>,                                                    
                         color: Highcharts.getOptions().colors[<%=i%>] // Jane's color  
                     },
              <%}%> 
          	], 
            center: [620, 80],                                            
            size: 150,                                                    
            showInLegend: false,                                          
            dataLabels: {                                                 
                enabled: false                                            
            }          
        }]   
           
    }); 
    $("button").click(function(){
    	/* location.href='index.jsp'； */
    	window.history.back(-1); 
    });
});   
</script>
</head>
<body style="width:800px;height:480px; background: url('style/images/bg2.jpg');">
	<div id="container" style="width:800px;height:479px;"></div>
</body>
</html>