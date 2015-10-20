<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/layout/taglib.jsp" %>
 
<h2>${user.username}</h2>
<h2>${user.company.name}</h2>

<br/><br/>

<!-- EVENTS !!! -->
<script type="text/javascript">
$(document).ready(function() {
// 	when the page is loaded
	$('.nav-tabs a:first').tab('show'); // Select first tab
//	when user tries to delete blogs
	$(".triggerRemove").click(function(e) {
		e.preventDefault();
		$("#modalRemove .removeBtn").attr("href", $(this).attr("href"));
		$("#modalRemove").modal();
	});
});
</script>

  <!-- Nav tabs -->
  <ul class="nav nav-tabs" role="tablist">
<c:forEach items="${user.blogList}" var="blog">
    <li><a href="#blog_${blog.id}" data-toggle="tab">${blog.name}</a></li>
</c:forEach>
  </ul>

  <!-- Tab panes -->
	<div class="tab-content">
		<c:forEach items="${user.blogList}" var="blog">
			<div class="tab-pane" id="blog_${blog.id}">
				<h1>${blog.name}</h1>
				<p>
				
				<a href="<spring:url value="/blog/remove/${blog.id}.html" />" class="btn btn-danger triggerRemove">remove blog</a>
				
				${blog.url}</p>

				<table class="table table-bordered table-hover table-striped">
					<thead>
						<tr>
							<th>Title</th>
							<th>Link</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${blog.itemList}" var="item">
							<tr>
								<td>${item.title}</td>
								<td>${item.link}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:forEach>
	</div>


<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Remove blog</h4>
      </div>
      <div class="modal-body">
        Realy remove?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <a href="" class="btn btn-danger removeBtn">Remove</a>
      </div>
    </div>
  </div>
</div>

<!-- http://getbootstrap.com/javascript/#tabs -->
<!-- http://getbootstrap.com/javascript/ => search modal with -->
