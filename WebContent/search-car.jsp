<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Car</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<%@ include file="links.jsp" %>

</head>
<body>
	<%@ include file="header.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col-md-12 pt-5">
				<div class="card">
					<div class="pl-3 pr-3">
						<h4 class="text-center">Search Car</h4>
						<form id="form">
						<table>
							<tr>
								<td>
									<div class="form-group">	
							     		<label>Model:</label>
							     		<input type="text" id="model" placeholder="Search by Model" class="form-control">
							     	</div>
						     	</td>
						     	<td>
						     		<div class="form-group">
							     		<label>YOP:</label>
							     		<input type="date" id="yop" class="form-control">
							     	</div>
							     </td>
							     <td>
							     	<div class="form-group ">
							     		<label>Color:</label>
							     		<input type="text" id="color" placeholder="Search by Color" class="form-control">
							     	</div>	
							     </td>
							     <td>
							     	<div class="form-group">
							     		<label>Price</label>
							     		<input type="text" id="low" placeholder="0 to Price" class="form-control">
							     	</div>
							     </td>
							     <td>
							    	 <div class="form-group pt-4">
								     	<label class="pt-0 mt-0">&nbsp;</label>
								     	<button id="search" class="btn btn-primary"><i class="fa fa-search"></i> Search</button>	
							     	</div>
							     </td>
							     <td>
							    	 <div class="form-group pt-4">
								     	<label class="pt-0 mt-0">&nbsp;</label>
								     	<button id="clear" class="btn btn-danger"><i class="fa fa-trash"></i> Clear Data</button>	
							     	</div>
							     </td>
						     </tr>
						</table>
						</form>
						<div class="pt-3" id="result"></div>
					</div>
				</div>
				<div id="table">
					<div id="result"></div>
				</div>				
			</div>			
		</div>
	</div>
	<script>
$(document).ready(function(){
	$("#table").hide();
  $("#search").click(function(){
	var model = document.getElementById("model").value;
	var yop = document.getElementById("yop").value;
	var color = document.getElementById("color").value;
	var low = document.getElementById("low").value;
	
	var data = "";
	if(model != undefined && model != '')
	  data += "model="+ model;
	if(yop != undefined  && yop != '')
	  data += "&yop="+ yop;
	if(color != undefined  && color != '')
	  data += "&color="+ color;
    if(low != undefined  && low != '')
	  data += "&low="+ low;

	if(data != '' && data.charAt(0) == '&')
		data = data.substring(1,data.length);

	if(data != '')
	{
		// Creating the XMLHttpRequest object
	    var request = new XMLHttpRequest();
	    request.open("GET", "http://localhost:8080/Car_Management_System/search?" + data);
	    request.onreadystatechange = function() {
	        if(this.readyState === 4 && this.status === 200) {
	        	var table = "";
		       if(this.responseText != undefined && this.responseText != ""){
		    	   	table = "<table class='table'> <thead class='thead-primary'> <tr> <th>Company</th> <th>Model</th> <th>Color</th> <th>Date Of Purchase</th> <th>Price</th> <th>Engine Capacity</th> <th>Number Plate</th> <th>Seating Capacity</th> </tr> </thead> <tbody>";		        
					table += this.responseText
					table += "</tbody></table>";
					
			   }else{
					table = "<h5 class='text-danger text-center'>No Data Found</h5>";
				}
		       $('input:text').focus(
		    		    function(){
		    		        $(this).val('');
		    		    });
		        $("#result").html(table);
	            $("#table").show();
	        }
	    };
	    request.send();
	} 
	
  });

  $('#clear').click(function(){
	  $('#form input[type="text"]').val('');
});
});
</script>
</body>
</html>