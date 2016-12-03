 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ page import="demo.*" %>

<!-- Casting the session to Cart object -->
<% Cart cart = (Cart)session.getAttribute("cart"); %>

<!-- The ? will is standard java, will help handle crashes when cookies are disabled on the web browser by displaying error-->
Items in cart: <%=cart == null ? "error" : cart.getTotalItem() %>

<!-- URL Rewriting: Supporting Sessions without Cookies  -->

<!-- encodeUrl(request.getContectPath()) will encode the URL in such a way that even if cookies are disabled on the browser 
it will put the session ID in the URL that will keep tracking the session. This will have to be done for every URL the 
user will click on. This is extremely efficient when deploying the Web App onto a server as the initial context path is 
likely to change which would result in an HTTP Error. This will handle this issue.-->
<a href="<%= response.encodeUrl(request.getContextPath() + "/showcart2.jsp") %>">Click here to go to showcart2</a>

</body>
</html>