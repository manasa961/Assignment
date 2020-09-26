package com.test.cms.contoller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.cms.dbconn.DBConnection;
import com.test.cms.model.Car;

@WebServlet("/editCar")
public class EditCarServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String lpn = req.getParameter("lpn");
		Connection conn = DBConnection.getConnection();
		Car car = null;
		try {
			String sql = "select* from car where licence_plate_number = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, lpn);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				car = new Car();
				car.setColor(rs.getString(3));
				car.setCompany(rs.getString(1));
				car.setDateOfPurchase(rs.getDate(4));
				car.setEngineCapacity(rs.getString(6));
				car.setModel(rs.getString(2));
				car.setPlateNumber(rs.getString(7));
				car.setPrice(rs.getDouble(5));
				car.setSeatingCapacity(rs.getInt(8));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		req.setAttribute("car", car);
		req.getRequestDispatcher("/edit-car.jsp").forward(req, resp);
	}
}
