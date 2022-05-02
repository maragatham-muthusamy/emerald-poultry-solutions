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
				<h2>User Manager</h2>
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
								<td><label>First name:</label></td>
								<td><form:input path="firstName" placeholder="Firstname"/></td>
							</tr>
						
							<tr>
								<td><label>Last name:</label></td>
								<td><form:input path="lastName" placeholder="Lastname"/></td>
							</tr>

							<tr>
								<td><label>Phone:</label></td>
								<td><form:input path="phone" placeholder="Phone"/></td>
							</tr>

							<tr>
								<td><label>Email:</label></td>
								<td><form:input path="email" placeholder="Email"/></td>
							</tr>

							<tr>
								<td><label>Username:</label></td>
								<td><form:input path="username" placeholder="Username"/></td>
							</tr>

							<c:if test="${adding == true}">
								<tr>
									<td><label>Password:</label></td>
									<td><form:input type="password" path="password" placeholder="Password"/></td>
								</tr>
								<tr>
									<td><label>Confirm Password:</label></td>
									<td><input type="password" id="confirmpassword" placeholder="Confirm password"/></td>
								</tr>
					        </c:if>
							<c:if test="${adding != true}">
								<tr style='visibility:collapse'>
									<td><label>Password:</label></td>
									<td><form:input type="password" path="password" /></td>
								</tr>
								<tr>
									<td><label>Password:</label></td>
									<td><input placeholder="(Unchanged)" readonly/></td>
								</tr>
					        </c:if>
							<tr>
								<td><label></label></td>
								<td>
									<input type="submit" value="Save" class="save" 
										<c:if test="${adding == true}"> onclick="return comparePassword();"</c:if>/> &nbsp;&nbsp;&nbsp;
									<a href="${pageContext.request.contextPath}/user/list">Back to List</a>
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
