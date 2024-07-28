package com.bhumika.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bhumika.db.Connect;

/**
 * Servlet implementation class AssignToServiceMan
 */
public class AssignToServiceMan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignToServiceMan() {
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
		int sid=Integer.parseInt(request.getParameter("sid"));
		int comp_id=Integer.parseInt(request.getParameter("comp_id")); 
		System.out.println(sid);
		System.out.println(comp_id);
		Connection con=Connect.dbConnect();
		PreparedStatement ps=con.prepareStatement("update complaints set sid=? where comp_id=?");
		ps.setInt(1, sid);
		ps.setInt(2, comp_id);
		int i=ps.executeUpdate();
		if(i>0)
		{
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
