<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/layout/taglib.jsp" %>

<!-- EVENTS !!! -->
<script type="text/javascript">
$(document).ready(function() {
//	when user tries to delete blogs
	$(".triggerRemove").click(function(e) {
		e.preventDefault();
		$("#modalRemove .removeBtn").attr("href", $(this).attr("href"));
		$("#modalRemove").modal();
	});
});
</script>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>user name</th>
			<th>full name</th>
			<th>email name</th>
			<th>company</th>
			<th>company country</th>
			<th>phone1</th>
			<th>phone2</th>
			<th class="text-center">enabled</th>
			<th>operations</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>
					<a href="<spring:url value="/users/${user.id}.html"/>">
						${user.username}
					</a>
				</td>
				<td>
					${user.fullName}
				</td>
				<td>
					${user.email}
				</td>
				<td>
					${user.company.name}
				</td>
				<td>
					${user.company.country.name}
				</td>
				<td>
					${user.phone1}
				</td>
				<td>
					${user.phone2}
				</td>
				<td  class="text-center">
					<c:choose>
					    <c:when test="${user.enabled}">
					       <span class="glyphicon glyphicon-ok gc_green"></span>
					    </c:when>
					    <c:otherwise>
					        <span class="glyphicon glyphicon-remove gc_red"></span>
					    </c:otherwise>
					</c:choose>
				</td>
				<td>
				<a href="<spring:url value="/users/remove/${user.id}.html" />" class="btn btn-danger triggerRemove">remove</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Remove user</h4>
      </div>
      <div class="modal-body">
        Realy remove?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <a href="" class="btn btn-danger removeBtn">Remove</a>
      </div>
    </div>
  </div>
</div>
