package com.example.miniprojet.controlers;

import com.example.miniprojet.Views.CategoryView;
import com.example.miniprojet.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("category")
@CrossOrigin("*")
public class CategoryControl {
    @Autowired
    CategoryView categoryrepository;

    //afficher la liste des category
    @GetMapping("/all")
    public List<Category> allCategory() {
        return categoryrepository.findAll();
    }


    //afficher une category by id
    @GetMapping("/{id}")
    public Category getCategory(@PathVariable Long id ) {
        return categoryrepository.findById(id).get();
    }


    //ajouter une category
    @PostMapping("/add")
    public Category addCategory(@RequestBody Category category) {
        return categoryrepository.save(category);
    }


    //supprimer une category
    @DeleteMapping("/delete/{Id}")
    public HashMap<String, String> delete(@PathVariable Long Id){

        HashMap hashMap= new HashMap();
        try{
            categoryrepository.deleteById(Id);
            hashMap.put("etat","categorie supprimé");
            return hashMap;

        }
        catch (Exception e){
            hashMap.put("etat","categorie  non supprimé");
            return hashMap;
        }
    }

    //modifier une catecory
    @PutMapping("/update/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category category) {
        category.setId(id);
        return categoryrepository.saveAndFlush(category);
    }

}
