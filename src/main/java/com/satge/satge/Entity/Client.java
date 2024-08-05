package com.satge.satge.Entity;


import jakarta.persistence.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id") // Corrected column name
    private int clientId;

    @Column(name = "Name")
    private String name;


    @Column(name = "Address")
    private String address;

}
