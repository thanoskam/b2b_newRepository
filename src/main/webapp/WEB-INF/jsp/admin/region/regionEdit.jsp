<%@ include file="/WEB-INF/layout/taglib.jsp"%>

<form:form commandName="region" cssClass="form-horizontal regionUpdate">
	<form:hidden path="id" />

	<div class="col-sm-6">
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Country:</label>
			<div class="col-sm-10">
				<select class="form-control" name="countryId" id="countryId">
					<option selected="selected" value="">- Select Country -</option>
					<c:forEach items="${countryList}" var="iteratedCountry">
						<option
							${iteratedCountry.id == selectedCountryId ? 'class="active" selected' : ''}
							value="${iteratedCountry.id}">${iteratedCountry.name}</option>
					</c:forEach>
				</select>
				<form:errors path="country" />
			</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Name:</label>
			<div class="col-sm-10">
				<form:input path="name" cssClass="form-control" />
				<form:errors path="name" />
			</div>
		</div>

		<div>
			<a href="<spring:url value="/regionListing.html"/> "
				class="btn btn-default">Cancel</a> <input type="submit"
				class="btn btn-primary" value="Save" />
		</div>
	</div>
</form:form>

<script type="text/javascript">
$(document).ready(function() {
	$(".regionUpdate").validate(
			{
				rules: {
					name: {
						required : true,
						minlength : 1,
					},
					countryId: {
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
