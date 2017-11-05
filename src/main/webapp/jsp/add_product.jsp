<%@ page import="net.mayweather.model.Manufacturer" %>
<%@ page import="java.util.List" %>
<%@ page import="net.mayweather.DaoSingleton" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Add Product</title>
</head>
<body>
<%!
private List<Manufacturer> manufacturers = DaoSingleton.getINSTANCE().getManufacturerDAO().getAll();
%>
<h2>add new product</h2>
<form action="addP" method="POST">
    <p>Input Name</p>
    <input type="text" name="name" />
    <br>
    <p>Input Price</p>
    <input type="text" name="price"/>
    <br>
    <p>Choice Manufacturer</p>
    <select name="manufacturer"/>
    <%for(Manufacturer manufacturer: manufacturers){
        out.println("<option value=\"" + manufacturer.getName() +"\">"
            + manufacturer.getName() + "</option>");
    }%>
    </select>
    <br>
    <br>
    <input type="submit" value="Add"/>
</form>

</body>
</html>
