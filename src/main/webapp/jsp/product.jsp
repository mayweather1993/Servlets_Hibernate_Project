<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<h1>Product:</h1>
<br/>
<p>ID: <%=request.getAttribute("productId")%>
<br/>
<p>Name: <%=request.getAttribute("name")%>
<br/>
<p>Price: <%=request.getAttribute("price")%>
<br/>
<p>Manufacturer: <%=request.getAttribute("manufacturer")%>
<br/>
<p>
    <form action="listP">
<p><input type="submit" value="ShowAllProduct"></p>
</form>
</body>
</html>
