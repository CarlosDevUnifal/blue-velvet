package bluevelvetapi.services;

import bluevelvetapi.entitys.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> getAllProducts();

}
