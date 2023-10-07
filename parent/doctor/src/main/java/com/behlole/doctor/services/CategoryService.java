package com.behlole.doctor.services;

import com.behlole.doctor.dto.CategoryDto;
import com.behlole.doctor.models.Category;
import com.behlole.doctor.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    CategoryRepository categoryRepository;

    public CategoryDto convertCategoryToCategoryDto(Category category) {
        return this.modelMapper.map(category, CategoryDto.class);
    }

    public Category convertCategoryDtoToCategory(CategoryDto categoryDto) {
        return modelMapper.map(categoryDto, Category.class);
    }

    public List<CategoryDto> categoryListToCategoryDtoList(List<Category> categoryList) {
        return categoryList.stream().map(this::convertCategoryToCategoryDto).toList();
    }

    public List<Category> convertCategoryDtoListToCategoryList(List<CategoryDto> categoryDtoList) {
        return categoryDtoList.stream().map(this::convertCategoryDtoToCategory).toList();
    }

    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        categoryRepository.saveAndFlush(category);
        return modelMapper.map(category, CategoryDto.class);
    }

    public List<CategoryDto> createCategories(List<CategoryDto> categoryDtoList) {
        List<Category> categories = convertCategoryDtoListToCategoryList(categoryDtoList);
        categoryRepository.saveAllAndFlush(categories);
        return categoryListToCategoryDtoList(categories);
    }

}
