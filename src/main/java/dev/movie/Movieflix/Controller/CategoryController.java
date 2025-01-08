package dev.movie.Movieflix.Controller;

import dev.movie.Movieflix.entity.Category;
import dev.movie.Movieflix.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/movieflix/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public List<Category> getAllCategories(){
        return categoryService.findAll();
    }

    @PostMapping
    public Category saveCategory(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }
}
