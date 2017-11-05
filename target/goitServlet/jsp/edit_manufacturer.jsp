<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Manufacturer</title>
</head>
<body>
<%!

%>
<h2>Edit manufacturer</h2>
<form action="editM" method="POST">
    <p>Input new Name</p>
    <input type="text" name="name" value="<%=request.getAttribute("name")%>"/>
    <br>
    <input type="hidden" name="manufacturer_id" value="<%=request.getAttribute("manufacturerId")%>" />
    <input type="submit" value="update"/>
</form>

</body>
</html>
