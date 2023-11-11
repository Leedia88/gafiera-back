package com.aicap.springbootwebapi.dao;

import com.aicap.springbootwebapi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CategoryDao extends JpaRepository<Category, Long> {
}
