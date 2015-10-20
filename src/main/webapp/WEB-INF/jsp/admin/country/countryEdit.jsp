<%@ include file="/WEB-INF/layout/taglib.jsp"%>

<%-- <form:form commandName="country" cssClass="form-horizontal">

	<div class="form-group">
		<label for="name" class="col-sm-3 control-label">Name:</label>
		<div class="col-sm-9">
			<form:input path="name" cssClass="form-control" />
		</div>
	</div>

	<div class="form-group">
		<label for="name" class="col-sm-3 control-label">Code:</label>
		<div class="col-sm-9">
			<form:input path="code" cssClass="form-control" />
		</div>
	</div>

	<form:hidden path="id" />
	<input type="submit" class="btn btn-primary" value="Save">


</form:form> --%>


<form:form commandName="country" cssClass="form-horizontal countryUpdate">
	<form:hidden path="id" />

	<div class="col-sm-6">
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Code:</label>
			<div class="col-sm-10">
				<form:input path="code" cssClass="form-control" />
				<form:errors path="code" />
			</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Name:</label>
			<div class="col-sm-10">
				<form:input path="name" cssClass="form-control" />
				<form:errors path="name" />
			</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Currency:</label>
			<div class="col-sm-10">
				<select class="form-control" name="currencyId" id="currencyId">
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

		<div>
			<a href="<spring:url value="/countryListing.html"/> "
				class="btn btn-default">Cancel</a> <input type="submit"
				class="btn btn-primary" value="Save" />
		</div>
	</div>
</form:form>

<script type="text/javascript">
$(document).ready(function() {
	$(".countryUpdate").validate(
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
