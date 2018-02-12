package servlets.products;

import dao.ProductDAO;
import dao.hibernate.HibernateProductDAOImpl;
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
    private ProductDAO productDAO = new HibernateProductDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productDAO.getAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/jsp/products.jsp").forward(req, resp);
    }
}
