package com.test.cms.contoller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.cms.dbconn.DBConnection;
import com.test.cms.model.Car;

@WebServlet("/getAllCars")
public class GetCarsServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Car> cars = new ArrayList();
		
		Connection conn = DBConnection.getConnection();
		
		try {
			String sql = "select* from car";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Car car = new Car();
				car.setColor(rs.getString(3));
				car.setCompany(rs.getString(1));
				car.setDateOfPurchase(rs.getDate(4));
				car.setEngineCapacity(rs.getString(6));
				car.setModel(rs.getString(2));
				car.setPlateNumber(rs.getString(7));
				car.setPrice(rs.getDouble(5));
				car.setSeatingCapacity(rs.getInt(8));
				
				cars.add(car);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		req.setAttribute("cars", cars);
		req.getRequestDispatcher("/view-car.jsp").forward(req, resp);
	}
}
