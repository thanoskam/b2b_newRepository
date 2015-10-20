<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>
  
<!DOCTYPE html>
<html>
<head>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

  <!--  Custom CSS -->
  <link rel="stylesheet" href="/resources/css/styles.css" type="text/css" />
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>

  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

  <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.min.js"></script>

  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
  <!-- get authentication object principal -->
  <security:authorize access="isAuthenticated()">
	<security:authentication var="principal" property="principal" />
  </security:authorize>

<title><tiles:getAsString name="title" /></title>
</head>
<body>


	<tilesx:useAttribute name="current"/>

	<div class="container col-xs-10 col-xs-offset-1">

		<!-- Static navbar -->
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar"> <span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
					</button>
					<!-- MENU HEADER starts -->
					<security:authorize access="! isAuthenticated()">
						<a class="navbar-brand" href='<spring:url value="/" />'>B2B</a>
					</security:authorize>
					<security:authorize access="isAuthenticated()">
						<a class="navbar-brand" href='<spring:url 
						value="/" />'>B2B <font color="DarkBlue"><b>Welcome, <c:out value="${principal.username}" /></b></font></a>
					</security:authorize>
					<!-- MENU HEADER ends -->
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<!-- HOME -->
						<li class="${current == 'index' ? 'active' : ''}"><a href='<spring:url value="/" />'>Home</a></li>
						<security:authorize access="hasAnyRole('ROLE_SADMIN', 'ROLE_ADMIN')">
							<!-- LOCAL DROPDOWN MENU -->
							<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
								aria-expanded="false">Local<span class="caret"></span></a>
								<ul class="dropdown-menu">
									<!-- CURRENCY -->
									<li class="${current == 'currency' ? 'active' : ''}"><a href='<spring:url value="/currencyListing.html"/>'>Currencies</a></li>
									<!-- COUNTRY -->
									<li class="${current == 'country' ? 'active' : ''}"><a href='<spring:url value="/countryListing.html"/>'>Countries</a></li>
									<!-- REGION -->
									<li class="${current == 'region' ? 'active' : ''}"><a href='<spring:url value="/regionListing.html"/>'>Regions</a></li>
									<!-- STATE -->
									<li class="${current == 'state' ? 'active' : ''}"><a href='<spring:url value="/stateListing.html"/>'>States</a></li>
									<!-- CITY -->
									<li class="${current == 'city' ? 'active' : ''}"><a href='<spring:url value="/cityListing.html"/>'>Cities</a></li>
								</ul>
							</li>
						</security:authorize>
						<security:authorize access="hasAnyRole('ROLE_SADMIN', 'ROLE_CUSTOMER', 'ROLE_SELLER')">
							<!-- PRODUCTS -->
							<li class="${current == 'products' ? 'active' : ''}"><a href='<spring:url value="/products.html"/>'>Products</a></li>
							<!-- DWONLOADS -->
							<li><a href="#">Downloads</a></li>
							<!-- COMPLAINTS -->
							<li><a href="#">Complaints</a></li>
						</security:authorize>

						<security:authorize access="hasAnyRole('ROLE_SADMIN', 'ROLE_ADMIN')">
							<!-- USERS - COMPANIES MENU -->
							<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
								aria-expanded="false">Users - Companies<span class="caret"></span></a>
								<ul class="dropdown-menu">
									<!-- COMPANY -->
									<li class="${current == 'company' ? 'active' : ''}"><a href='<spring:url value="/companyListing.html"/>'>Companies</a></li>
									<!-- USER -->
									<li class="${current == 'user' ? 'active' : ''}"><a href='<spring:url value="/userListing.html"/>'>Users</a></li>
								</ul>
							</li>
						</security:authorize>

						<!-- TUTORIAL EXAMPLE -->
						<!-- USERS -->
						<li class="${current == 'users' ? 'active' : ''}"><a href='<spring:url value="/users.html"/>'>users</a></li>
						<!-- REGISTER -->
						<li class="${current == 'register' ? 'active' : ''}"><a href='<spring:url value="/register.html"/>'>Register</a></li>

					</ul>
					<!-- RGHT MENU -->
					<ul class="nav navbar-nav navbar-right">
						<security:authorize access="isAuthenticated()">
							<!-- MY ACCOUNT DROPDOWN MENU -->
							<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
								aria-expanded="false">My Account <span class="caret"></span></a>
								<ul class="dropdown-menu">
									<!-- ACCOUNT DETAILS -->
									<li class="${current == 'account' ? 'active' : ''}"><a href='<spring:url value="/account.html"/>'>Account Details</a></li>
									<security:authorize access="hasAnyRole('ROLE_SADMIN', 'ROLE_CUSTOMER')">
										<!-- ORDERS -->
										<li><a href="#">Orders</a></li>
									</security:authorize>
								</ul></li>
							<security:authorize access="hasAnyRole('ROLE_SADMIN', 'ROLE_CUSTOMER')">
								<!-- BASKET -->
								<li><a href="#">Basket</a></li>
							</security:authorize>
						</security:authorize>
						<security:authorize access="! isAuthenticated()">
							<!-- LOGIN -->
							<li class="${current == 'login' ? 'active' : ''}"><a href='<spring:url value="/login.html"/>'>Login</a></li>
						</security:authorize>
						<security:authorize access="isAuthenticated()">
							<!-- LOGOUT -->
							<li><a href='<spring:url value="/logout"/>'>Logout</a></li>
						</security:authorize>
<%-- 						<li class="${current == 'test' ? 'active' : ''}"><a href='<spring:url value="/test.html"/>'>Test!</a></li> --%>
					</ul>
				</div>
				<!-- /.nav-collapse -->
			</div>
			<!--/.container-fluid -->
		</nav>


		<tiles:insertAttribute name="body" />

		<br> <br>
		<center>
			<tiles:insertAttribute name="footer" />
		</center>

	</div>

</body>

</html>