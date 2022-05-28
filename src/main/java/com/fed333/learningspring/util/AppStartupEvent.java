package com.fed333.learningspring.util;

import com.fed333.learningspring.data.entity.Room;
import com.fed333.learningspring.data.repo.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

    //field injection
    @Autowired
    private RoomRepository roomRepository;

    //constructor injection
    @Autowired
    public AppStartupEvent(RoomRepository roomRepository) {
        System.out.println("AppStartupEvent constructor invoked!");
        System.out.println("Dependencies to inject is: [" + roomRepository + "].");
        this.roomRepository = roomRepository;
    }

    //setter injection
    @Autowired
    public void setRoomRepository(RoomRepository roomRepository) {
        System.out.println("setRoomRepository setter invoked!");
        System.out.println("roomRepository now references into " + roomRepository + " object");
        System.out.println("the dependency to set is " + roomRepository);
        this.roomRepository = roomRepository;
    }

    @PostConstruct
    public void init(){
        System.out.println("PostConstruct init method invokes.");
        System.out.println("Dependency roomRepository is: " + roomRepository);
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Iterable<Room> rooms = roomRepository.findAll();
        rooms.forEach(System.out::println);
    }


}
