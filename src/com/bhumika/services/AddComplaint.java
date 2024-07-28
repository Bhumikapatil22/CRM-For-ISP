package com.bhumika.services;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bhumika.db.CIdGetSet;
import com.bhumika.db.Connect;
import com.bhumika.db.SIdGetSet;
import com.bhumika.db.ServiceCode;
/**
 * Servlet implementation class AddComplaint
 */
public class AddComplaint extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddComplaint() {
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
			int comp_id=0;		
			String comp_title=request.getParameter("complaint_title");
			String comp_details=request.getParameter("complaint_details");
//			String cmobile=request.getParameter("cmobile");
//			String caddress=request.getParameter("caddress");
			String comp_date=request.getParameter("complaint_date");
			String comp_time=request.getParameter("complaint_time");
			int cid=CIdGetSet.getCustId();
			int sid=SIdGetSet.getSmanId();

			String cmobile=CIdGetSet.getCmobile();
			String caddress=CIdGetSet.getCaddress();
			 String serviceCode = ServiceCode.generateServiceCode();
			
			Connection con=Connect.dbConnect();
			PreparedStatement ps=con.prepareStatement("insert into complaints values(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1,comp_id);
			ps.setInt(2, 0);
			ps.setString(3,comp_title);
			ps.setString(4,comp_details);
			ps.setString(5,cmobile);
			ps.setString(6,caddress);
			ps.setString(7,comp_date);
			ps.setString(8,comp_time);
			ps.setString(9,"Unsolved");
			ps.setInt(10,cid);
			ps.setString(11,serviceCode);
			int i=ps.executeUpdate();
			if(i>0)
			{
				CIdGetSet.setComp_id(comp_id);
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
