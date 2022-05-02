<!DOCTYPE html>
<html lang="en">
<head>
	<jsp:include page="header.jsp"/>
</head>
<body>
	<jsp:include page="menu.jsp"/>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    <div class="logincontainer">
      <div class="loginform">
        <form:form class="login-form">
		  <c:if test="${param.error != null}">
			<div class="alert alert-danger col-xs-offset-1 col-xs-10">
				Invalid username or password.
			</div>
		  </c:if>
          <input type="text" placeholder="Username"/>
          <input type="password" placeholder="Password"/>
          <button>login</button>
          <p class="message">Not registered? <a href="${pageContext.request.contextPath}/signup">Create an account</a></p>
        </form:form>
      </div>
    </div>
</body>
<jsp:include page="footer.jsp"/>
</html>