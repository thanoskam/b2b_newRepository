<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>
    
<link rel="stylesheet" href="../../resources/css/signin.css" type="text/css" />

<c:url value="/login" var="loginAction"/>


<div class="container">
	<div class="row">
		<div class="col-sm-6 col-md-4 col-md-offset-4">

			<form class="form-signin" role="form" action="${loginAction}" method="POST">

				<div class="form-group">
					<label for="inputName" class="sr-only">Name</label> <input
						type="text" name="username" id="inputName" class="form-control"
						placeholder="Name" required autofocus>
				</div>


				<div class="form-group">
					<label for="inputPassword" class="sr-only">Password</label> <input
						type="password" name="password" id="inputPassword"
						class="form-control" placeholder="Password" required>
				</div>

				<div class="form-group">
					<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
				</div>

			</form>
		</div>
	</div>
</div>