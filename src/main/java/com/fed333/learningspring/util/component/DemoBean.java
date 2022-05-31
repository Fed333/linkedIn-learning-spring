package com.fed333.learningspring.util.component;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@Getter
public class DemoBean implements IDemoBean{

    private LocalTime time = LocalTime.now();

    private String desc = "no desc";

    public void printDescription(){
        System.out.println(desc);
    }

    public void printTime(){
        System.out.println(time);
    }

}
