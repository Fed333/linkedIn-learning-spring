package com.fed333.learningspring.util.component;

import com.fed333.learningspring.util.datetime.Time;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Getter
public class DemoBean implements IDemoBean{

    @Autowired
    @Qualifier("autowireSqlTimeDependency")
    private Time time;

    @Autowired
    private Time localTimeComponent;

    private String desc = "no desc";

    @PostConstruct
    private void init(){
        desc = desc += "\ntime: " + time + "\nlocalTimeComponent: " + localTimeComponent;
    }

    public void printDescription(){
        System.out.println(desc);
        System.out.println("time:" + time);
        System.out.println("localTimeComponent" + localTimeComponent);
    }

    public void printTime(){
        System.out.println(time);
    }

}
