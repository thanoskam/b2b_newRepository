<%@ include file="/WEB-INF/layout/taglib.jsp" %>
 
<h1>City List</h1>

<!-- criteria Form -->
<form class="form-inline criteriaForm" action="/city/search.html" method="post">
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
 	<div class="form-group">
		<select class="form-control" name="regionId" id="regionId">
			<option selected="selected" value="">- Select Region -</option>
			<c:forEach items="${regionList}" var="iteratedRegion">
				<option
					${iteratedRegion.id == selectedRegionId ? 'class="active" selected' : ''}
					value="${iteratedRegion.id}">${iteratedRegion.name}</option>
			</c:forEach>
		</select>
	</div>
  	<div class="form-group">
		<select class="form-control" name="stateId" id="stateId">
			<option selected="selected" value="">- Select State -</option>
			<c:forEach items="${stateList}" var="iteratedState">
				<option
					${iteratedState.id == selectedStateId ? 'class="active" selected' : ''}
					value="${iteratedState.id}">${iteratedState.name}</option>
			</c:forEach>
		</select>
	</div>
	<!-- Search button -->
	<button type="submit" class="btn btn-default" name="search" value="search">Search</button>
</form>

<br>

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-md" data-toggle="modal" data-target="#newModal">
  New city
</button>


<table class="table table-bordered table-hover table-striped">
 	<thead>
		<tr>
			<th>Country</th>
			<th>Region</th>
			<th>State</th>
			<th>City</th>
			<th>Operations</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${cityListOfMap}" var="maps">
			<tr>
				<td>
					${maps.country}
				</td>
				<td>
					${maps.region}
				</td>
				<td>
					${maps.state}
				</td>
				<td>
					${maps.name}
				</td>
				<td>
					<a class="gc_grey" href="<spring:url value="/city/${maps.id}/edit.html"/>">
					  <span class="glyphicon glyphicon-edit gc_blue"></span> Edit
					</a>	
					<security:authorize access="hasRole('ROLE_SADMIN')">
						<a class="gc_grey" href="<spring:url value="/city/remove/${maps.id}.html"/>">
							<span class="glyphicon glyphicon-remove gc_red"></span> Remove
						</a>
					</security:authorize>
<%-- 					<a href="<spring:url value="/city/remove/${city.id}.html"/> "class="btn btn-danger">remove</a> --%>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<!-- add city begins -->
<form:form commandName="city" cssClass="form-horizontal cityNew" action="/city/add.html"  method="post">
<!-- Modal -->
<form:hidden path="id" />

<div class="modal fade" id="newModal" tabindex="-1" role="dialog" aria-labelledby="newModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="newModalLabel">New city</h4>
      </div>
      <div class="modal-body">
<!-- class="hidden"   -->
	 	<div  class="hidden" class="form-group">
			<label for="name" class="col-sm-2 control-label">Country:</label>
			<div class="col-sm-10">
			<select class="form-control" name="countryId" id="countryId">
				<option selected="selected" value="">- Select Country -</option>
				<c:forEach items="${countryList}" var="iteratedCountry">
					<option
						${iteratedCountry.id == selectedCountryAddId ? 'class="active" selected' : ''}
						value="${iteratedCountry.id}">${iteratedCountry.name}</option>
				</c:forEach>
			</select>
			</div>
		</div>
	 	<div  class="hidden" class="form-group">
			<label for="name" class="col-sm-2 control-label">Region:</label>
			<div class="col-sm-10">
			<select class="form-control" name="regionId" id="regionId">
				<option selected="selected" value="">- Select Region -</option>
				<c:forEach items="${regionList}" var="iteratedRegion">
					<option
						${iteratedRegion.id == selectedRegionAddId ? 'class="active" selected' : ''}
						value="${iteratedRegion.id}">${iteratedRegion.name}</option>
				</c:forEach>
			</select>
			</div>
 		</div>
 		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">State:</label>
			<div class="col-sm-10">
			<select class="form-control" name="stateId" id="stateId" >
				<option selected="selected" value="">- Select State -</option>
				<c:forEach items="${stateList}" var="iteratedState">
					<option
						${iteratedState.id == selectedStateAddId ? 'class="active" selected' : ''}
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
				<form:errors path="name"/>
			</div>
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <input type="submit" class="btn btn-primary" name="save" value="save" />
      </div>
    </div>
  </div>
</div>
</form:form>
<!-- add city ends -->

<!-- EVENTS !!! -->
<script type="text/javascript">
$(document).ready(function() {
	$(".cityNew").validate(
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

