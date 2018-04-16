<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>js增删改 v1.0</title>
<script type="text/javascript" src="js/jQuery1.9.1.js"></script>
<script type="text/javascript"> 
    $(document).ready(function(){
      $("#txtName").keyup(
        function(){          
          $("table tr:gt(0)").hide();
          var $d = $("table tr:gt(0)").filter(":contains('"+$.trim($("#txtName").val())+"')");
          $d.show();                   
        }
      )
    })  
</script> 
</head>
<body >
<div>
    <input type="text" id="txtName" />
  </div>
  <table>
	<tr>
		<td>学号</td>
		<td>姓名</td>
		<td>性别</td>
		<td>专业</td>
	</tr>
	<tr>
		<td>1</td>
		<td>张三丰</td>
		<td>男</td>
		<td>计算机</td>
	</tr>
	<tr>
		<td>2</td>
		<td>郭大侠</td>
		<td>男</td>
		<td>计算机</td>
	</tr>
	<tr>
		<td>3</td>
		<td>令狐冲</td>
		<td>男</td>
		<td>计算机</td>
	</tr>
</table>
</body>
</html>