package dev.movie.Movieflix.service;

import dev.movie.Movieflix.entity.Category;
import dev.movie.Movieflix.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }

    public Optional<Category> findById(long id){
        return categoryRepository.findById(id);
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }
}
