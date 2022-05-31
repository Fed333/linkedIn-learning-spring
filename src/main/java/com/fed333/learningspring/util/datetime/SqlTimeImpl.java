package com.fed333.learningspring.util.datetime;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Qualifier("sqlTimeSingleton")
public class SqlTimeImpl implements Time{

    private java.sql.Time time = new java.sql.Time(0);

    @Override
    public long seconds() {
        return TimeUnit.MILLISECONDS.toSeconds(time.getTime());
    }

    @Override
    public long millis() {
        return time.getTime();
    }

    @Override
    public long nanos() {
        return TimeUnit.MILLISECONDS.toNanos(time.getTime());
    }
}
