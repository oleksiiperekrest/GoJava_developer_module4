package servlets.products;

import controller.Storage;
import model.Product;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/delete_product")
public class DeleteProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        Product product = Storage.getInstance().getProductDAO().getById(id);
        Storage.getInstance().getProductDAO().delete(product);
        Storage.getInstance().refreshProducts();
        resp.sendRedirect("/products");
    }

}
