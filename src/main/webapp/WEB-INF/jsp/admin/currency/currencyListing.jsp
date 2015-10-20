<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/layout/taglib.jsp" %>
 
<h1>Currency List</h1>
<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-md" data-toggle="modal" data-target="#myModal">
  New currency
</button>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Name</th>
			<th>Symbol</th>
			<th>operations</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${currencyList}" var="currency">
			<tr>
				<td>
					${currency.name}
				</td>
				<td>
					${currency.symbol}
				</td>
				<td>
					<a class="gc_grey" href="<spring:url value="/currency/${currency.id}/edit.html"/>">
					  <span class="glyphicon glyphicon-edit gc_blue"></span> Edit
					</a>	
					<security:authorize access="hasRole('ROLE_SADMIN')">
						<a class="gc_grey" href="<spring:url value="/currency/remove/${currency.id}.html"/>">
							<span class="glyphicon glyphicon-remove gc_red"></span> Remove
						</a>
					</security:authorize>
<%-- 					<a href="<spring:url value="/currency/remove/${currency.id}.html"/> "class="btn btn-danger triggerRemove">remove</a> --%>
				</td>

			</tr>
					</c:forEach>
	</tbody>
</table>


<form:form commandName="currency" cssClass="form-horizontal currencyForm">
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">New currency</h4>
      </div>
      <div class="modal-body">

		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Name:</label>
			<div class="col-sm-10">
				<form:input path="name" cssClass="form-control" />
				<form:errors path="name"/>
			</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Symbol:</label>
			<div class="col-sm-10">
				<form:input path="symbol" cssClass="form-control" />
<%-- 				<form:errors path="symbol"/> --%>
			</div>
		</div>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <input type="submit" class="btn btn-primary" value="Save" />
      </div>
    </div>
  </div>
</div>
</form:form>

<!-- EVENTS !!! -->
<script type="text/javascript">
$(document).ready(function() {
	$(".currencyUpdate").validate(
			{
				rules: {
					name: {
						required : true,
						minlength : 1,
					},
				},
				highlight: function(element) {
					$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
				},
				unhighlight: function(element) {
					$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
				}
		});
});
</script>

