package com.bhumika.db;

import java.sql.*;
import java.sql.DriverManager;

public class Connect 
{
	static Connection con=null;
	public static Connection dbConnect()
	{
			try
			{	
				if(con==null)
				{
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crm_for_isp","root","");
					System.out.println(con);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return con;
	}
}
