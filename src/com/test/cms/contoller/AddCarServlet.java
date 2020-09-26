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

@WebServlet("/addCar")
public class AddCarServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String company = req.getParameter("company");
		String model = req.getParameter("model");
		String color = req.getParameter("color");
		String dop = req.getParameter("dop");
		System.out.println(dop);
		String price = req.getParameter("price");
		String engineCapacity = req.getParameter("engineCapacity");
		String lpn = req.getParameter("lpn");
		String seating = req.getParameter("seating");
		Connection conn = DBConnection.getConnection();
		if(req.getParameter("update") != null && req.getParameter("update") != "")
		{
			String res = "";
			try {
				
				String sql = "Delete from car where licence_plate_number=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, lpn);
				ps.executeUpdate();
				
				Date parse = new SimpleDateFormat("yyyy-MM-dd").parse(dop);
				java.sql.Date sqlDate = new java.sql.Date(parse.getTime()); 
				sql = "INSERT INTO car VALUES (?,?,?,?,?,?,?,?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1, company);
				ps.setString(2, model);
				ps.setString(3, color);
				ps.setDate(4, sqlDate);
				ps.setDouble(5,Double.parseDouble(price));
				ps.setString(6, engineCapacity);
				ps.setString(7, lpn);
				ps.setInt(8, Integer.parseInt(seating));
				int count = ps.executeUpdate();
				
				if(count > 0) {
					res = "Car Updated successfully.";
				}else {
					res = "<strong>Error! </strong> Something went wrong try again.";
				}
			} catch (Exception e) {
				res = "<strong>Error! </strong> " + e.getMessage();
			}
			req.setAttribute("msg", res);
			req.getRequestDispatcher("/getAllCars").forward(req, resp);
		}else {
			String res = "";
			try {
				Date parse = new SimpleDateFormat("yyyy-MM-dd").parse(dop);
				java.sql.Date sqlDate = new java.sql.Date(parse.getTime()); 
				String sql = "INSERT INTO car VALUES (?,?,?,?,?,?,?,?)";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, company);
				ps.setString(2, model);
				ps.setString(3, color);
				ps.setDate(4, sqlDate);
				ps.setDouble(5,Double.parseDouble(price));
				ps.setString(6, engineCapacity);
				ps.setString(7, lpn);
				ps.setInt(8, Integer.parseInt(seating));
				int count = ps.executeUpdate();
				
				if(count > 0) {
					res = "Car Added successfully.";
				}else {
					res = "<strong>Error! </strong> Something went wrong try again.";
				}
			} catch (Exception e) {
				res = "<strong>Error! </strong> " + e.getMessage();
			}
			req.setAttribute("msg", res);
			req.getRequestDispatcher("/add-car.jsp").forward(req, resp);
		}
	}
}
