<%@ include file="/WEB-INF/layout/taglib.jsp"%>

<form:form commandName="currency" cssClass="form-horizontal currencyUpdate">
	<form:hidden path="id" />

	<div class="col-sm-6">
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Name:</label>
			<div class="col-sm-10">
				<form:input path="name" cssClass="form-control" />
				<form:errors path="name" />
			</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Symbol:</label>
			<div class="col-sm-10">
				<form:input path="symbol" cssClass="form-control" />
				<form:errors path="symbol" />
			</div>
		</div>

		<div>
			<a href="<spring:url value="/currencyListing.html"/> "
				class="btn btn-default">Cancel</a> <input type="submit"
				class="btn btn-primary" value="Save" />
		</div>
	</div>
</form:form>

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
