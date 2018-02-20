package storage;

import dao.ManufacturerDAO;
import dao.ProductDAO;
import dao.hibernate.HibernateManufacturerDAOImpl;
import dao.hibernate.HibernateProductDAOImpl;
import model.Manufacturer;
import model.Product;

import java.util.List;

public class Storage {
    private static final Storage INSTANCE = new Storage();

    private ManufacturerDAO manufacturerDAO = new HibernateManufacturerDAOImpl();
    private ProductDAO productDAO = new HibernateProductDAOImpl();

    private List<Product> products;
    private List<Manufacturer> manufacturers;

    private Storage() {
    }

    public static Storage getInstance() {
        return INSTANCE;
    }

    public ManufacturerDAO getManufacturerDAO() {
        return manufacturerDAO;
    }

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public List<Product> getProducts() {
        if (products == null)
            refreshProducts();
        return products;
    }

    public List<Manufacturer> getManufacturers() {
        if (manufacturers == null)
            refreshManufacturers();
        return manufacturers;
    }

    public void refreshProducts() {
        products = productDAO.getAll();
    }

    public void refreshManufacturers() {
        manufacturers = manufacturerDAO.getAll();
    }
}
