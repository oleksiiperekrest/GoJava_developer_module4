package servlets.products;

import controller.Storage;
import model.Manufacturer;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@WebServlet("/edit_product")
public class EditProductServlet extends HttpServlet {

    private UUID id;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Manufacturer> manufacturers = Storage.getInstance().getManufacturers();
        id = UUID.fromString(req.getParameter("id"));
        Product product = Storage.getInstance().getProductDAO().getById(id);

        req.setAttribute("product", product);
        req.setAttribute("manufacturers", manufacturers);
        req.setAttribute("mode", "edit");
        req.getRequestDispatcher("/jsp/edit_product.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Map<String, String[]> parameters = req.getParameterMap();

        Product product = Storage.getInstance().getProductDAO().getById(id);
        product.setName(parameters.get("name")[0]);
        product.setPrice(new BigDecimal(parameters.get("price")[0]));
        List<Manufacturer> manufacturers = Storage.getInstance().getManufacturers();
        String manufacturerName = parameters.get("manufacturer")[0];
        for (Manufacturer manufacturer : manufacturers) {
            if (manufacturerName.equals(manufacturer.getName())) {
                product.setManufacturer(manufacturer);
                break;
            }
        }
        Storage.getInstance().getProductDAO().update(product);
        Storage.getInstance().refreshProducts();
        resp.sendRedirect("/products");
    }
}
