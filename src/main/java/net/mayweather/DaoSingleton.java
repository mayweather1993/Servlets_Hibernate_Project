package net.mayweather;

import net.mayweather.dao.ManufacturerDAO;
import net.mayweather.dao.ProductDAO;
import net.mayweather.dao.hibernate.ManufacturerDAOImpl;
import net.mayweather.dao.hibernate.ProductDAOImpl;

public class DaoSingleton {
    private ManufacturerDAO manufacturerDAO;
    private ProductDAO productDAO;
    private static final DaoSingleton INSTANCE = new DaoSingleton();

    private DaoSingleton() {
        manufacturerDAO = new ManufacturerDAOImpl();
        productDAO = new ProductDAOImpl();
    }

    public ManufacturerDAO getManufacturerDAO() {
        return manufacturerDAO;
    }

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public static DaoSingleton getINSTANCE() {
        return INSTANCE;
    }
}
