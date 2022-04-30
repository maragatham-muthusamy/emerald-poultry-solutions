<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp"/>
<body>
	<jsp:include page="menu.jsp"/>
    <div class="login-page">
      <div class="login-register">
        <form class="register-form">
          <input type="text" placeholder="name"/>
          <input type="password" placeholder="password"/>
          <input type="text" placeholder="email address"/>
          <button>create</button>
          <p class="message">Already registered? <a href="#">Sign In</a></p>
        </form>
        <form class="login-form">
          <input type="text" placeholder="Username"/>
          <input type="password" placeholder="Password"/>
          <button>login</button>
          <p class="message">Not registered? <a href="#">Create an account</a></p>
        </form>
      </div>
    </div>
  </body>
<jsp:include page="footer.jsp"/>
