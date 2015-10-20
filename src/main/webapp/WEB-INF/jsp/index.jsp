<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file="../layout/taglib.jsp" %>


<security:authorize access="!isAuthenticated()">
	<div id="control_panel_notA">
		<div class="row">
			<div class="col-xs-12">
				<h3>Welcome to our business to business online shop</h3>
				Please, login to continue

			</div>
		</div>
	</div>
</security:authorize>
<security:authorize access="isAuthenticated()">
	<security:authorize access="hasRole('ROLE_SADMIN')" var="isSAdmin" />
	<security:authorize access="hasRole('ROLE_ADMIN')" var="isAdmin" />
	<security:authorize access="hasRole('ROLE_CUSTOMER')" var="isCustomer" />
	<security:authorize access="hasRole('ROLE_SELLER')" var="isSeller" />
	
	<c:choose>
	  <c:when test="${isSAdmin}">
	  	<%@ include file="/WEB-INF/jsp/home/superAdminRoleHome.jsp" %>
	  </c:when>
	  <c:when test="${isAdmin}">
	    <%@ include file="/WEB-INF/jsp/home/adminRoleHome.jsp" %>
	  </c:when>
	  <c:when test="${isCustomer}">
	    <%@ include file="/WEB-INF/jsp/home/customerRoleHome.jsp" %>
	  </c:when>
	  <c:when test="${isSeller}">
	    <%@ include file="/WEB-INF/jsp/home/sellerRoleHome.jsp" %>
	  </c:when>
	  <c:otherwise>
	    <%@ include file="/WEB-INF/jsp/home/userRoleHome.jsp" %>
	  </c:otherwise>
	</c:choose>


<%-- 	<security:authorize access="hasRole('ROLE_ADMIN')"> --%>
<%-- 		<%@ include file="/WEB-INF/jsp/home/adminRoleHome.jsp" %> --%>
<%-- 	</security:authorize> --%>
<%-- 	<security:authorize access="hasRole('ROLE_SADMIN')"> --%>
<%-- 		<%@ include file="/WEB-INF/jsp/home/managerRoleHome.jsp" %> --%>
<%-- 	</security:authorize> --%>
<%-- 	<security:authorize access="hasRole('ROLE_CUSTOMER')"> --%>
<%-- 		<%@ include file="/WEB-INF/jsp/home/managerRoleHome.jsp" %> --%>
<%-- 	</security:authorize> --%>
<%-- 	<security:authorize access="hasRole('ROLE_SELLER')"> --%>
<%-- 		<%@ include file="/WEB-INF/jsp/home/managerRoleHome.jsp" %> --%>
<%-- 	</security:authorize> --%>
<%-- 	<security:authorize access="hasRole('ROLE_MANAGER')"> --%>
<%-- 		<%@ include file="/WEB-INF/jsp/home/managerRoleHome.jsp" %> --%>
<%-- 	</security:authorize> --%>
</security:authorize>
