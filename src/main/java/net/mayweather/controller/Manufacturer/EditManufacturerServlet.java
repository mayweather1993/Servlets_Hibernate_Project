package net.mayweather.controller.Manufacturer;

import net.mayweather.DaoSingleton;
import net.mayweather.model.Manufacturer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class EditManufacturerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");

        String manufacturerIdStr = req.getParameter("manufacturer_id");
        UUID manufacturerId = UUID.fromString(manufacturerIdStr);

        String name = req.getParameter("name");

        Manufacturer manufacturer = DaoSingleton.getINSTANCE().getManufacturerDAO().getById(manufacturerId);
        manufacturer.setName(name);

        DaoSingleton.getINSTANCE().getManufacturerDAO().update(manufacturer);

        //Show some feedback for user
        resp.getWriter().println("Manufacturer updated!");
        resp.getWriter().println("<br>");
        resp.getWriter().println("<br>");

        //Show link to see all manufacturers
        String link = " <form action=\"listM\">\n" +
                "   <p><input type=\"submit\" value=\"ShowAllManufacturer\"></p>\n" +
                "  </form>";
        resp.getWriter().println(link);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String manufacturerIdStr = req.getParameter("manufacturer_id");
        UUID manufacturerId = UUID.fromString(manufacturerIdStr);

        //Get manufacturer data
        Manufacturer manufacturer = DaoSingleton.getINSTANCE().getManufacturerDAO().getById(manufacturerId);
        String name = manufacturer.getName();

        req.setAttribute("manufacturerId", manufacturerId);
        req.setAttribute("name", name);

        req.getRequestDispatcher("/jsp/edit_manufacturer.jsp").forward(req, resp);

    }
}
