<%@ include file="../layout/taglib.jsp" %>

<tilesx:useAttribute name="breadcrumbPairs"/>

	<div id="breadcrumb">
		<div class="row">
			<div class="col-xs-12">
				<ol class="breadcrumb">

				<li><a href="<spring:url value="/admin/home.html"/>">Home</a></li>

				<c:set var="itemPairs" value="${fn:split(breadcrumbPairs, '|')}" />

				<c:forEach var="item" items="${itemPairs}">

					<c:set var="item" value="${fn:replace(item, '[', '')}" />
					<c:set var="item" value="${fn:replace(item, ']', '')}" />
					<c:set var="itemParts" value="${fn:split(item, ',')}" />


					<c:choose>
						<c:when test="${fn:length(itemParts)==2}">
							<li><a
								href='<spring:url value="${itemParts[1]}"></spring:url>'>${itemParts[0]}</a></li>
						</c:when>
						<c:otherwise>
							<li class="active"><c:out value="${itemParts[0]}"></c:out></li>
						</c:otherwise>
					</c:choose>

				</c:forEach>

				</ol>
			</div>
		</div>
	</div>
	
<%-- split example	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<title>Using JSTL Functions</title>
</head>
<body>

<c:set var="string1" value="This is first String."/>
<c:set var="string2" value="${fn:split(string1, ' ')}" />
<c:set var="string3" value="${fn:join(string2, '-')}" />

<p>String (3) : ${string3}</p>

<c:set var="string4" value="${fn:split(string3, '-')}" />
<c:set var="string5" value="${fn:join(string4, ' ')}" />

<p>String (5) : ${string5}</p>

</body>
</html> --%>

