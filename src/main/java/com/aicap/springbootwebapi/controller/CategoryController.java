package com.aicap.springbootwebapi.controller;

import com.aicap.springbootwebapi.entity.Category;
import com.aicap.springbootwebapi.entity.Event;
import com.aicap.springbootwebapi.service.CategoryService;
import com.aicap.springbootwebapi.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
public class CategoryController {

    private CategoryService categoryService;
    EventService eventService;

    @GetMapping("api/categories/{id}")
    public ResponseEntity<Category> readCategory(@PathVariable("id") Long id) {
        return new ResponseEntity<>(categoryService.getCategoryById(id), HttpStatus.OK);
    }

    @GetMapping("/api/categories/{category_id}/events")
    public ResponseEntity<List<Event>> retrieveEventsByCategoryHandler(@PathVariable("category_id") Long category_id) {
        return new ResponseEntity<>(eventService.getEventsByCategory(category_id), HttpStatus.OK);
    }


}
