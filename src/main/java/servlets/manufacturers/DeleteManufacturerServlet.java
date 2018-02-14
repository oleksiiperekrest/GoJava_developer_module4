package servlets.manufacturers;

import controller.Storage;
import model.Manufacturer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/delete_manufacturer")
public class DeleteManufacturerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        Manufacturer manufacturer = Storage.getInstance().getManufacturerDAO().getById(id);
        Storage.getInstance().getManufacturerDAO().delete(manufacturer);
        Storage.getInstance().refreshManufacturers();
        Storage.getInstance().refreshProducts();
        resp.sendRedirect("/manufacturers");
    }

}
