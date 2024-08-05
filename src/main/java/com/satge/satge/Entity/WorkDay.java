package com.satge.satge.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@IdClass(WorkDayId.class)
@Getter
@Setter
public class WorkDay {

    @Id
    @Column(name = "Date")
    private Date date;

    @Id
    @Column(name = "EmployeeId")
    private int employeeId;

    @Column(name = "Vacation")
    private boolean vacation;

    // Hours 1
    @Column(name = "H1Work", nullable = false)
    private String h1Work = "";

    @Column(name = "H1Client", nullable = false)
    private int h1Client = -1;

    @Column(name = "H1Project", nullable = false)
    private int h1Project = -1;

    @Column(name = "H1Description", nullable = false)
    private String h1Description = "";

    @Column(name = "H1Hours", nullable = false)
    private int h1Hours = -1;

    @Column(name = "H1InSite", nullable = false)
    private boolean h1InSite;

    // Hours 2
    @Column(name = "H2Work", nullable = false)
    private String h2Work = "";

    @Column(name = "H2Client", nullable = false)
    private int h2Client = -1;

    @Column(name = "H2Project", nullable = false)
    private int h2Project = -1;

    @Column(name = "H2Description", nullable = false)
    private String h2Description = "";

    @Column(name = "H2Hours", nullable = false)
    private int h2Hours = -1;

    @Column(name = "H2InSite", nullable = false)
    private boolean h2InSite;

    // Hours 3
    @Column(name = "H3Work", nullable = false)
    private String h3Work = "";

    @Column(name = "H3Client", nullable = false)
    private int h3Client = -1;

    @Column(name = "H3Project", nullable = false)
    private int h3Project = -1;

    @Column(name = "H3Description", nullable = false)
    private String h3Description = "";

    @Column(name = "H3Hours", nullable = false)
    private int h3Hours = -1;

    @Column(name = "H3InSite", nullable = false)
    private boolean h3InSite;

    // Hours 4
    @Column(name = "H4Work", nullable = false)
    private String h4Work = "";

    @Column(name = "H4Client", nullable = false)
    private int h4Client = -1;

    @Column(name = "H4Project", nullable = false)
    private int h4Project = -1;

    @Column(name = "H4Description", nullable = false)
    private String h4Description = "";

    @Column(name = "H4Hours", nullable = false)
    private int h4Hours = -1;

    @Column(name = "H4InSite", nullable = false)
    private boolean h4InSite;

    // Constructors, equals, hashCode, etc.
}
