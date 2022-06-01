package com.prajval;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class studINSERT
 */
public class studINSERT extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studINSERT() {
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
		String studid = request.getParameter("studid");
		String studfname = request.getParameter("studfname");
		String studlname = request.getParameter("studlname");
		String studdob = request.getParameter("studdob");
		String studadd = request.getParameter("studadd");
		String studphone = request.getParameter("studphone");
		String assigncls = request.getParameter("assigncls");
		String classid = request.getParameter("classid");
		//System.out.println(studid +" "+ studfname +" " +studlname+" "+ studdob +" "+ studadd +" "+ studphone);
		PrintWriter out = response.getWriter();
		
		try {
			Connection con = DB_CONNECTION.getConn();
			String sql = "insert into s_t values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, studid);
			ps.setString(2, studfname);
			ps.setString(3, studlname);
			ps.setString(4, studdob);
			ps.setString(5, studadd);
			ps.setString(6, studphone);
			ps.setString(7, assigncls);
			ps.setString(8, classid);
			
			
			int row = ps.executeUpdate();
			
			
			if(row>0)
			{
				//out.print("done");
				response.sendRedirect("studeSUCCESS.html");
			}else
			{
				response.sendRedirect("studFAIL.html");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			out.print("CHECK THE CONNECTION " + e);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
