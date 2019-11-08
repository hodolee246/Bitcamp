<%@page import="dto.AdminChartDto"%>
<%@page import="java.util.Calendar"%>

<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
// 일별 데이터를 가져왔다
List<AdminChartDto> priceList = (List<AdminChartDto>)request.getAttribute("priceList");
String month = (String)request.getAttribute("month");

// 연령별 데이터를 가져왔다
List<AdminChartDto> ageList = (List<AdminChartDto>)request.getAttribute("ageList");
// 지역별 데이터를 가져왔다
List<AdminChartDto> addressList = (List<AdminChartDto>)request.getAttribute("addressList");




// list -> json : 일별 통계
String jsonlikeMonth = "";
if(priceList.size() != 0){
	jsonlikeMonth = "[";
	for(AdminChartDto m : priceList){
		jsonlikeMonth += "{ y:" + m.getY() + "},";
	}
	
	jsonlikeMonth = jsonlikeMonth.substring(0, jsonlikeMonth.lastIndexOf(","));
	// 맨 끝에 ,만 빼고 다 가져와라
	jsonlikeMonth += "]";
}else{
	jsonlikeMonth = "[{ y:0},]";
}



//list -> json : 연령별 통계
String jsonlikeAge = "[";
for(AdminChartDto a : ageList){
	jsonlikeAge += "{ name:'" + a.getName() + "대    ', y:" + a.getY() + "},";
}
jsonlikeAge = jsonlikeAge.substring(0, jsonlikeAge.lastIndexOf(","));
//맨 끝에 ,만 빼고 다 가져와라
jsonlikeAge += "]";



//list -> json : 지역별 통계
String jsonlikeAddress = "[";

for(AdminChartDto d : addressList){
	jsonlikeAddress += "{ name:'" + d.getCity() + "', y:" + d.getBooking_count() + "},";
}

jsonlikeAddress = jsonlikeAddress.substring(0, jsonlikeAddress.lastIndexOf(","));

jsonlikeAddress += "]";


System.out.println("일별 통계 : " + jsonlikeMonth);
System.out.println("지역별 통계 : " + jsonlikeAddress);
System.out.println("연령별 통계 : " + jsonlikeAge);
request.setAttribute("jsonlikeMonth", jsonlikeMonth);
request.setAttribute("jsonlikeAddress", jsonlikeAddress);
request.setAttribute("jsonlikeAge", jsonlikeAge);

if(month.length() == 0){
	Calendar cal = Calendar.getInstance();
	month = ""+cal.get(Calendar.MONTH)+1;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<!-- JQuery 밑에다 하자 -->
<!-- 일별 통계 -->
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>

<!-- 연령별 통계에 추가로 필요하다 -->
<script src="https://code.highcharts.com/modules/series-label.js"></script>

<style type="text/css">
main{
	overflow: inherit;
	width: 80%;
	height: auto; /* 이걸로 메인에어리어 부분 높이 조정해서 알맞게 쓰기 !! */
	margin: auto;
	margin-bottom: 30px;
}

ul{
   list-style:none;
   padding-left:0px;
}

.menu > li{
	list-style:none;
	color: #eee;
}
.menu > li > a{

	color: #eee;
}  
.menu > li > a:hover{
	list-style:none;
	color: black;
}

#adminMenu{
	overflow: inherit;
	padding-top: 60px;
	padding-left: 30px;
	width: 16%;
	height: auto;
	float: left;
	background-color: gray;
}
#adminMain{
	overflow: inherit;
	width: 84%;
	height: auto;
	float: left;
	text-align: center;
	/* background-color: lightgray; */
	padding-bottom: 150px;
}	
.allMenu{
	font-family: 'Noto Sans KR', sans-serif;
	font-size: 1.3em;
  	color: red;
}
.wrapper{
	/* background-color: blue; */
	width: 100%;
	height: 600px;
}
.box1{
	/* background-color: orange; */
	width: 100%;
	height: 600px;
}
.box2{
	/* background-color: pink; */
	width: 100%;
	height: 600px;
}
.addressBox{
	/* background-color: yellow; */
	width: 50%;
	height: 600px;
	float: left;
}
.agdBox{
	/* background-color: green; */
	width: 50%;
	height: 600px;
	float: left;
}	
</style>
</head>



<body>

<jsp:include page="../header.jsp" flush="false"/>
 
<main>

