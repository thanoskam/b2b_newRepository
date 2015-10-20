<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/layout/taglib.jsp" %>

<form:form commandName="user" cssClass="form-horizontal registrationForm">

	<c:if test="${param.success eq true}">
		<div class="alert alert-success">Registration successful!</div>
	</c:if>

	<div class="form-group">
		<label for="username" class="col-sm-2 control-label">Name:</label>
		<div class="col-sm-10">
			<form:input path="username" cssClass="form-control" />
			<form:errors path="username"/>
		</div>
	</div>
	<div class="form-group">
		<label for="email" class="col-sm-2 control-label">Email:</label>
		<div class="col-sm-10">
			<form:input path="email" cssClass="form-control" />
			<form:errors path="email"/>
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Password:</label>
		<div class="col-sm-10">
			<form:password path="password" cssClass="form-control" />
			<form:errors path="password"/>
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Password: again</label>
		<div class="col-sm-10">
			<input type="password" name="password_again" id="password_again" class="form-control" />
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-10">
			<input type="submit" value="Save" Class="btn btn-lg btn-primary" />
		</div>
	</div>
</form:form>

<script type="text/javascript">
$(document).ready(function() {
	$(".registrationForm").validate(
			{
				rules: {
					username: {
						required : true,
						minlength : 3,
						remote : {
							url: "<spring:url value='/register/available.html'/>",
							type: "get",
							data: {
								username: function() {
									return $("#username").val();
								}
							}
						}
					},
					email: {
						required : false,
						email : true
					},
					password: {
						required : true,
						minlength : 5
					},
					password_again: {
						required : true,
						minlength : 5,
						equalTo: "#password"
					},
				},
				highlight: function(element) {
					$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
				},
				unhighlight: function(element) {
					$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
				},
				messages: {
					username: {
						remote: "Such username already exists!"
					}
				}
		});
});
</script>

<!-- http://getbootstrap.com/css/ => validation states -->