<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp"/>
<body>
	<jsp:include page="menu.jsp"/>
	
	
    <div class="login-page">
      
        <form class="login-form">
          <input type="text" value="username"/>
          <input type="password" placeholder="Password"/>
          <button>login</button>
          <p class="message">Not registered? <a href="#">Create an account</a></p>
        </form>
      </div>
    
  </body>



