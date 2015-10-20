<%@ include file="/WEB-INF/layout/taglib.jsp" %>
 
<h1>Country List</h1>
<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-md" data-toggle="modal" data-target="#newModal">
  New country
</button>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Code</th>
			<th>Name</th>
			<th>Currency</th>
			<th>Branch</th>
			<th>Operations</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${countryList}" var="country">
			<tr>
				<td>
					${country.code}
				</td>
				<td>
					${country.name}
				</td>
				<td>
					${country.currency.name}
				</td>
				<td>
					${country.branch.name}
				</td>
				<td>
					<a class="gc_grey" href="<spring:url value="/country/${country.id}/edit.html"/>">
					  <span class="glyphicon glyphicon-edit gc_blue"></span> Edit
					</a>	
					<security:authorize access="hasRole('ROLE_SADMIN')">
						<a class="gc_grey" href="<spring:url value="/country/remove/${country.id}.html"/>">
							<span class="glyphicon glyphicon-remove gc_red"></span> Remove
						</a>
					</security:authorize>
<%-- 					<a href="<spring:url value="/country/remove/${country.id}.html"/> "class="btn btn-danger">remove</a> --%>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<!-- add country begins -->
<form:form commandName="country" cssClass="form-horizontal countryNew">
<!-- Modal -->
<form:hidden path="id" />
<div class="modal fade" id="newModal" tabindex="-1" role="dialog" aria-labelledby="newModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="newModalLabel">New country</h4>
      </div>
      <div class="modal-body">

		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Code:</label>
			<div class="col-sm-10">
				<form:input path="code" cssClass="form-control" />
				<form:errors path="code"/>
			</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Name:</label>
			<div class="col-sm-10">
				<form:input path="name" cssClass="form-control" />
				<form:errors path="name"/>
			</div>
		</div>
 		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Currency:</label>
			<div class="col-sm-10">
			<select class="form-control" name="currencyId" id="currencyId" >
				<option selected="selected" value="">- Select Currency -</option>
				<c:forEach items="${currencyList}" var="iteratedCurrency">
					<option
						${iteratedCurrency.id == selectedCurrencyId ? 'class="active" selected' : ''}
						value="${iteratedCurrency.id}">${iteratedCurrency.name}</option>
				</c:forEach>
			</select>
			<form:errors path="currency" />
			</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Branch:</label>
			<div class="col-sm-10">
			<select class="col-sm-2 form-control" name="branchId" id="branchId">
				<option selected="selected" value="">- Select Branch -</option>
				<c:forEach items="${branchList}" var="iteratedBranch">
					<option
						${iteratedBranch.id == selectedBranchId ? 'class="active" selected' : ''}
						value="${iteratedBranch.id}">${iteratedBranch.name}</option>
				</c:forEach>
			</select>
			<form:errors path="branch" />
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
<!-- add country ends -->

<!-- EVENTS !!! -->
<script type="text/javascript">
$(document).ready(function() {
	$(".countryNew").validate(
			{
				rules: {
					code: {
						required : true,
						minlength : 1,
					},
 					name: {
						required : true,
						minlength : 1,
					},
 					currencyId: {
						required : true,
						minlength : 1,
					},
 					branchId: {
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

