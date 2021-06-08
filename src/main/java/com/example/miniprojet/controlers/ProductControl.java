package com.example.miniprojet.controlers;

import com.example.miniprojet.Views.CategoryView;
import com.example.miniprojet.Views.ProductView;
import com.example.miniprojet.models.Category;
import com.example.miniprojet.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("product")
@CrossOrigin("*")
public class ProductControl {@Autowired
ProductView productRepository;

    @Autowired
    CategoryView categoryRepository;


    @GetMapping("/all")
    public List<Product> allProducts() {
        return productRepository.findAll();
    }


    @GetMapping("/{id}")
    public Product addProduct(@PathVariable Long id ) {
        return productRepository.findById(id).get();
    }


//
//	@PostMapping("/add/{idcategorie}/{idmarque}/")
//	public Product getPlat(@PathVariable Long idcategorie,@PathVariable Long idmarque,@RequestBody Product p) {
//		Category category = categoryRepository.findById(idcategorie).get();
//		Marque marque = marqueRepository.findById(idmarque).get();
//		p.setCategory(category);
//		productRepository.save(p);
//		p.setMarque(marque);
//		return productRepository.save(p);
//	}

    @PostMapping("/add")
    public Product addplat(@RequestBody Product p) {
//        Category category = categoryRepository.findById(id).get();
//        p.setCategory(category);
        return productRepository.save(p);
    }


    @DeleteMapping("/delete/{Id}")
    public HashMap<String, String> delete(@PathVariable Long Id){

        HashMap hashMap= new HashMap();
        try{
            productRepository.deleteById(Id);
            hashMap.put("etat","product supprimé");
            return hashMap;

        }
        catch (Exception e){
            hashMap.put("etat","product  non supprimé");
            return hashMap;
        }
    }

    @PutMapping("/update/{id}")
    public Product updateCategory(@PathVariable Long id, @RequestBody Product p) {
        p.setId(id);
        return productRepository.saveAndFlush(p);
    }
}
