package com.springboot.blog.service;

import java.util.List;

import com.springboot.blog.payload.CategoryDto;

public interface CategoryService {
    CategoryDto addCategory(CategoryDto categoryDto);

    CategoryDto getCategory(Long categoryId);

    List<CategoryDto> getAllCategories();

    CategoryDto updateCategory(Long categoryId, CategoryDto categoryDto);

    void deleteCategoryById(long id);
}
