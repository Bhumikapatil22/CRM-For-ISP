<%@page import="java.sql.*"%>
<%@page import="com.bhumika.db.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ISP</title>
</head>
<body>
<%
try
{
	int sid=Integer.parseInt(request.getParameter("sid"));
	Connection con=Connect.dbConnect();
	PreparedStatement ps=con.prepareStatement("delete from serviceman where sid=?");
	ps.setInt(1,sid);
	int i=ps.executeUpdate();
	if(i>0)
	{
		response.sendRedirect("viewServiceMen.jsp");
	}
	else
	{
		response.sendRedirect("error.html");
	}
}
catch(Exception e)
{
	e.printStackTrace();
}

%>
</body>
</html>