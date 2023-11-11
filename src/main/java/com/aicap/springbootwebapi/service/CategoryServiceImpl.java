package com.aicap.springbootwebapi.service;

import com.aicap.springbootwebapi.dao.CategoryDao;
import com.aicap.springbootwebapi.entity.Category;
import com.aicap.springbootwebapi.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao;

    @Override
    public Category getCategoryById(Long id) {
        return unwrapCategory(categoryDao.findById(id), id);
    }

    static Category unwrapCategory(Optional<Category> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(id, Category.class);
    }
}
