<%@page import="java.util.List"%>
<%@page import="com.test.cms.model.Car"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vie All Car</title>
<%@ include file="links.jsp" %>
</head>
<body>
	<%@ include file="header.jsp" %>
	<% List<Car> cars = (List<Car>)request.getAttribute("cars"); %>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12 pt-5">
				<div class="card">
					<div class="p-2">
						<h4 class="text-center">All Cars</h4>
							<% if(request.getAttribute("msg")!= null && request.getAttribute("msg").toString().contains("successfully")){ %>
								<div class="alert alert-success" role="alert">
								  <strong>Success! </strong><%=request.getAttribute("msg") %>
								</div>
							<%}else if(request.getAttribute("msg")!= null && request.getAttribute("msg").toString().contains("Error")){ %>
								<div class="alert alert-danger" role="alert">
								  <%=request.getAttribute("msg") %>
								</div>
							<%} %>
							<table	class="table">
								<thead class="thead-dark">
									<tr>
										<th>Company</th>
										<th>Model</th>
										<th>Color</th>
										<th>Date Of Purchase</th>
										<th>Price</th>
										<th>Engine Capacity</th>
										<th>Number Plate</th>
										<th>Seating Capacity</th>
										<th>Edit/Delete</th>
									</tr>
								</thead>
								<tbody>
									<% for(Car car: cars){ %>
										<tr>
											<td><%=car.getCompany() %></td>
											<td><%=car.getModel() %></td>
											<td><%=car.getColor() %></td>
											<td><%=car.getDateOfPurchase() %></td>
											<td><%=car.getPrice() %></td>
											<td><%=car.getEngineCapacity() %></td>
											<td><%=car.getPlateNumber() %></td>
											<td><%=car.getSeatingCapacity() %></td>
											<td>
												<a href="editCar?lpn=<%=car.getPlateNumber() %>" class="btn btn-primary"><i class="fa fa-edit"></i></a>
												<a href="deleteCar?lpn=<%=car.getPlateNumber() %>" class="btn btn-danger float-right"><i class="fa fa-trash"></i></a>
											</td>
										</tr>
									<%} %>
								</tbody>
							</table>
						</div>
				</div>
				<div class="pb-5"></div>
				<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
			</div>			
		</div>
	</div>
</body>
</html>