package dev.movie.Movieflix.controller.mapper;

import dev.movie.Movieflix.controller.request.CategoryRequest;
import dev.movie.Movieflix.controller.response.CategoryResponse;
import dev.movie.Movieflix.entity.Category;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper{
    public static Category toCategory(CategoryRequest categoryRequest){
        return Category
                .builder()
                .name(categoryRequest.name())
                .build();
    }

    public static CategoryResponse toCategoryResponse(Category category){
        return CategoryResponse
                .builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
