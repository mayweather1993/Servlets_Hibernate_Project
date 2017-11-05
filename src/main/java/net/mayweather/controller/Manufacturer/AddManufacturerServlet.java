package net.mayweather.controller.Manufacturer;

import net.mayweather.DaoSingleton;
import net.mayweather.model.Manufacturer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddManufacturerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/add_manufacturer.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");

        try {
            String name = req.getParameter("name");

            //create new Manufacturer from post params
            Manufacturer manufacturer = new Manufacturer();
            manufacturer.setName(name);

            //add manufacturer to DB
            DaoSingleton.getINSTANCE().getManufacturerDAO().save(manufacturer);

            //show some feedback for user
            resp.getWriter().println("manufacturer added!<br><br>");
            resp.getWriter().println("<br>");
            //show link to see all manufacturer
            String link = "<form action=\"listM\">\n" +
                    "<p><input type=\"submit\" value=\"ShowAllManufacturer\"></p>\n" +
                    "</form>";
            resp.getWriter().println(link);

        } catch (Exception e) {
            //show more error for user
            resp.getWriter().println("Error in adding manufacturer");
        }
    }
}
