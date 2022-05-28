package com.fed333.learningspring.data.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROOM_ID")
    private long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "ROOM_NUMBER", nullable = false, unique = true)
    private String roomNumber;

    @Column(name = "BED_INFO", nullable = false)
    private String bedInfo;

}
