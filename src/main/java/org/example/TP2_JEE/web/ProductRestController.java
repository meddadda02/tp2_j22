package org.example.TP2_JEE.web;import org.example.TP2_JEE.entities.Product;
import org.example.TP2_JEE.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;import java.util.List;
import java.util.Optional;@RestController
@RequestMapping("/products")
public class ProductRestController {    private final ProductRepository productRepository;    public ProductRestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }    //   Tous les produits
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }    //   Produit par ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id).orElse(null);
    }    //   Rechercher par nom (ex : /products/search?name=mac)
    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String name) {
        return productRepository.findByNameContains(name);
    }    //   Ajouter un produit
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }    //   Mettre à jour un produit
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            product.setQuantity(updatedProduct.getQuantity());
            return productRepository.save(product);
        } else {
            return null;
        }
    }    //   Supprimer un produit
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}
