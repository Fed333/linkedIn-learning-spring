package com.fed333.learningspring.util.startup;

import com.fed333.learningspring.data.repo.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AppStartupEventReservationRepositoryDemo implements ApplicationListener<ApplicationReadyEvent> {

    private final ReservationRepository reservationRepo;

    @Autowired
    public AppStartupEventReservationRepositoryDemo(ReservationRepository reservationRepo) {
        this.reservationRepo = reservationRepo;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        LocalDate resDate = LocalDate.of(2022, 1, 1);
        reservationRepo.findAllByResDate(resDate).forEach(System.out::println);
    }
}