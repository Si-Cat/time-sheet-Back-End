package com.satge.satge.Entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Getter
@Setter
public class WorkDayId implements Serializable {
    private Date date;
    private int employeeId;

    public WorkDayId() {}

    public WorkDayId(Date date, int employeeId) {
        this.date = date;
        this.employeeId = employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkDayId that = (WorkDayId) o;
        return employeeId == that.employeeId &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, employeeId);
    }
}

