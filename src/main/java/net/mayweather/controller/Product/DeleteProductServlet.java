package net.mayweather.controller.Product;

import net.mayweather.DaoSingleton;
import net.mayweather.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class DeleteProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        String productIdStr = req.getParameter("product_id");
        UUID productId = UUID.fromString(productIdStr);

        //Get product data
        Product product = DaoSingleton.getINSTANCE().getProductDAO().getById(productId);
        DaoSingleton.getINSTANCE().getProductDAO().delete(product);

        req.getRequestDispatcher("/jsp/delete_product.jsp").forward(req, resp);
    }
}
