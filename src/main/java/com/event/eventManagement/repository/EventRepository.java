package com.event.eventManagement.repository;

import com.event.eventManagement.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}

//package com.event.eventManagement.repository;
//
//import com.event.eventManagement.entity.Event;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//public class EventRepository extends JpaRepository<Event, Long> {
//
//
//}
//
