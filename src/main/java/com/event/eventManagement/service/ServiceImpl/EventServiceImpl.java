package com.event.eventManagement.service.ServiceImpl;

import com.event.eventManagement.entity.Event;
import com.event.eventManagement.repository.EventRepository;
import com.event.eventManagement.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
    }

    @Override
    public Event updateEvent(Event event, Long id) {
        Event e=getEventById(id);
        e.setName(event.getName()!=null? event.getName():e.getName());
        e.setDescription(event.getDescription()!=null? event.getDescription():e.getDescription());
        e.setFee(event.getFee()!=null ? event.getFee():e.getFee());
        e.setStartDate(event.getStartDate()!=null?event.getStartDate():e.getStartDate());
        e.setEndDate(event.getEndDate()!=null?event.getEndDate():e.getEndDate());
        eventRepository.save(e);
        return e;
    }

    @Override
    public void deleteEvent(long id) {
        Event e= getEventById(id);
        eventRepository.delete(e);
    }
}
