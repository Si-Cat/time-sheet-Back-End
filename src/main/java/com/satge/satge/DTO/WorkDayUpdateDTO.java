package com.satge.satge.DTO;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class WorkDayUpdateDTO {
    private String email;
    private int employeeId;
    private Date date;
    private String hourBlock;
    private String work;
    private int client;
    private int project;
    private String description;
    private int hours;
    private boolean inSite;
}