<div>
	<div id="adminMenu">
	<!-- 
		<ul class="menu">
			<li><a href="/miniProject/admin_servlet?command=adminChart" class="fatag">메인으로</a></li><br>
			<li><a href="/miniProject/customer_servlet?command=adminCustomer" class="fatag">회원 관리</a></li><br>
			<li><a href="/miniProject/admin_servlet?command=roomadmin" class="fatag">객실정보 관리</a><br>
				<ul class="menu"><br>
					<li><a href="/miniProject/admin_servlet?command=" class="fatag">&nbsp;&nbsp;&nbsp;객실정보 등록</a></li><br>
					<li><a href="/miniProject/admin_servlet?command=" class="fatag">&nbsp;&nbsp;&nbsp;객실정보 수정</a></li><br>
					<li><a href="/miniProject/admin_servlet?command=" class="fatag">&nbsp;&nbsp;&nbsp;객실정보 삭제</a></li><br>
				</ul>
			</li>
			<li><a href="/miniProject/booking_servlet?command=adminBooking" class="fatag">예약 관리</a></li><br>
			<li><a href="/miniProject/admin_servlet?command=qnalist&choice=&str=&pageNum=1" class="fatag">고객의소리 관리</a></li><br>
		</ul>
 -->
 	<jsp:include page="../adminMenu.jsp" flush="false"/>
	</div>
	
	<div id="adminMain">
	
	<div class="wrapper">

	<!-- box1에 일별 통계가 나온다 -->
	<div class="box1" id="containerMonth" style="min-width: 310px; max-width: 1300px; margin: 0 auto"></div>
	<form id="frm">
	2019년
	<select id="month">
		<%for(int i = 0; i < 12; i++){ %>
		<option value="<%=i+1%>"><%=i+1%></option>
		<%} %>
	</select>월
	<input type="button" id="payShow" value="매출 보기">
	</form>
	
	<br><br><br><br><br>
	<div class="box2">
	<!-- 연령별 통계 -->
	<div class="addressBox" id="containerAge" style="min-width: 310px; max-width: 700px; margin: 0 auto"></div>
	<!-- 지역별 통계 -->
	<div class="agdBox" id="containerAddress" style="min-width: 310px; max-width: 700px; margin: 0 auto"></div>
	</div>	
	</div>
		
	</div>




</div>

</main>








<jsp:include page="../footer.jsp" flush="false"/>



<script type="text/javascript">
$("#payShow").click(function () {
	var month = $("#month").val();
	
	if(month.length < 2 ){
		month = "0"+month;
	}
	//alert(month);
	
	location.href="admin_servlet?command=adminChart&month="+month;
	
});




// 일별 통계
Highcharts.chart('containerMonth', {

    title: {
        text: <%=month %>+'달 매출 통계'
    },

    subtitle: {
        text: <%=month %>+'달 매출 통계'
    },
    
    xAxis:{
    	title: {
    		text: '일'
    	},
        tickInterval: 1,
        startpoint: 1
    },

    yAxis: {
    	allowDecimals: true,
        title: {
            text: '매출 액수 (단위 백만)'
        },
        tickInterval: 1500000
    },
    legend: {
        layout: 'vertical',
        align: 'right',
        verticalAlign: 'middle'
    },

    plotOptions: {
        series: {
            label: {
                connectorAllowed: false
            },
            pointStart: 1
        }
    },

    series: [{
        name: <%=month %>+'월',
        data: <%=request.getAttribute("jsonlikeMonth") %>
    }],

    responsive: {
        rules: [{
            condition: {
                maxWidth: 500
            },
            chartOptions: {
                legend: {
                    layout: 'horizontal',
                    align: 'center',
                    verticalAlign: 'bottom'
                }
            }
        }]
    }

});




Highcharts.setOptions({
  colors: Highcharts.map(Highcharts.getOptions().colors, function (color) {
    return {
      radialGradient: {
        cx: 0.5,
        cy: 0.3,
        r: 0.7
      },
      stops: [
        [0, color],
        [1, Highcharts.Color(color).brighten(-0.3).get('rgb')] // darken
      ]
    };
  })
});



//연령별 통계
Highcharts.chart('containerAge', {
  chart: {
    plotBackgroundColor: null,
    plotBorderWidth: null,
    plotShadow: false,
    type: 'pie'
  },
  title: {
    text: '연령대별 방문 횟수 통계'
  },
  tooltip: {
    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
  },
  plotOptions: {
    pie: {
      allowPointSelect: true,
      cursor: 'pointer',
      dataLabels: {
        enabled: true,
        format: '<b>{point.name}</b>: {point.percentage:.1f} %',
        style: {
          color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
        },
        connectorColor: 'silver'
      }
    }
  },
  series: [{
    name: 'Share',
    data: <%=request.getAttribute("jsonlikeAge") %>
  }]
});



//지역별 통계
Highcharts.chart('containerAddress', {
  chart: {
    plotBackgroundColor: null,
    plotBorderWidth: null,
    plotShadow: false,
    type: 'pie'
  },
  title: {
    text: '지역별 통계'
  },
  tooltip: {
    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
  },
  plotOptions: {
    pie: {
      allowPointSelect: true,
      cursor: 'pointer',
      dataLabels: {
        enabled: true,
        format: '<b>{point.name}</b>: {point.percentage:.1f} %',
        style: {
          color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
        },
        connectorColor: 'silver'
      }
    }
  },
  series: [{
    name: 'Share',
    data: <%=request.getAttribute("jsonlikeAddress") %>
  }]
});
</script>

</body>
</html>