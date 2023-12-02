package com.aicap.springbootwebapi.controller;

import com.aicap.springbootwebapi.entity.Event;
import com.aicap.springbootwebapi.entity.User;
import com.aicap.springbootwebapi.entity.dto.EventDto;
import com.aicap.springbootwebapi.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.event.ListDataEvent;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/events")
@CrossOrigin("${front.url}")
public class EventController {

    @Autowired
    private EventService eventService;

   @GetMapping
   public ResponseEntity<List<Event>> retrieveEventsHandler(){
       return new ResponseEntity<>(eventService.getAllEvents(), HttpStatus.OK);
   }

    @GetMapping("/preview")
    public ResponseEntity<List<Event>> retrieveFirstEvents(){
        return new ResponseEntity<>(eventService.getFirstEvents(), HttpStatus.OK);
    }

   @GetMapping("/{id}")
    public ResponseEntity<Event> getEventByIdHandler(@PathVariable("id") Long id){
       return new ResponseEntity<>(eventService.findById(id), HttpStatus.OK);
   }

   @PostMapping
    public ResponseEntity<Event> addEventHandler(@RequestBody EventDto eventDto){
       Event addEvent = eventService.addEvent(eventDto);
       return new ResponseEntity<>(addEvent, HttpStatus.CREATED);
   }

    @DeleteMapping("/{id}")
    public ResponseEntity<Event> deleteEventByIdHandler(@PathVariable("id") Long id) {
        eventService.deleteEvent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEventHandler(@PathVariable("id") Long id, @RequestBody EventDto eventDto) {
       return new ResponseEntity<>(eventService.updateEvent(id, eventDto), HttpStatus.OK);
    }

    @PutMapping("/{id}/user/{user_id}")
    public ResponseEntity<Event> enrollUserToEvent(@PathVariable("id") Long id, @PathVariable("user_id") Long user_id) {
       return new ResponseEntity<>(eventService.addParticipant(id, user_id), HttpStatus.OK);
    }

    @GetMapping("/{id}/participants")
    public ResponseEntity<List<User>> getEnrolledStudents(@PathVariable("id") Long id) {
        return new ResponseEntity<>(eventService.getEnrolledUsers(id), HttpStatus.OK);
    }


}
