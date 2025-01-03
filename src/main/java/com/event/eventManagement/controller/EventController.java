package com.event.eventManagement.controller;

import com.event.eventManagement.entity.Event;
import com.event.eventManagement.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents(){
        return new ResponseEntity<>(eventService.getAllEvents(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event){
        return new ResponseEntity<>(eventService.createEvent(event), HttpStatus.CREATED);
    }

}
