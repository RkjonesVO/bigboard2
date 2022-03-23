<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Edit Player</title>
	<link href="/css/bootstrap.css"      rel="stylesheet">
	<link href="/css/custom.css"      rel="stylesheet">
	<link href="/css/main.css"      rel="stylesheet">
</head>

<body>

 	<div class="form-container">
 	
 	<h1>Edit Player</h1>
 	
	<form:form method="POST" modelAttribute="player" commandName="player" class="form-horizontal" action="/bigboard2/editsave">


<div class="row">
			<div class="form-group col-md-12">
				<div class="col-md-7">
					<form:hidden path="id"  class="form-control input-sm"/>
					<div class="has-error">
						
					</div>
					</div>
			</div>
		</div>

<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="position">Position</label>
				<div class="col-md-7" class="form-control input-sm">
					<form:radiobutton path="position" value="QB" />QB 
	    			<form:radiobutton path="position" value="RB" />RB
	    			<form:radiobutton path="position" value="WR" />WR
	    			<form:radiobutton path="position" value="TE" />TE
	    			<form:radiobutton path="position" value="ATH" />ATH
					<div class="has-error">
						<form:errors path="position" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="Name">Name</label>
				<div class="col-md-7">
					<form:input type="text" path="Name" id="Name" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="Name" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="team">Team</label>
				<div class="col-md-7">
					<form:select path="team" id="team" class="form-control input-sm">
				        <form:option value="">Select Team</form:option>
			    	    <form:options items="${teams}" />
				    </form:select>
					<div class="has-error">
						<form:errors path="team" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="points">2021 Points</label>
				<div class="col-md-7">
					<form:input type="text" path="points" id="points" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="points" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>		

		
		<div class="row">
			<div class="form-actions floatRight">
				<input type="submit" value="Update" class="btn btn-primary btn-sm">
			</div>
		</div>
	</form:form>
	</div>
</body>
</html>