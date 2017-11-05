package net.mayweather.controller.Manufacturer;

import net.mayweather.DaoSingleton;
import net.mayweather.model.Manufacturer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class DeleteManufacturerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");

        String manufacturerIdStr = req.getParameter("manufacturer_id");

        UUID manufacturerId = UUID.fromString(manufacturerIdStr);
        //Delete manufacturer with given id
        Manufacturer manufacturer = DaoSingleton.getINSTANCE().getManufacturerDAO().getById(manufacturerId);
        DaoSingleton.getINSTANCE().getManufacturerDAO().delete(manufacturer);
        //Show some feedback for user
        req.getRequestDispatcher("/jsp/delete_manufacturer.jsp").forward(req, resp);

    }
}
