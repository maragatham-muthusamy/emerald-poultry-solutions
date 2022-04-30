<jsp:include page="header.jsp"/>
<body>
	<jsp:include page="menu.jsp"/>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <div class = "contactuscontainer">
        <form:form method="post" modelAttribute="userForm">
            <div class ="input-group">
                <label>Firstname</label>
                <input type = "text" placeholder ="Enter your firstname" id="firstname" name="firstName">
                <span id="name-error"></span>
            </div>

            <div class ="input-group">
                <label>Lastname</label>
                <input type = "text" placeholder ="Enter your lastname" id="lastname" name="lastName">
                <span id="name-error"></span>
            </div>

            <div class ="input-group">
                <label>E-Mail</label>
                <input type = "email" placeholder ="Enter your E-mail" id="email" name="email">
                <span id="email-error"></span>
            </div>

            <div class ="input-group">
                <label>Password</label>
                <input type = "password" placeholder ="Enter your new password" id="password" name="password">
                <div id="message-error"></div>
            </div>

            <div class ="input-group">
                <label>Confirm Password</label>
                <input type = "password" placeholder ="Reenter your new password" id="password" name="confirmpassword">
                <div id="message-error"></div>
            </div>

            <button>Register</button>
            <span id="submit-error" ></span>
        </form:form>
    </div>
</body>
<jsp:include page="footer.jsp"/>
