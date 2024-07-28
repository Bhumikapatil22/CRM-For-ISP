<%@page import="java.sql.*"%>
<%@page import="com.bhumika.db.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <!-- Basic -->
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <!-- Mobile Metas -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <!-- Site Metas -->
   <link rel="icon" href="images/earth.png" type="image/gif" />
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="author" content="" />

  <title>ISP</title>

  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

  <!-- fonts style -->
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700;900&display=swap" rel="stylesheet">

  <!-- font awesome style -->
  <link href="css/font-awesome.min.css" rel="stylesheet" />

  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet" />
  <!-- responsive style -->
  <link href="css/responsive.css" rel="stylesheet" />

</head>
<body class="sub_page">

  <div class="hero_area">
    <!-- header section strats -->
    <header class="header_section">
      <div class="container-fluid">
        <nav class="navbar navbar-expand-lg custom_nav-container ">
          <a class="navbar-brand" href="index.html">
            <span>ISP</span>
          </a>

          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class=""> </span>
          </button>

          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav  ml-auto">
              <li class="nav-item ">
                <a class="nav-link" href="index.html">Home <span class="sr-only">(current)</span></a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="customerActions.html"> About</a>
              </li>
              
            </ul>
            
          </div>
        </nav>
      </div>
    </header>
    <!-- end header section -->
  </div>
   <section class="contact_section layout_padding p-5">
    <div class="container">
	<div class="heading_container heading_center m-1">
        <h2 style="color:#ff4646">
         View Unsolved Complaints
        </h2>
      </div>
      </div>
      </section>
<div class=" mx-5">
<table class="table table-striped w-76 mx-auto " >
<thead class=" text-white" style="background-color: #020230" >
<tr>
<th>comp_id</th>
<th>sid</th>
<th>comp_title</th>
<th>comp_details</th>
<th>cmobile</th>
<th>caddress</th>
<th>comp_date</th>
<th>comp_time</th>
<th>Status</th>
<th>cid</th>
<th>service_code</th>

</tr>
</thead>
<tbody >
<%
	try
	{
		int sid=SIdGetSet.getSmanId();
		int cid=CIdGetSet.getCustId();
		Connection con=Connect.dbConnect();
		PreparedStatement ps=con.prepareStatement("select * from complaints where cid=? and status=?");
		ps.setInt(1,cid);
		ps.setString(2,"Unsolved");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{%>
			
			<tr>
			<td><%=rs.getInt(1)%></td>
			<td><%=rs.getInt(2)%></td>
			<td><%=rs.getString(3)%></td>
			<td><%=rs.getString(4)%></td>
			<td><%=rs.getString(5)%></td>
			<td><%=rs.getString(6)%></td>
			<td><%=rs.getString(7)%></td>
			<td><%=rs.getString(8)%></td>
			<td class=" d-flex justify-content-center align-items-center btn btn-danger btn-sm text-white p-0 mt-2"><%=rs.getString(9)%></td>
			<td><%=rs.getInt(10)%></td>
			<td><%=rs.getString(11)%></td>
			</tr>
		<%}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
%>
</tbody>
</table>
</div>
</body>
</html>