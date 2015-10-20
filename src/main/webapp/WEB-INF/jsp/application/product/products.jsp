<%@ include file="/WEB-INF/layout/taglib.jsp"%>

<h1>Product List</h1>

<form class="form-inline criteriaForm" action="/products.html" method="post">
	<div class="form-group">
		<label class="sr-only" for="code">Product code</label> <input type="text"
			class="form-control" name="code" id="code" placeholder="Product code">
	</div>
	<div class="form-group">
		<select class="form-control" name="brandId" id="brandId">
			<option selected="selected" value="">- Select Brand -</option>
			<c:forEach items="${brandList}" var="iteratedBrand">
				<option
					${iteratedBrand.id == selectedBrandId ? 'class="active" selected' : ''}
					value="${iteratedBrand.id}">${iteratedBrand.name}</option>
			</c:forEach>
		</select>
	</div>
	<div class="form-group">
		<select class="form-control" name="catId" id="catId">
			<option selected="selected" value="">- Select Category -</option>
			<c:forEach items="${categoryTranslatedList}" var="iteratedCategory">
				<option
					${iteratedCategory.categoryId == selectedCategoryId ? 'class="active" selected' : ''}
					value="${iteratedCategory.categoryId}">${iteratedCategory.categoryName}</option>
			</c:forEach>
		</select>
	</div>
	<div class="form-group">
		<label class="sr-only" for="descr">Description</label> <input type="text"
			class="form-control" name="descr" id="descr" placeholder="Description">
	</div>
	<div class="form-group" >
		<label class="sr-only" for="dfv1">Atr#1</label> 
		<input type="text"
			class="form-control" name="dfv1" id="dfv1" placeholder="Atr#1">
	</div>
	<div class="form-group">
		<label class="sr-only" for="dfv1">Atr#2</label> <input type="text"
			class="form-control" name="dfv2" id="dfv2" placeholder="Atr#2">
	</div>
	<div class="checkbox">
	    <label for="discount">
	      <input type="checkbox"> Has Discount
	    </label>
	</div>
	<div class="checkbox">
	    <label for="preorder">
	      <input type="checkbox"> Preorders > 0
	    </label>
	</div>
	<button type="submit" class="btn btn-default">Search</button>
</form>

<%--  	<c:forEach items="${categoryTranslatedList}" var="maps">
     		category entry : ${maps.categoryId}  ${maps.categoryName} <br />
	</c:forEach>
 --%>
 
<br>


<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th class="text-center">Code</th>
			<th>Description</th>
			<th>Atr#1</th>
			<th>Atr#2</th>
			<th class="text-right">Price</th>
			<th>Barcode</th>
			<th>Category</th>
			<th>Brand</th>
		</tr>
	</thead>
	<tbody>


		<c:forEach items="${simpleListOfMap}" var="maps">
			<tr>
				<td class="text-center"><a
					href="<spring:url value="/products/${maps.id}.html"/>">
						${maps.code} </a></td>
				<td>${maps.descr}</td>
				<td>${maps.dfv1}</td>
				<td>${maps.dfv2}</td>
				<td class="text-right">${maps.priceWls}</td>
				<td>${maps.barecode}</td>
				<td>${maps.category}</td>
				<td>${maps.brand}</td>
			</tr>

		</c:forEach>


	</tbody>
<%--  	<c:forEach items="${simpleListOfMap}" var="maps">
		<c:forEach items="${maps}" var="product">
      		${product.key} ${product.value} <br />
		</c:forEach>
	</c:forEach>
 --%> 

</table>


<%-- 	<c:forEach items="${productsListHashMap}" var="products">
	 PRODUCT : ${products['code'].value}
	<c:forEach items="${products}" var="element">
	  ${element.key} : ${element.value} <br>
    </c:forEach>
		
    </c:forEach>
 --%>
 

<%-- 	<c:forEach items="${productsListHashMap}" var="products" >
 		${products}
 		<c:forEach items="${products}" var="element">
	 		${element.key} ${element.value} <br />
    	</c:forEach>
    </c:forEach>
 --%>
    	
<%-- 	<c:forEach items="${simpleHashMap}" var="products" >
	  ${products.key} : ${products.value}<br>
     </c:forEach>
 --%>
<%-- 	<c:forEach items="${test}" var="country" >
	  ${country.id}, ${country.code}, ${country.name}<br>
     </c:forEach>
 --%>
 
<!--  <script type="text/javascript">
$(document).ready(function() {
	$(".criteriaForm").validate(
			{
				rules: {
					username: {
						required : false,
						minlength : 3,
					},
					email: {
						required : false,
						email : true
					},
					password: {
						required : false,
						minlength : 5
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
</script> -->
 
