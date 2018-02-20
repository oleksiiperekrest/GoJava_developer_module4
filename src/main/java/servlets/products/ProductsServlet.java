package servlets.products;

import storage.Storage;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = Storage.getInstance().getProducts();
        int manufacturersSize = Storage.getInstance().getManufacturers().size();

        req.setAttribute("products", products);
        req.setAttribute("manufacturersSize", manufacturersSize);
        req.getRequestDispatcher("/jsp/products.jsp").forward(req, resp);
    }
}
