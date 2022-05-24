package com.codecool.shop.service;

import com.codecool.shop.dao.*;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import java.util.List;

public class ShopService {
    private ProductDao productDao;
    private ProductCategoryDao productCategoryDao;
private SupplierDao supplierDao;
private CartDao cartDao;
private OrderDao orderDao;
private UserDao userDao;
private static ShopService instance=null;




    public SupplierDao getSupplierDao() {
        return supplierDao;
    }


    public  static ShopService getInstance(ProductDao productDao, ProductCategoryDao productCategoryDao, SupplierDao supplierDao){
        if(instance==null)instance=new ShopService(productDao, productCategoryDao, supplierDao);
        return instance;
    }

    private ShopService(ProductDao productDao, ProductCategoryDao productCategoryDao, SupplierDao supplierDao) {
        this.productDao = productDao;
        this.productCategoryDao = productCategoryDao;
        this.supplierDao=supplierDao;
    }

    public ProductCategory getProductCategory(int categoryId){
        return productCategoryDao.find(categoryId);
    }

    public List<Product> getProductsForCategory(int categoryId){
        var category = productCategoryDao.find(categoryId);
        return productDao.getBy(category);
    }

    public List<ProductCategory> getAllCategories(){
        return productCategoryDao.getAll();
    }
    public List<Product> getAllProducts(){
        return productDao.getAll();
    }

    public List<Supplier> getAllSuppliers(){
        return supplierDao.getAll();
    }

}
