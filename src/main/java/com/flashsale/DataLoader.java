package com.flashsale;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataLoader implements CommandLineRunner {

    private final EventRepository eventRepository;

    public DataLoader(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public void run(String... args) {

        if (eventRepository.count() == 0) {

            Event event = new Event(
                    null,
                    "Rock Concert",
                    LocalDateTime.now().plusDays(7),
                    100
            );

            eventRepository.save(event);

            System.out.println("Mock event inserted!");
        }
    }
}