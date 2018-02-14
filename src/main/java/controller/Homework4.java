package controller;

import dao.ManufacturerDAO;
import dao.ProductDAO;
import model.Manufacturer;
import model.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Homework4 {
    static ProductDAO productDAO = Storage.getInstance().getProductDAO();
    static ManufacturerDAO manufacturerDAO = Storage.getInstance().getManufacturerDAO();

    public static void main(String[] args) {

//        initDataBase(productDAO, manufacturerDAO);
//        listAll(productDAO, manufacturerDAO);

    }

    private static void listAll(ProductDAO productDAO, ManufacturerDAO manufacturerDAO) {
        List<Manufacturer> manufacturers = manufacturerDAO.getAll();
        for (Manufacturer manufacturer : manufacturers) {
            System.out.println(manufacturer);
        }
        List<Product> products = productDAO.getAll();
        for (Product product : products) {
            System.out.println(product);
        }
    }


    private static void initDataBase(ProductDAO productDAO, ManufacturerDAO manufacturerDAO) {

        Manufacturer manufacturer = new Manufacturer();

        manufacturer.setName("Auchan");
        manufacturerDAO.save(manufacturer);

        manufacturer.setName("Jysk");
        manufacturerDAO.save(manufacturer);

        manufacturer.setName("Roshen");
        manufacturerDAO.save(manufacturer);

        manufacturer.setName("Procter&Gamble");
        manufacturerDAO.save(manufacturer);

        List<Manufacturer> manufacturers = manufacturerDAO.getAll();
        Map<String, Manufacturer> manufacturerMap = new HashMap<String, Manufacturer>();
        for (Manufacturer manufacturer1 : manufacturers) {
            manufacturerMap.put(manufacturer1.getName(), manufacturer1);
        }

        Product product = new Product();

        product.setName("Cheese");
        product.setPrice(new BigDecimal("250.00"));
        product.setManufacturer(manufacturerMap.get("Auchan"));
        productDAO.save(product);

        product.setName("Oil");
        product.setPrice(new BigDecimal("110.00"));
        product.setManufacturer(manufacturerMap.get("Auchan"));
        productDAO.save(product);

        product.setName("Mattress");
        product.setPrice(new BigDecimal("1420.00"));
        product.setManufacturer(manufacturerMap.get("Jysk"));
        productDAO.save(product);

        product.setName("Cake");
        product.setPrice(new BigDecimal("120.00"));
        product.setManufacturer(manufacturerMap.get("Roshen"));
        productDAO.save(product);

        product.setName("Toothpaste");
        product.setPrice(new BigDecimal("33.00"));
        product.setManufacturer(manufacturerMap.get("Procter&Gamble"));
        productDAO.save(product);

        product.setName("Shampoo");
        product.setPrice(new BigDecimal("67.00"));
        product.setManufacturer(manufacturerMap.get("Procter&Gamble"));
        productDAO.save(product);
    }

}
