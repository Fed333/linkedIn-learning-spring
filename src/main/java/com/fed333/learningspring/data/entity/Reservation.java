package com.fed333.learningspring.data.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RESERVATION_ID")
    private long id;

    @OneToMany(mappedBy = "id", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Room> room;

    @OneToMany(mappedBy = "id", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Guest> guests;

    @Column(name = "RES_DATE")
    private LocalDate resDate;

}
