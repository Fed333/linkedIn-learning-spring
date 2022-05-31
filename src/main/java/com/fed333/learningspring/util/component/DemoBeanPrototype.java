package com.fed333.learningspring.util.component;

import com.fed333.learningspring.util.datetime.LocalTimeImpl;
import com.fed333.learningspring.util.datetime.Time;
import lombok.Getter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Getter
public class DemoBeanPrototype implements IDemoBean{

    @Autowired
    @Qualifier("localTimeSingleton")
    private Time time;

    private String desc = "prototype bean";

    @SneakyThrows
    public DemoBeanPrototype() {
        System.out.println("Prototype bean creation.");
        System.out.println("Sleep...");
        Thread.sleep(10);
        System.out.println("Back again.");
    }

    @Override
    public void printDescription() {
        System.out.println(desc);
    }

    @Override
    public void printTime() {
        System.out.println(time.nanos() + " nanos.");
    }
}
