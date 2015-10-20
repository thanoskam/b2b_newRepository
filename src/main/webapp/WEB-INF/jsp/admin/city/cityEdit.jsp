<%@ include file="/WEB-INF/layout/taglib.jsp"%>

<form:form commandName="city" cssClass="form-horizontal cityUpdate">
	<form:hidden path="id" />

	<div class="col-sm-6">
	 	<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Country:</label>
			<div class="col-sm-10">
			<select class="form-control" name="countryId" id="countryId">
				<option selected="selected" value="">- Select Country -</option>
				<c:forEach items="${countryList}" var="iteratedCountry">
					<option
						${iteratedCountry.id == selectedCountryUpdId ? 'class="active" selected' : ''}
						value="${iteratedCountry.id}">${iteratedCountry.name}</option>
				</c:forEach>
			</select>
			</div>
		</div>
		 <div class="form-group">
			<label for="name" class="col-sm-2 control-label">Region:</label>
			<div class="col-sm-10">
				<select class="form-control" name="regionId" id="regionId">
					<option selected="selected" value="">- Select Region -</option>
					<c:forEach items="${regionList}" var="iteratedRegion">
						<option
							${iteratedRegion.id == selectedRegionUpdId ? 'class="active" selected' : ''}
							value="${iteratedRegion.id}">${iteratedRegion.name}</option>
					</c:forEach>
				</select>
			</div>
		</div>
 		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">State:</label>
			<div class="col-sm-10">
				<select class="form-control" name="stateId" id="stateId">
					<option selected="selected" value="">- Select State -</option>
					<c:forEach items="${stateList}" var="iteratedState">
						<option
							${iteratedState.id == selectedStateUpdId ? 'class="active" selected' : ''}
							value="${iteratedState.id}">${iteratedState.name}</option>
					</c:forEach>
				</select>
				<form:errors path="state" />
			</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">City:</label>
			<div class="col-sm-10">
				<form:input path="name" cssClass="form-control" />
				<form:errors path="name" />
			</div>
		</div>

		<div>
			<a href="<spring:url value="/cityListing.html"/> "
				class="btn btn-default">Cancel</a> <input type="submit"
				class="btn btn-primary" value="Save" />
		</div>
	</div>
</form:form>

<script type="text/javascript">
$(document).ready(function() {
	$(".cityUpdate").validate(
			{
				rules: {
					name: {
						required : true,
						minlength : 1,
					},
					stateId: {
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
