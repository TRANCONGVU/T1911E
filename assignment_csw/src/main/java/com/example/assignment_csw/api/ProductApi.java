package com.example.assignment_csw.api;

import com.example.assignment_csw.entity.Product;
import com.example.assignment_csw.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@Slf4j
public class ProductApi {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }
    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Product p){
        return ResponseEntity.ok(productService.save(p));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        if (!product.isPresent()) {
            log.error("id not present");
        }
        return ResponseEntity.ok(product.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @PathVariable int quantity, @Valid @RequestBody Product product  ) {
        if (!productService.findById(id).isPresent()) {
            log.error("id not exist");
        }
        product.setId(id);
        product.setQuantity(quantity);
        return ResponseEntity.ok(productService.save(product));
    }
}
