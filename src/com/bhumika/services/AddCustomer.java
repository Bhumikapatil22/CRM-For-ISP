package com.bhumika.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bhumika.db.CIdGetSet;
import com.bhumika.db.Connect;

/**
 * Servlet implementation class AddCustomer
 */
public class AddCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomer() {
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
			int cid=0;
			String cname=request.getParameter("cname");
			String cmobile=request.getParameter("cmobile");
			String caddress=request.getParameter("caddress");
			String cpincode=request.getParameter("cpincode");
			String cemail=request.getParameter("cemail");
			String cpassword=request.getParameter("cpassword");
			Connection con=Connect.dbConnect();
			PreparedStatement ps=con.prepareStatement("insert into customer values(?,?,?,?,?,?,?)");
			ps.setInt(1, cid);
			ps.setString(2, cname);
			ps.setString(3, cmobile);
			ps.setString(4, caddress);
			ps.setString(5, cpincode);
			ps.setString(6, cemail);
			ps.setString(7, cpassword);
			int i=ps.executeUpdate();
			if(i>0)
			{
				
//				CIdGetSet.setCmobile(cmobile);
//				CIdGetSet.setCaddress(caddress);
				response.sendRedirect("chooseHolder.html");
				
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
