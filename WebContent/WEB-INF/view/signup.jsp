<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="header.jsp" />
</head>
<body>
	<jsp:include page="menu.jsp" />
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<div class="contactuscontainer">
		<form:form method="post" modelAttribute="userForm">
			<div class="input-group">
				<input type="text" placeholder="Firstname" id="firstname"
					name="firstName"> <span id="name-error"></span>
			</div>

			<div class="input-group">
				<input type="text" placeholder="Lastname" id="lastname"
					name="lastName"> <span id="name-error"></span>
			</div>

			<div class="input-group">
				<input type="tel" placeholder="Phone" id="phone" name="phone">
				<span id="name-error"></span>
			</div>

			<div class="input-group">
				<input type="email" placeholder="E-mail" id="email" name="email">
				<span id="email-error"></span>
			</div>

			<br>

			<div class="input-group">
				<input type="text" placeholder="Username" id="username"
					name="username"> <span id="email-error"></span>
			</div>

			<div class="input-group">
				<input type="password" placeholder="New password" id="password"
					name="password">
				<div id="message-error"></div>
			</div>

			<div class="input-group">
				<input type="password" placeholder="Confirm new password"
					id="confirmpassword" name="confirmpassword">
				<div id="message-error"></div>
			</div>

			<button>Register</button>
			<span id="submit-error"></span>
		</form:form>
	</div>
</body>
<jsp:include page="footer.jsp" />
</html>
