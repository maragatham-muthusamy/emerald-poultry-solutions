<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="header.jsp" />
</head>
<body>
	<jsp:include page="menu.jsp" />
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<div class="contactuscontainer">
		<form:form>
			<div class="input-group">
				<label>Fullname</label> <input type="text"
					placeholder="Enter your name" id="contact-name"
					onkeyup="validateName()"> <span id="name-error"></span>
			</div>

			<div class="input-group">
				<label>Phone</label> <input type="tel" placeholder="123 456 7890"
					id="contact-phone" onkeyup="validatePhone()"> <span
					id="phone-error"></span>
			</div>

			<div class="input-group">
				<label>E-Mail</label> <input type="email" placeholder="Enter Email"
					id="contact-email" onkeyup="validateEmail()"> <span
					id="email-error"></span>
			</div>

			<div class="input-group">
				<label>Your Message</label>
				<textarea rows="5" placeholder="Enter your Meassage"
					id="contact-message" onkeyup="validateMessage()"></textarea>
				<div class="message" id="message-error"></div>
			</div>

			<input class="button" type="submit" value="Submit"
				onclick="return validateForm()" />
			<span id="submit-error"></span>
			<span id="submit-response">${result}</span>
		</form:form>
	</div>
</body>
<jsp:include page="footer.jsp" />
</html>
