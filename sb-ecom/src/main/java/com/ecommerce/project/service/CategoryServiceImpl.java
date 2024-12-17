package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
//@Service Annotation:
//Marks CategoryServiceImpl as a Spring-managed bean.
//Spring will create an instance of this class when needed.
public class CategoryServiceImpl implements CategoryService{
    private List<Category> categories = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(nextId++);
        categories.add(category);
    }
    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categories.stream().filter(c -> c.getCategoryId().equals(categoryId)).findFirst().
                orElseThrow(() ->
                     new ResponseStatusException(HttpStatus.NOT_FOUND , "category not found")) ;

        categories.remove(category);
        return "Category with categoryId " + categoryId + " deleted successfully" ;

    }
}
