<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Car</title>
<%@ include file="links.jsp" %>
</head>
<body>
	<%@ include file="header.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6 pt-5">
				<div class="card">
					<div class="p-2">
						<h4 class="text-center">Add Car</h4>
						<form action="addCar" method="post" class="pl-5 pr-5">
							<% if(request.getAttribute("msg")!= null && request.getAttribute("msg").toString().contains("successfully")){ %>
								<div class="alert alert-success" role="alert">
								  <strong>Success! </strong><%=request.getAttribute("msg") %>
								</div>
							<%}else if(request.getAttribute("msg")!= null && request.getAttribute("msg").toString().contains("Error")){ %>
								<div class="alert alert-danger" role="alert">
								  <%=request.getAttribute("msg") %>
								</div>
							<%} %>
							<div class="form-group">
								<label>Company:</label>
								<input type="text" name="company" placeholder="Enter Company Name" class="form-control" required="">
							</div>	
							<div class="form-group">
								<label>Model:</label>
								<input type="text" name="model" placeholder="Enter Model" class="form-control" required="">
							</div>		
							<div class="form-group">
								<label>Color:</label>
								<input type="text" name="color" placeholder="Enter Color" class="form-control" required="">
							</div>			
							<div class="form-group">
								<label>Date Of Purchase:</label>
								<input type="date" name="dop" class="form-control" required="">
							</div>		
							<div class="form-group">
								<label>Price:</label>
								<input type="text" name="price" placeholder="Enter Car Price" class="form-control" required="">
							</div>	
							<div class="form-group">
								<label>Engine Capacity:</label>
								<input type="text" name="engineCapacity" placeholder="Enter Car Price" class="form-control" required="">
							</div>	
							<div class="form-group">
								<label>Licence Plate Number:</label>
								<input type="text" name="lpn" placeholder="Enter Licence Plate Number" class="form-control" required="">
							</div>
							<div class="form-group">
								<label>Seating Capacity:</label>
								<input type="number" name="seating" placeholder="Enter Seating Capacity" class="form-control" required="">
							</div>	
							<input type="submit" value="Add Car" class="btn btn-primary btn-block">			
						</form>
					</div>
				</div>
				<div class="pb-5"></div>
			</div>			
		</div>
	</div>
</body>
</html>