<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<body>
<h3>Hi ${userName}</h3>
<h1>Welcome to Emerald Enterprise Management Solutions</h1>

<% response.sendRedirect("customer/list"); %>
</body>
