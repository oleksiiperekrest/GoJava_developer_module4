package servlets.manufacturers;

import storage.Storage;
import model.Manufacturer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@WebServlet("/edit_manufacturer")
public class EditManufacturerServlet extends HttpServlet {

    private UUID id;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        id = UUID.fromString(req.getParameter("id"));
        Manufacturer manufacturer = Storage.getInstance().getManufacturerDAO().getById(id);

        req.setAttribute("manufacturer", manufacturer);
        req.setAttribute("mode", "edit");
        req.getRequestDispatcher("/jsp/edit_manufacturer.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Map<String, String[]> parameters = req.getParameterMap();

        Manufacturer manufacturer = Storage.getInstance().getManufacturerDAO().getById(id);
        manufacturer.setName(parameters.get("name")[0]);

        Storage.getInstance().getManufacturerDAO().update(manufacturer);
        Storage.getInstance().refreshManufacturers();
        Storage.getInstance().refreshProducts();
        resp.sendRedirect(req.getContextPath() + "/manufacturers");
    }
}
