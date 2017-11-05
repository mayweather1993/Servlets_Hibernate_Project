package net.mayweather.controller.Manufacturer;

import net.mayweather.DaoSingleton;
import net.mayweather.model.Manufacturer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class ManufacturerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        UUID uuid = UUID.fromString(req.getParameter("manufacturer_id"));

        Manufacturer manufacturer = DaoSingleton.getINSTANCE().getManufacturerDAO().getById(uuid);

        req.setAttribute("manufacturerId", manufacturer.getId());
        req.setAttribute("name", manufacturer.getName());

        req.getRequestDispatcher("/jsp/manufacturer.jsp").forward(req, resp);
    }
}
