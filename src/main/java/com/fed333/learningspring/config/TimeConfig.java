package com.fed333.learningspring.config;

import com.fed333.learningspring.util.datetime.LocalTimeImpl;
import com.fed333.learningspring.util.datetime.SqlTimeImpl;
import com.fed333.learningspring.util.datetime.Time;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class TimeConfig {

    @Bean
    @Scope("prototype")
    @Primary
    public Time getTime(){
        System.out.println("TimeConfig.getTime() invoked!");
        return new LocalTimeImpl();
    }

    @Bean
    public Time autowireSqlTimeDependency(){
        System.out.println("autowireSqlTimeDependency invoked!");
        return new SqlTimeImpl();
    }

}
