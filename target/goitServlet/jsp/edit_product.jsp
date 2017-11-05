<%@ page import="net.mayweather.DaoSingleton" %>
<%@ page import="net.mayweather.model.Manufacturer" %>
<%@ page import="java.util.List" %>
<%@ page import="net.mayweather.model.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<%!
    private List<Manufacturer> manufacturers = DaoSingleton.getINSTANCE().getManufacturerDAO().getAll();
%>
<h2>Edit product</h2>
<form action="editP" method="post">
    <input type="hidden" name="product_id" value="<%=request.getAttribute("productId")%>">
    <p>Input new Name</p>
    <input type="text" name="name" value="<%=request.getAttribute("name")%>">
    <p>Input new Price</p>
    <input type="text" name="price" value="<%=request.getAttribute("price")%>">
    <p>Choice manufacturer</p>
    <select name="manufacturer"/>
    <%for(Manufacturer manufacturer: manufacturers){
        out.println("<option ");
        if(manufacturer.getName().equals(request.getAttribute("manufacturerName")))
            out.println("selected");
        out.println(" value=\"" + manufacturer.getName() +"\">"
                + manufacturer.getName() + "</option>");
    }%>
    </select>
    <br>
    <br>
    <input type="submit" value="update"/>
</form>

</body>
</html>
