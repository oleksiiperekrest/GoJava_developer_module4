package controller;

import dao.ManufacturerDAO;
import dao.ProductDAO;
import dao.hibernate.HibernateManufacturerDAOImpl;
import dao.hibernate.HibernateProductDAOImpl;

public class Storage {
    private static final Storage INSTANCE = new Storage();

    private ManufacturerDAO manufacturerDAO = new HibernateManufacturerDAOImpl();
    private ProductDAO productDAO = new HibernateProductDAOImpl();

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
}
