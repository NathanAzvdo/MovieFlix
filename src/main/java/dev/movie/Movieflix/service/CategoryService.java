package dev.movie.Movieflix.service;

import dev.movie.Movieflix.entity.Category;
import dev.movie.Movieflix.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category saveCategory(Category category){
        if (category.getName() == null || category.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("O campo 'name' não pode estar vazio.");
        }
        return categoryRepository.save(category);
    }
}
