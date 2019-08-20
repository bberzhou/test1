<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style type="text/css">
	*{
		padding: 0px;
		margin: 0px;
	}	
	
	#head{
		height: 150px;
		width: 100%;
		border: 1px blue solid;
	}
	
	#body{
		height: 500px;
		width: 100%;
		border: 1px red solid;
	}
	#body #leftNav{
		height: 500px;
		width: 20%;
		border: 1px yellow solid;
	}
	#body #rightShowData{
		height: 500px;
		width: 80%;
		border: 1px black solid;
		position: absolute;
		left: 20%;
		top:150px;
	}
	#foot{
		height: 150px;
		width: 100%;
		border: 1px green solid;
	}
    #leftNavTitle1,#leftNavTitle2{
        text-align: center;
        margin: 20px auto;
    }
     a{
        font:20px "Hiragino Sans GB";
        color:inherit;
        text-decoration: none   ;
        margin: 5px auto;
    }

	 
</style>

</head>
<body>
	<div>
		<!-- header -->
		<div id="head">
            <h2>员工后台管理系统</h2>
		</div>
		<!-- body -->
		<div id="body">
			<!-- 导航菜单 -->
			<div id="leftNav">
                <div id="leftNavTitle1">
                    <a href="EmpServlet?actions=selAllEmp" target="showData" >
                        员工管理
                    </a>
                </div>
                <hr>

                <div id="leftNavTitle2">
                    <a href="addEmp.jsp" target="showData">员工添加</a>
                </div>
                <hr>
			
			</div>
			<!-- 数据展示 -->
			<div id="rightShowData">
				<iframe src="welcome.jsp" name="showData"
						width="100%" height="100%"></iframe>
			</div>
		</div>
		<!-- footer -->
		<div id="foot">

		</div>
	</div>
	
	
</body>
</html>