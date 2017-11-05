package net.mayweather.controller.Product;

import net.mayweather.DaoSingleton;
import net.mayweather.model.Manufacturer;
import net.mayweather.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;

public class EditProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");

        String productIdStr = req.getParameter("product_id");
        UUID productId = UUID.fromString(productIdStr);

        String name = req.getParameter("name");
        BigDecimal price = new BigDecimal(req.getParameter("price"));
        Manufacturer manufacturer = DaoSingleton.getINSTANCE().getManufacturerDAO().getByName(req.getParameter("manufacturer"));

        Product product = DaoSingleton.getINSTANCE().getProductDAO().getById(productId);
        product.setName(name);
        product.setPrice(price);
        product.setManufacturer(manufacturer);

        DaoSingleton.getINSTANCE().getProductDAO().update(product);

        //Show some feedback for user
        resp.getWriter().println("Product updated!");
        resp.getWriter().println("<br><br>");

        //Show link to see all product
        String link = "<form action=\"listP\">\n" +
                "<p><input type=\"submit\" value=\"ShowAllProduct\"></p>\n" +
                "</form>";
        resp.getWriter().println(link);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productIdStr = req.getParameter("product_id");
        UUID productId = UUID.fromString(productIdStr);

        //Get product data
        Product product = DaoSingleton.getINSTANCE().getProductDAO().getById(productId);
        String name = product.getName();
        BigDecimal price = product.getPrice();
        String mName = product.getManufacturer().getName();

        req.setAttribute("productId", productId);
        req.setAttribute("name", name);
        req.setAttribute("price", price);
        req.setAttribute("manufacturerName", mName);

        req.getRequestDispatcher("/jsp/edit_product.jsp").forward(req, resp);

    }
}
