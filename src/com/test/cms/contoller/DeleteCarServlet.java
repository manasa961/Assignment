package com.test.cms.contoller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.cms.dbconn.DBConnection;

@WebServlet("/deleteCar")
public class DeleteCarServlet extends HttpServlet
{
	@Override
	protected void  doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String lpn = req.getParameter("lpn");
		Connection conn = DBConnection.getConnection();

		String res = "";
		try {
			String sql = "Delete from car where licence_plate_number=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, lpn);
			int count = ps.executeUpdate();
			
			if(count > 0) {
				res = "Car Deleted successfully.";
			}else {
				res = "<strong>Error! </strong> Something went wrong try again.";
			}
		} catch (Exception e) {
			res = "<strong>Error! </strong> " + e.getMessage();
		}
		req.setAttribute("msg", res);
		req.getRequestDispatcher("/getAllCars").forward(req, resp);
	}
}
