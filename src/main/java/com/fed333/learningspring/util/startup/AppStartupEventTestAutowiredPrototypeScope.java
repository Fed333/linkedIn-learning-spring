package com.fed333.learningspring.util.startup;

import com.fed333.learningspring.util.component.DemoBean;
import com.fed333.learningspring.util.component.DemoBeanPrototype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartupEventTestAutowiredPrototypeScope implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private DemoBeanPrototype demoBean1;

    @Autowired
    private DemoBeanPrototype demoBean2;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        System.out.println("Autowired injection prototype beans:");
        System.out.println("bean1: " + demoBean1 + ", desc: " + demoBean1.getDesc());
        demoBean1.printTime();
        System.out.println("bean2: " + demoBean2 + ", desc: " + demoBean2.getDesc());
        demoBean2.printTime();
        System.out.println("sameness: " + (demoBean1 == demoBean2) );
    }
}
