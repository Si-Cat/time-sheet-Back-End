package com.satge.satge.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private int projectId;

    private String projectName;

    @Column(name = "Distance")
    private float distance;

    @Column(name = "Address")
    private String address;

    @Column(name = "clientid") // Foreign key column
    private int clientId;
}
