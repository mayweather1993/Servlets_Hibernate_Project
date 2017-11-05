package net.mayweather.controller.Product;

import net.mayweather.DaoSingleton;
import net.mayweather.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

public class AddProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/add_product.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");

        try {
            String name = req.getParameter("name");
            BigDecimal price = new BigDecimal(Integer.valueOf(req.getParameter("price")));
            String manufacturerName = req.getParameter("manufacturer");


            //create new Product from post params
            Product product = new Product();
            product.setName(name);
            product.setPrice(price);
            product.setManufacturer(DaoSingleton.getINSTANCE().getManufacturerDAO().getByName(manufacturerName));

            //add product to DB
            DaoSingleton.getINSTANCE().getProductDAO().save(product);

            //show some feedback for user
            resp.getWriter().println("product added!<br><br>");
            resp.getWriter().println("<br>");
            //show link to see all product
            String link = "<form action=\"listP\">\n" +
                    "<p><input type=\"submit\" value=\"ShowAllProduct\"></p>\n" +
                    "</form>";
            resp.getWriter().println(link);

        } catch (Exception e) {
            //show more error for user
            resp.getWriter().println("Error in adding Product");
        }
    }
}
