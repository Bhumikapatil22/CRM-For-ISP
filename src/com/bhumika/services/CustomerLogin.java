package com.bhumika.services;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bhumika.db.CIdGetSet;
import com.bhumika.db.Connect;

/**
 * Servlet implementation class CustomerLogin
 */
public class CustomerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerLogin() {
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
			Connection con=Connect.dbConnect();
			PreparedStatement ps=con.prepareStatement("select * from customer where cid=? and cpassword=?");
			ps.setInt(1,cid);
			ps.setString(2, cpassword);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				String cmobile=rs.getString(3);
				String caddress=rs.getString(4);
				CIdGetSet.setCustId(cid);
				CIdGetSet.setCmobile(cmobile);
				CIdGetSet.setCaddress(caddress);
				response.sendRedirect("customerActions.html");
				
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
