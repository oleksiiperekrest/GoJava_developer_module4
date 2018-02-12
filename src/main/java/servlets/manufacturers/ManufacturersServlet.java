package servlets.manufacturers;

import dao.ManufacturerDAO;
import dao.hibernate.HibernateManufacturerDAOImpl;
import model.Manufacturer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/manufacturers")
public class ManufacturersServlet extends HttpServlet {
    private ManufacturerDAO manufacturerDAO = new HibernateManufacturerDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Manufacturer> manufacturers = manufacturerDAO.getAll();
        req.setAttribute("manufacturers", manufacturers);
        req.getRequestDispatcher("/jsp/manufacturers.jsp").forward(req, resp);
    }
}
