package net.mayweather.controller.Manufacturer;

import net.mayweather.DaoSingleton;
import net.mayweather.model.Manufacturer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListAllManufacturerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");

        //Get all Manufacturer
        List<Manufacturer> manufacturers = DaoSingleton.getINSTANCE().getManufacturerDAO().getAll();

        //Print all manufacturers as link
        for (Manufacturer manufacturer : manufacturers) {
            String manufacturerText = manufacturer.getName();

            String editLinkManufacturer = "<a href=\"/editM?manufacturer_id=" + manufacturer.getId() + "\">EDIT</a>";

            String deleteLinkManufacturer = "<a href=\"/deleteM?manufacturer_id=" + manufacturer.getId() + "\">DELETE</a>";

            String showLinkManufacturer = "<a href=\"/manufacturer?manufacturer_id=" + manufacturer.getId() + "\">SHOW</a>";

            String finalLink = manufacturerText + " " + editLinkManufacturer + " " + deleteLinkManufacturer + " " + showLinkManufacturer;


            resp.getWriter().println(finalLink);
            resp.getWriter().println("<br><br>");
        }
        String addManufacturerLink = "<form action=\"addM\">\n" +
                "<p><input type=\"submit\" value=\"AddNewManufacturer\"></p>";

        String welcomePageText = "<a href=\"/welcome\">WelcomePage</a>";

        resp.getWriter().println(addManufacturerLink + "<br>" + welcomePageText);

    }

}
