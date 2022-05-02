<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
	<div class="listusercontainer">
		<div class="content">
			<div class="left">
			</div>

			<div class="middle">
				<table>
					<tr>
						<th>Firstname</th>
						<th>Lastname</th>
						<th>Phone</th>
						<th>Email</th>
						<th>Username</th>
						<th>Action</th>
					</tr>
					
					<!-- loop over and print our users -->
					<c:forEach var="tempUser" items="${users}">
						<!-- construct an "update" link with user id -->
						<c:url var="updateLink" value="/user/update">
							<c:param name="userId" value="${tempUser.id}" />
						</c:url>					
	
						<!-- construct an "delete" link with customer id -->
						<c:url var="deleteLink" value="/user/delete">
							<c:param name="userId" value="${tempUser.id}" />
						</c:url>
						
						<tr>
							<td> ${tempUser.firstName} </td>
							<td> ${tempUser.lastName} </td>
							<td> ${tempUser.phone} </td>
							<td> ${tempUser.email} </td>
							<td> ${tempUser.username} </td>
							
							<td>
								<!-- display the update link -->
								<a href="${updateLink}">Update</a> | <a href="${deleteLink}"
								   onclick="if (!(confirm('Are you sure you want to delete this user?'))) return false">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="right">
			</div>
		</div>
		<br>
		<br>
		<div class="content">
			<div class="left">
			</div>
			<input type="button" value="Add User" onclick="window.location.href='add'; return false;" class="addupd-button"/>
			<div class="right">
			</div>
		</div>
	</div>
</body>
<jsp:include page="footer.jsp"/>
</html>


