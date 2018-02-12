package servlets.products;

import dao.ManufacturerDAO;
import dao.ProductDAO;
import dao.hibernate.HibernateProductDAOImpl;
import model.Manufacturer;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/edit_product")
public class AddProductServlet extends HttpServlet {
    private ProductDAO productDAO = controller.Storage.getInstance().getProductDAO();
    private ManufacturerDAO manufacturerDAO = controller.Storage.getInstance().getManufacturerDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productDAO.getAll();
        List<Manufacturer> manufacturers = manufacturerDAO.getAll();
        req.setAttribute("products", products);
        req.setAttribute("manufacturers", manufacturers);
        req.setAttribute("action", "add");
        req.getRequestDispatcher("/jsp/edit_product.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
