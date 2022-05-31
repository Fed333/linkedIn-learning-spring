package com.fed333.learningspring.util.datetime;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

@Component("localTimeComponent")
@Qualifier("localTimeSingleton")
public class LocalTimeImpl implements Time{

    private final LocalTime time = LocalTime.now();

    @Override
    public long seconds() {
        return time.getSecond();
    }

    @Override
    public long millis() {
        return TimeUnit.NANOSECONDS.toMillis(time.getNano());
    }

    @Override
    public long nanos() {
        return time.getNano();
    }
}
