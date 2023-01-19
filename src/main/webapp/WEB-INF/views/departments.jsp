<%@page import="com.onion.main.departments.DepartmentDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>DepartMents List Page</h1>
	<%
		ArrayList<DepartmentDTO> departmentDTOs = (ArrayList)request.getAttribute("list"); 
	%>
	<div>
		<h3></h3> <%= departmentDTOs.get(0).getDepartment_name() %>
		<h3></h3> <%= departmentDTOs.get(1).getDepartment_name() %>
		<h3></h3> <%= departmentDTOs.get(2).getDepartment_name() %>
		<h3></h3> <%= departmentDTOs.get(3).getDepartment_name() %>
		<h3></h3> <%= departmentDTOs.get(4).getDepartment_name() %>
	</div>
</body>
</html>