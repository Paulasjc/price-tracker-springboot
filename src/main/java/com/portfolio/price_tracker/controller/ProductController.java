package com.portfolio.price_tracker.controller;
import com.portfolio.price_tracker.controller.dto.CreateProductRequest;


import com.portfolio.price_tracker.domain.Product;
import com.portfolio.price_tracker.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {

    // Dependencia hacia la capa de servicio
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }
    /**
     * Endpoint para obtener todos los productos.
     * Se activa con una petición GET a /api/products.
     * Corresponde a la HU2.
     */
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.findAllProducts();
        return ResponseEntity.ok(products); // Devuelve el códido de estado - 200 ok
    }

    /**
     * Endpoint para añadir un nuevo producto.
     * Se activa con una petición POST a /api/products.
     * El cuerpo de la petición debe contener la URL.
     * Corresponde a la HU1.
     */
    @PostMapping
    public ResponseEntity<Product> addNewProduct(@RequestBody CreateProductRequest request){
        Product newProduct = productService.addNewProduct(request.getUrl());
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }
}
