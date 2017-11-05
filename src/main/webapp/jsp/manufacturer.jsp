
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manufacturer</title>
</head>
<body>
<h1>Manufacturer:</h1>
<br/>
<p>ID: <%=request.getAttribute("manufacturerId")%>
    <br/>
<p>Name: <%=request.getAttribute("name")%>
    <br/>
    <form action="listM">
<p><input type="submit" value="ShowAllManufacturer"></p>
</form>
</body>
</html>
