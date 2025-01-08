package dev.movie.Movieflix.controller;

import dev.movie.Movieflix.controller.mapper.CategoryMapper;
import dev.movie.Movieflix.controller.request.CategoryRequest;
import dev.movie.Movieflix.controller.response.CategoryResponse;
import dev.movie.Movieflix.entity.Category;
import dev.movie.Movieflix.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/movieflix/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public List<CategoryResponse> getAllCategories(){
        List<Category> categories = categoryService.findAll();
        return categories.stream()
                .map(CategoryMapper::toCategoryResponse)
                .toList();
    }

    @PostMapping
    public CategoryResponse saveCategory(@RequestBody CategoryRequest request){
        Category newCategory = CategoryMapper.toCategory(request);
        Category savedCategory = categoryService.saveCategory(newCategory);
        return CategoryMapper.toCategoryResponse(savedCategory);
    }
    @GetMapping("/{id}")
    public CategoryResponse getByid(@PathVariable long id){
        Optional<Category> optionalCategory = categoryService.findById(id);
        return optionalCategory.map(CategoryMapper::toCategoryResponse).orElse(null);
    }

    @DeleteMapping
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }
}
