<%@ include file="/WEB-INF/layout/taglib.jsp" %>
 
<h1>Region List</h1>

<!-- criteria Form -->
<form class="form-inline criteriaForm" action="/region/search.html" method="post">
 	<div class="form-group">
		<select class="form-control" name="countryId" id="countryId">
			<option selected="selected" value="">- Select Country -</option>
			<c:forEach items="${countryList}" var="iteratedCountry">
				<option
					${iteratedCountry.id == selectedCountryId ? 'class="active" selected' : ''}
					value="${iteratedCountry.id}">${iteratedCountry.name}</option>
			</c:forEach>
		</select>
	</div>
	<!-- Search button -->
	<button type="submit" class="btn btn-default" name="search" value="search">Search</button>
</form>

<br>

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-md" data-toggle="modal" data-target="#newModal">
  New region
</button>

<br>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Country</th>
			<th>Region</th>
			<th>Operations</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${regionListOfMap}" var="maps">
			<tr>
				<td>
					${maps.country}
				</td>
				<td>
					${maps.name}
				</td>
				<td>
					<a class="gc_grey" href="<spring:url value="/region/${maps.id}/edit.html"/>">
					  <span class="glyphicon glyphicon-edit gc_blue"></span> Edit
					</a>	
					<security:authorize access="hasRole('ROLE_SADMIN')">
						<a class="gc_grey" href="<spring:url value="/region/remove/${maps.id}.html"/>">
							<span class="glyphicon glyphicon-remove gc_red"></span> Remove
						</a>
					</security:authorize>
<%-- 					<a href="<spring:url value="/region/remove/${maps.id}.html"/> "class="btn btn-danger">remove</a> --%>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<!-- add region begins -->
<form:form commandName="region" cssClass="form-horizontal regionNew" action="/region/add.html"  >
<!-- Modal -->
<form:hidden path="id" />
<div class="modal fade" id="newModal" tabindex="-1" role="dialog" aria-labelledby="newModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="newModalLabel">New region</h4>
      </div>
      <div class="modal-body">

 		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Country:</label>
			<div class="col-sm-10">
			<select class="form-control" name="countryId" id="countryId" >
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
				<form:errors path="name"/>
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
<!-- add region ends -->

<!-- EVENTS !!! -->
<script type="text/javascript">
$(document).ready(function() {
	$(".regionNew").validate(
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

