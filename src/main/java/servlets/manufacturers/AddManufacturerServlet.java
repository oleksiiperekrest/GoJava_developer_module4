package servlets.manufacturers;

import controller.Storage;
import model.Manufacturer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/add_manufacturer")
public class AddManufacturerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("mode", "add");
        req.getRequestDispatcher("/jsp/edit_manufacturer.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Map<String, String[]> parameters = req.getParameterMap();

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName(parameters.get("name")[0]);

        Storage.getInstance().getManufacturerDAO().save(manufacturer);
        Storage.getInstance().refreshManufacturers();
        resp.sendRedirect(req.getContextPath() + "/manufacturers");
    }
}
