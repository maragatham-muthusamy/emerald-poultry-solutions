<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html lang="en">
<head>
	<jsp:include page="header.jsp"/>
</head>
<body>
    <jsp:include page="menu.jsp"/>
	<div class="user-wrapper">
		<div class="left">
		</div>
		<div class="middle">
			<div class="user-header">
				<h2>Production Details</h2>
			</div>
		</div>
		<div class="right">
		</div>
	</div>

	<div class="addupdcontainer">
		<div class="content">
			<div class="left">
			</div>
			<div class="middle">
				<form:form action="save" modelAttribute="addupd" method="POST">
					<!-- need to associate this data with user id -->
					<form:hidden path="id"/>
					<table>
						<tbody>
							<tr>
								<td><label>Item</label></td>
								<td><form:input path="itemId" placeholder="itemid"/></td>
							</tr>
						
							<tr>
								<td><label>Price</label></td>
								<td><form:input path="price" placeholder="price"/></td>
							</tr>

							<tr>
								<td><label>Quantity</label></td>
								<td><form:input path="quantity" placeholder="quantity"/></td>
							</tr>

							<tr>
								<td><label>Date</label></td>
								<td><form:input path="date" placeholder="MM/DD/YYYY"/></td>
							</tr>
							<tr>
								<td><label></label></td>
								<td>
									<input type="submit" value="Save" class="save"/> &nbsp;&nbsp;&nbsp;
									<a href="${pageContext.request.contextPath}/production/list">Back to List</a>
								</td>
							</tr>
						</tbody>
					</table>
				</form:form>
			</div>
			<div class="right">
			</div>
		</div>
	</div>
</body>
<jsp:include page="footer.jsp"/>
</html>