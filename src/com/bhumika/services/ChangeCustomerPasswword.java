package com.bhumika.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bhumika.db.Connect;

/**
 * Servlet implementation class ChangeCustomerPasswword
 */
public class ChangeCustomerPasswword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeCustomerPasswword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		try
		{
		int cid=Integer.parseInt(request.getParameter("cid"));
		String cpassword=request.getParameter("cpassword");
		String npassword=request.getParameter("npassword");
		if(cpassword!=npassword)
		{
		Connection con=Connect.dbConnect();
		PreparedStatement ps=con.prepareStatement("update customer set cpassword=? where cid=?");
		ps.setString(1, npassword);
		ps.setInt(2, cid);
		
		int i=ps.executeUpdate();
		if(i>0)
		{
			response.sendRedirect("custLogin.html");
		}
		else
		{
			response.sendRedirect("error.html");
		}
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
		
		
		
		
		
		
	}

}
