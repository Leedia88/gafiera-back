package com.aicap.springbootwebapi.service;

import com.aicap.springbootwebapi.dao.EventDao;
import com.aicap.springbootwebapi.entity.Event;
import com.aicap.springbootwebapi.entity.User;
import com.aicap.springbootwebapi.entity.dto.EventDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface EventService {

    public Event addEvent(EventDto eventDto);

    public List<Event> getAllEvents();

    public List<Event> getEventsByCategory(Long category_id);

    public Event findById(Long id);

    public void deleteEvent(Long id);

    public Event updateEvent(Long id, EventDto eventDto);
    Event addParticipant(Long event_id, Long id);

    List<User> getEnrolledUsers(Long event_id);

    List<Event> getFirstEvents();
}
