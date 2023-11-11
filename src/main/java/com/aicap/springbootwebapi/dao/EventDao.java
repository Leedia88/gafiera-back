package com.aicap.springbootwebapi.dao;

import com.aicap.springbootwebapi.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface EventDao extends JpaRepository<Event, Long> {
    Optional<List<Event>> findAllByCategoryId(Long category_id);

}
