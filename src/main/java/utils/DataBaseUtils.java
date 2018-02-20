package utils;

import storage.Storage;
import model.Manufacturer;
import model.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBaseUtils {
    public static void main(String[] args) {

//        listAll();

//        initDataBase();

//        clearDataBase();
    }

    private static void listAll() {
        List<Manufacturer> manufacturers = Storage.getInstance().getManufacturerDAO().getAll();
        for (Manufacturer manufacturer : manufacturers) {
            System.out.println(manufacturer);
        }
        List<Product> products = Storage.getInstance().getProductDAO().getAll();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public static void initDataBase() {

        Manufacturer manufacturer = new Manufacturer();

        manufacturer.setName("Auchan");
        Storage.getInstance().getManufacturerDAO().save(manufacturer);

        manufacturer.setName("Jysk");
        Storage.getInstance().getManufacturerDAO().save(manufacturer);

        manufacturer.setName("Roshen");
        Storage.getInstance().getManufacturerDAO().save(manufacturer);

        manufacturer.setName("Procter&Gamble");
        Storage.getInstance().getManufacturerDAO().save(manufacturer);

        List<Manufacturer> manufacturers = Storage.getInstance().getManufacturerDAO().getAll();
        Map<String, Manufacturer> manufacturerMap = new HashMap<String, Manufacturer>();
        for (Manufacturer manufacturer1 : manufacturers) {
            manufacturerMap.put(manufacturer1.getName(), manufacturer1);
        }

        Product product = new Product();

        product.setName("Cheese");
        product.setPrice(new BigDecimal("250.00"));
        product.setManufacturer(manufacturerMap.get("Auchan"));
        Storage.getInstance().getProductDAO().save(product);

        product.setName("Oil");
        product.setPrice(new BigDecimal("110.00"));
        product.setManufacturer(manufacturerMap.get("Auchan"));
        Storage.getInstance().getProductDAO().save(product);

        product.setName("Mattress");
        product.setPrice(new BigDecimal("1420.00"));
        product.setManufacturer(manufacturerMap.get("Jysk"));
        Storage.getInstance().getProductDAO().save(product);

        product.setName("Cake");
        product.setPrice(new BigDecimal("120.00"));
        product.setManufacturer(manufacturerMap.get("Roshen"));
        Storage.getInstance().getProductDAO().save(product);

        product.setName("Toothpaste");
        product.setPrice(new BigDecimal("33.00"));
        product.setManufacturer(manufacturerMap.get("Procter&Gamble"));
        Storage.getInstance().getProductDAO().save(product);

        product.setName("Shampoo");
        product.setPrice(new BigDecimal("67.00"));
        product.setManufacturer(manufacturerMap.get("Procter&Gamble"));
        Storage.getInstance().getProductDAO().save(product);
        Storage.getInstance().refreshManufacturers();
        Storage.getInstance().refreshProducts();

    }

    public static void clearDataBase() {

        for (Product product : Storage.getInstance().getProducts()) {
            Storage.getInstance().getProductDAO().delete(product);
        }

        Storage.getInstance().refreshManufacturers();
        for (Manufacturer manufacturer : Storage.getInstance().getManufacturers()) {
            Storage.getInstance().getManufacturerDAO().delete(manufacturer);
        }

        Storage.getInstance().refreshManufacturers();
        Storage.getInstance().refreshProducts();
    }
}
