package com.prajval;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SUBTECHERretrive
 */
public class SUBTECHERretrive extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SUBTECHERretrive() {
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

		studentDAO a = new studentDAO();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");  
        out.println("<html><body>");
		try {
			List<SUBTECHRS> s = a.subtechrs();
			out.println("<table border=1 width=50% height=50%>");  
            out.println("<tr><th>SUBJECT ID</th><th>"
            		  + "SUBJECT CODE</th><th>"
            		  + "SUBJECT NAME </th><th>"
            		  + "ASSIGNED CLASS </tr></th>");  
			for(SUBTECHRS ss:s)
			{
				out.println("<tr><td>"+ss.getSubid()+
							"</td><td>"+ss.getSubcode()+
							"</td><td>"+ ss.getSubname()+
							"</td><td>"+ ss.getClassname()+ "</td></tr>");
			}
			out.println("</table>");  
            out.println("</html></body>");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}