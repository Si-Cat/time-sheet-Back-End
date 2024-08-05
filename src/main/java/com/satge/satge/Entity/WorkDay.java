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

    @Column(name = "Vacation", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean vacation;

    // Hours 1
    @Column(name = "H1Work", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String h1Work = "";

    @Column(name = "H1Client", nullable = false, columnDefinition = "INT DEFAULT -1")
    private int h1Client = -1;

    @Column(name = "H1Project", nullable = false, columnDefinition = "INT DEFAULT -1")
    private int h1Project = -1;

    @Column(name = "H1Description", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String h1Description = "";

    @Column(name = "H1Hours", nullable = false, columnDefinition = "INT DEFAULT -1")
    private int h1Hours = -1;

    @Column(name = "H1InSite", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean h1InSite;

    // Hours 2
    @Column(name = "H2Work", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String h2Work = "";

    @Column(name = "H2Client", nullable = false, columnDefinition = "INT DEFAULT -1")
    private int h2Client = -1;

    @Column(name = "H2Project", nullable = false, columnDefinition = "INT DEFAULT -1")
    private int h2Project = -1;

    @Column(name = "H2Description", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String h2Description = "";

    @Column(name = "H2Hours", nullable = false, columnDefinition = "INT DEFAULT -1")
    private int h2Hours = -1;

    @Column(name = "H2InSite", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean h2InSite;

    // Hours 3
    @Column(name = "H3Work", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String h3Work = "";

    @Column(name = "H3Client", nullable = false, columnDefinition = "INT DEFAULT -1")
    private int h3Client = -1;

    @Column(name = "H3Project", nullable = false, columnDefinition = "INT DEFAULT -1")
    private int h3Project = -1;

    @Column(name = "H3Description", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String h3Description = "";

    @Column(name = "H3Hours", nullable = false, columnDefinition = "INT DEFAULT -1")
    private int h3Hours = -1;

    @Column(name = "H3InSite", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean h3InSite;

    // Hours 4
    @Column(name = "H4Work", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String h4Work = "";

    @Column(name = "H4Client", nullable = false, columnDefinition = "INT DEFAULT -1")
    private int h4Client = -1;

    @Column(name = "H4Project", nullable = false, columnDefinition = "INT DEFAULT -1")
    private int h4Project = -1;

    @Column(name = "H4Description", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String h4Description = "";

    @Column(name = "H4Hours", nullable = false, columnDefinition = "INT DEFAULT -1")
    private int h4Hours = -1;

    @Column(name = "H4InSite", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean h4InSite;

    @PrePersist
    protected void onCreate() {
        if (this.h1Work == null) this.h1Work = "";
        if (this.h1Client == -1) this.h1Client = -1;
        if (this.h1Project == -1) this.h1Project = -1;
        if (this.h1Description == null) this.h1Description = "";
        if (this.h1Hours == -1) this.h1Hours = -1;
        if (this.h1InSite == false) this.h1InSite = false;

        if (this.h2Work == null) this.h2Work = "";
        if (this.h2Client == -1) this.h2Client = -1;
        if (this.h2Project == -1) this.h2Project = -1;
        if (this.h2Description == null) this.h2Description = "";
        if (this.h2Hours == -1) this.h2Hours = -1;
        if (this.h2InSite == false) this.h2InSite = false;

        if (this.h3Work == null) this.h3Work = "";
        if (this.h3Client == -1) this.h3Client = -1;
        if (this.h3Project == -1) this.h3Project = -1;
        if (this.h3Description == null) this.h3Description = "";
        if (this.h3Hours == -1) this.h3Hours = -1;
        if (this.h3InSite == false) this.h3InSite = false;

        if (this.h4Work == null) this.h4Work = "";
        if (this.h4Client == -1) this.h4Client = -1;
        if (this.h4Project == -1) this.h4Project = -1;
        if (this.h4Description == null) this.h4Description = "";
        if (this.h4Hours == -1) this.h4Hours = -1;
        if (this.h4InSite == false) this.h4InSite = false;
    }

    // Constructors, equals, hashCode, etc.
}
