package com.event.eventManagement.service;

import com.event.eventManagement.entity.Event;

import java.util.List;

public interface EventService {
    Event createEvent(Event event);

    List<Event> getAllEvents();

    Event getEventById(Long id);

    Event updateEvent(Event event, Long id);

    void deleteEvent(long id);
}
