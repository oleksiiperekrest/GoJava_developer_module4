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

@WebServlet("/add_product")
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Manufacturer> manufacturers = Storage.getInstance().getManufacturers();
        req.setAttribute("manufacturers", manufacturers);
        req.setAttribute("mode", "add");
        req.getRequestDispatcher("/jsp/edit_product.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

//        for(String paramName : req.getParameterMap().keySet()) {
//            System.out.println(paramName + "=" + req.getParameter(paramName));
//        }

        Map<String, String[]> parameters = req.getParameterMap();

        Product product = new Product();
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
        controller.Storage.getInstance().getProductDAO().save(product);
        Storage.getInstance().refreshProducts();
        resp.sendRedirect(req.getContextPath() + "/products");
    }
}
