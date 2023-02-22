package bluevelvetapi.controllers;

import bluevelvetapi.entitys.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import bluevelvetapi.repositories.ProductRepository;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductRepository productRepository;


    @GetMapping("/products")
    public ModelAndView productspage () {
        ModelAndView mav = new ModelAndView("products/list");
        mav.addObject("products", productRepository.findAll());
        return mav;
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/products")
    public ResponseEntity<Void> createProduct(@RequestBody Product product) {
        productRepository.save(product);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
