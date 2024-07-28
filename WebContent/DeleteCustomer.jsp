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
	int cid=Integer.parseInt(request.getParameter("cid"));
	Connection con=Connect.dbConnect();
	PreparedStatement ps=con.prepareStatement("delete from customer where cid=?");
	ps.setInt(1,cid);
	int i=ps.executeUpdate();
	if(i>0)
	{
		response.sendRedirect("viewCustomer.jsp");
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