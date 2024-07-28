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
                <a class="nav-link" href="serviceManActions.html">Actions</a>
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
	         <h2 class="p-4" style="color:#ff4646">Your Service Code for complaint id:</h2>
	    </div>
 


<%
int comp_id=Integer.parseInt(request.getParameter("comp_id"));
int serviceCode=Integer.parseInt(request.getParameter("service_code"));
 //String serviceCode = ServiceCode.generateServiceCode();
%>
<div class="row">
        <div class="col-md-8 col-lg-6 mx-auto">
          <div class="form_container">
           <form action="GeneratedServiceCode" method="post">
              <div>
		      	<input type="text" name="comp_id" value=<%=comp_id%>>
		      	<input type="text" name="comp_id" value=<%=serviceCode%>>
		      </div>
				
			<div>
				<input type="text" name="serviceCode" placeholder="Enter above Service Code">
			</div>
			 
			 
			 <div class="btn_box ">
                <button>
                  Enter
                </button>
              </div>
			</form>
			 </div>
        </div>
      </div>
    </div>
  </section>
			
<% 
 %>
</body>
</html>