package controllers.product;

import dao.ProductDao;
import entitys.product.Product;

import java.util.List;

public class ProductController {
    private ProductDao productDao;

    public ProductController() {
        this.productDao = new ProductDao();
    }

    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    public Product getProductAt(int index) {
        return productDao.getProductAt(index);
    }

    public void removeProduct(Product product) {
        productDao.removeProduct(product);
    }

    public void addProduct(Product product) {
        productDao.addProduct(product);
    }
}
