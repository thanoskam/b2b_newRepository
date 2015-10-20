<%@ include file="/WEB-INF/layout/taglib.jsp"%>

<!-- Info -->

<div class="row">
	<div class="col-xs-6">
		<div id="company_info" class="panel panel-default">
			<div class="panel-body">

				<div class="row">
					<div class="col-sm-10">
						<div class="page-header section_header_cp">
							<h3>Company Info</h3>
						</div>


						<div class="info_per_line">
							<div class="row">
								<div class="col-xs-3 text-right"><span><strong>company Name :</strong></span></div>
								<div class="col-xs-9 text-left">${company.name}</div>
							</div>
							<br>
							<div class="row">
								<div class="col-xs-3 text-right"><span><strong>country :</strong></span></div>
								<div class="col-xs-9 text-left">${company.country.name}</div>
							</div>
							<br>
						</div>
					</div>

				</div> <!-- row -->
			</div> <!-- panel body -->
		</div> <!-- panel -->
		<div class="row">
			<div class="col-xs-12 text-left">
				<a id="back_btn"
					href='<spring:url value="/companyListing.html"></spring:url>'
					class="btn btn-default btn-md centered" role="button">Back</a>
			</div>
		</div>		
	</div>
</div>

<div>
	<br />
	
<!-- EVENTS !!! -->
<script type="text/javascript">
$(document).ready(function() {
// 	when the page is loaded
	$('.nav-tabs a:first').tab('show'); // Select first tab
/* //	when user tries to delete blogs
	$(".triggerRemove").click(function(e) {
		e.preventDefault();
		$("#modalRemove .removeBtn").attr("href", $(this).attr("href"));
		$("#modalRemove").modal();
	});
	$(".blogForm").validate(
			{
				rules: {
					name: {
						required : true,
						minlength : 1
					},
					url: {
						required : true,
						url : true
					},
				},
				highlight: function(element) {
					$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
				},
				unhighlight: function(element) {
					$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
				}			
		});
 */
 });
</script>

	<!-- Nav tabs -->
	<ul class="nav nav-tabs" role="tablist">
		<li><a href="#addressList" data-toggle="tab">Address</a></li>
		<li><a href="#userList" data-toggle="tab">Person</a></li>
	</ul>

	<!-- Tab panes -->
	<div class="tab-content">
			<!-- Company Addresses -->
			<div class="tab-pane" id="addressList">
				<h4>Address List</h4>
				<!-- Button trigger modal -->
				<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#newAddressModal">
				  New Address
				</button>
				<!-- table -->
				<table class="table table-bordered table-hover table-striped">
					<thead>
						<tr>
							<th>Address Type</th>
							<th>Operation Type</th>
							<th>City Name</th>
							<th>Address</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${company.companyAddressList}" var="item">
							<tr>
								<td>${item.addressType.name}</td>
								<td>${item.operationType.name}</td>
								<td>${item.city.name}</td>
								<td>${item.address}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			
			<!-- Company Users -->
			<div class="tab-pane" id="userList">
				<h4>Person List</h4>
				<table class="table table-bordered table-hover table-striped">
					<thead>
						<tr>
							<th>User Name</th>
							<th>User full Name</th>
							<th>email</th>
							<th>Phone 1</th>
							<th>Phone 2</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${company.userList}" var="item">
							<tr>
								<td>${item.username}</td>
								<td>${item.fullname}</td>
								<td>${item.email}</td>
								<td>${item.phone1}</td>
								<td>${item.phone2}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

	</div>
	
</div>

<!-- Modal for new company address -->

<form:form commandName="companyAddress" cssClass="form-horizontal addressForm" action="/company/addAddress.html"  method="post">

<!-- Modal -->
<div class="modal fade" id="newAddressModal" tabindex="-1" role="dialog" aria-labelledby="newAddressModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="newAddressModalLabel">New Address</h4>
      </div>
      <div class="modal-body">

		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">Address:</label>
			<div class="col-sm-10">
				<form:input path="address" cssClass="form-control" />
				<form:errors path="address"/>
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


