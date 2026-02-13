package com.portfolio.price_tracker.service;

import com.portfolio.price_tracker.domain.Product;
import com.portfolio.price_tracker.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    /**
     * Obtiene todos los productos que están siendo monitoreados.
     * Corresponde a la HU2.
     * @return una lista de entidades Product.
     */
    @Transactional(readOnly = true) // Anotación para la gestión de transacciones.
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Añade un nuevo producto para ser monitoreado a partir de una URL.
     * Corresponde a la HU1.
     * @param url La URL del producto a añadir.
     * @return El producto guardado con su ID generado.
     */
    @Transactional
    public Product addNewProduct(String url) {
        // Lógica de negocio:
        // 1. Podríamos validar si la URL ya existe para no duplicarla. (Lo haremos más adelante).
        // 2. Podríamos hacer una primera extracción del nombre y precio aquí. (También más adelante).

        Product newProduct = new Product();
        newProduct.setUrl(url);
        // Por ahora, el nombre y el precio estarán vacíos hasta que implementemos el scraping.
        newProduct.setName("Producto pendiente de extracción");
        newProduct.setCurrentPrice("N/A");

        return productRepository.save(newProduct);
    }
}
