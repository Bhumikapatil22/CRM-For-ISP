package com.bhumika.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bhumika.db.CIdGetSet;
import com.bhumika.db.Connect;

/**
 * Servlet implementation class GeneratedServiceCode
 */
public class GeneratedServiceCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GeneratedServiceCode() {
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
		int comp_id=Integer.parseInt(request.getParameter("comp_id"));
//		System.out.println(comp_id);
		String serviceCode=request.getParameter("serviceCode");
//		System.out.println(serviceCode);
		Connection con=Connect.dbConnect();
		PreparedStatement ps=con.prepareStatement("update complaints set service_code=? , status=? where comp_id=?");
		ps.setString(1, serviceCode );
		ps.setString(2, "Solved" );
		ps.setInt(3, comp_id);
		int i=ps.executeUpdate();
		if(i>0)
		{
			response.sendRedirect("viewOwnSolvedComplaints.jsp");
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
