package com.bhumika.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bhumika.db.Connect;
import com.bhumika.db.SIdGetSet;

/**
 * Servlet implementation class AddServiceMan
 */
public class AddServiceMan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServiceMan() {
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
			int sid=0;
			String sname=request.getParameter("sname");
			String sdesignation=request.getParameter("sdesignation");
			String sdepartment=request.getParameter("sdepartment");
			String spincode=request.getParameter("spincode");
			String scontact=request.getParameter("scontact");
			String semail=request.getParameter("semail");
			String spassword=request.getParameter("spassword");
			Connection con=Connect.dbConnect();
			PreparedStatement ps=con.prepareStatement("insert into serviceman values(?,?,?,?,?,?,?,?)");
			ps.setInt(1, sid);
			ps.setString(2, sname);
			ps.setString(3, sdesignation);
			ps.setString(4, sdepartment);
			ps.setString(5, spincode);
			ps.setString(6, scontact);
			ps.setString(7, semail);
			ps.setString(8, spassword);
			int i=ps.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("chooseHolder.html");
				SIdGetSet.setSmanId(sid);
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
