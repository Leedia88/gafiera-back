package com.aicap.springbootwebapi.service;

import com.aicap.springbootwebapi.dao.CategoryDao;
import com.aicap.springbootwebapi.dao.EventDao;
import com.aicap.springbootwebapi.dao.UserDao;
import com.aicap.springbootwebapi.entity.Category;
import com.aicap.springbootwebapi.entity.Event;
import com.aicap.springbootwebapi.entity.User;
import com.aicap.springbootwebapi.entity.dto.EventDto;
import com.aicap.springbootwebapi.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {


    private EventDao eventDao;

    private CategoryDao categoryDao;

    private UserDao userDao;


    @Override
    public Event addEvent(EventDto eventDto) {
        Long cat_id = eventDto.getCategory();
        Optional<Category> option = categoryDao.findById(cat_id);
        Category category = CategoryServiceImpl.unwrapCategory(option, cat_id);
        Long owner_id = eventDto.getOwner();
        Optional<User> optionalUser = userDao.findById(owner_id);
        User user = UserServiceImpl.unwrapUser(optionalUser, owner_id);
        Event event = new Event(eventDto.getTitle(), eventDto.getDescription(), eventDto.getDate(), eventDto.getDuration(), user, category);
        eventDao.save(event);
        return event;
    }

    @Override
    public List<Event> getAllEvents() {
        return eventDao.findAll();
    }

    @Override
    public List<Event> getEventsByCategory(Long category_id) {
        Optional<List<Event>> listOptional = eventDao.findAllByCategoryId(category_id);
        if (listOptional.isPresent()) return listOptional.get();
        else throw new EntityNotFoundException(category_id, Category.class);
    }

    @Override
    public Event findById(Long id) {
        Optional<Event> event = eventDao.findById(id);
        return unwrapEvent(event, id);
    }

    @Override
    public void deleteEvent(Long id) {
        eventDao.deleteById(id);
    }

    @Override
    public Event updateEvent(Long id, EventDto eventDto) {
        Optional<Event> option = eventDao.findById(id);
        Event event = unwrapEvent(option,id);
        event.setDate(eventDto.getDate());
        event.setDescription(eventDto.getDescription());
        event.setTitle(eventDto.getTitle());
        event.setDuration(eventDto.getDuration());
        return eventDao.save(event);
    }

    @Override
    public Event addParticipant(Long event_id, Long user_id) {
        Event event = findById(event_id);
        Optional<User> user = userDao.findById(user_id);
        User unwrappedUser = UserServiceImpl.unwrapUser(user, user_id);
        event.getParticipants().add(unwrappedUser);
        return eventDao.save(event);
    }

    @Override
    public List<User> getEnrolledUsers(Long event_id) {
        Event event = findById(event_id);
        return  event.getParticipants();
    }

    @Override
    public List<Event> getFirstEvents() {
        return eventDao.findAll().subList(0,3);
    }

    static Event unwrapEvent(Optional<Event> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(id, Event.class );
    }
}
