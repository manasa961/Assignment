package com.test.cms.contoller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.test.cms.dbconn.DBConnection;
import com.test.cms.model.Car;

@WebServlet("/search")
public class SearchServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 resp.setContentType("application/json;charset=UTF-8");
		
		String model = req.getParameter("model");
		String yop = req.getParameter("yop");
		String color = req.getParameter("color");
		String lowPrice = req.getParameter("low");
		
		String criteria = "WHERE ";
		if(model != null && model != "")
			criteria += "model LIKE '%" + model + "%' OR ";
		if(yop != null && yop != "")
			criteria += "date(date_of_purchase)='" + yop + "' OR ";
		if(color != null && color != "")
			criteria += "color LIKE '%" + color + "%' OR ";
		if(lowPrice != null && lowPrice != "")
			criteria += "price BETWEEN " + 0.0 + " AND " + Double.parseDouble(lowPrice) ;

		criteria = criteria.endsWith("OR ")?criteria.substring(0, criteria.length()-3): criteria;
		
		Connection conn = DBConnection.getConnection();
		List<Car> cars = new ArrayList<Car>();
		try {
			String sql = "SELECT * FROM car " + criteria;
			System.out.println(sql);
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
		
		String table = "";
		DecimalFormat df = new DecimalFormat("#.##");
		for(Car car:cars)
		{
			System.out.println(car);
			table += "<tr><td>" + car.getCompany() + "</td>";
			table += "<td>" + car.getModel() + "</td>";
			table += "<td>" + car.getColor() + "</td>";
			table += "<td>" + car.getDateOfPurchase() + "</td>";
			table += "<td><i class='fa fa-inr text-danger'></i>" + df.format(car.getPrice()) + "</td>";
			table += "<td>" + car.getEngineCapacity() + "</td>";
			table += "<td>" + car.getPlateNumber() + "</td>";
			table += "<td>" + car.getSeatingCapacity() + "</td></tr>";
		}
		resp.getWriter().write(table);
	}
}
