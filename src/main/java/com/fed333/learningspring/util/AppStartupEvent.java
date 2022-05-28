package com.fed333.learningspring.util;

import com.fed333.learningspring.data.entity.Room;
import com.fed333.learningspring.data.repo.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

    private final RoomRepository roomRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Iterable<Room> rooms = roomRepository.findAll();
        rooms.forEach(System.out::println);
    }
}
