package com.fed333.learningspring.util.startup;

import com.fed333.learningspring.util.component.DemoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartupEventTestAutowiredDefaultScope implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private DemoBean demoBean1;

    @Autowired
    private DemoBean demoBean2;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        System.out.println("Autowired injection singleton beans:");
        System.out.println("bean1: " + demoBean1 + ", desc: " + demoBean1.getDesc());
        demoBean1.printTime();
        System.out.println("bean2: " + demoBean2 + ", desc: " + demoBean2.getDesc());
        demoBean2.printTime();
        System.out.println("sameness: " + (demoBean1 == demoBean2) );
    }
}
