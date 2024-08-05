package com.satge.satge.Service;

import com.satge.satge.DTO.WorkDayUpdateDTO;
import com.satge.satge.Entity.WorkDay;
import com.satge.satge.Entity.WorkDayId;
import com.satge.satge.Repository.WorkDayRepository;
import com.satge.satge.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Optional;

@Service
public class WorkDayService {

    @Autowired
    private WorkDayRepository workDayRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public void updateWorkDay(WorkDayUpdateDTO workDayUpdateDTO) {
        WorkDayId workDayId = new WorkDayId(workDayUpdateDTO.getDate(), workDayUpdateDTO.getEmployeeId());
        Optional<WorkDay> optionalWorkDay = workDayRepository.findById(workDayId);

        WorkDay workDay;
        if (optionalWorkDay.isPresent()) {
            workDay = optionalWorkDay.get();
        } else {
            workDay = new WorkDay();
            workDay.setDate(workDayUpdateDTO.getDate());
            workDay.setEmployeeId(workDayUpdateDTO.getEmployeeId());
        }

        switch (workDayUpdateDTO.getHourBlock()) {
            case "H1":
                workDay.setH1Work(workDayUpdateDTO.getWork());
                workDay.setH1Client(workDayUpdateDTO.getClient());
                workDay.setH1Project(workDayUpdateDTO.getProject());
                workDay.setH1Description(workDayUpdateDTO.getDescription());
                workDay.setH1Hours(workDayUpdateDTO.getHours());
                workDay.setH1InSite(workDayUpdateDTO.isInSite());
                break;
            case "H2":
                workDay.setH2Work(workDayUpdateDTO.getWork());
                workDay.setH2Client(workDayUpdateDTO.getClient());
                workDay.setH2Project(workDayUpdateDTO.getProject());
                workDay.setH2Description(workDayUpdateDTO.getDescription());
                workDay.setH2Hours(workDayUpdateDTO.getHours());
                workDay.setH2InSite(workDayUpdateDTO.isInSite());
                break;
            case "H3":
                workDay.setH3Work(workDayUpdateDTO.getWork());
                workDay.setH3Client(workDayUpdateDTO.getClient());
                workDay.setH3Project(workDayUpdateDTO.getProject());
                workDay.setH3Description(workDayUpdateDTO.getDescription());
                workDay.setH3Hours(workDayUpdateDTO.getHours());
                workDay.setH3InSite(workDayUpdateDTO.isInSite());
                break;
            case "H4":
                workDay.setH4Work(workDayUpdateDTO.getWork());
                workDay.setH4Client(workDayUpdateDTO.getClient());
                workDay.setH4Project(workDayUpdateDTO.getProject());
                workDay.setH4Description(workDayUpdateDTO.getDescription());
                workDay.setH4Hours(workDayUpdateDTO.getHours());
                workDay.setH4InSite(workDayUpdateDTO.isInSite());
                break;
            default:
                throw new IllegalArgumentException("Invalid hour block: " + workDayUpdateDTO.getHourBlock());
        }

        workDayRepository.save(workDay);
    }

    public WorkDay getWorkDay(String dateStr, int employeeId) {
        try {
            Date date = Date.valueOf(dateStr);

            WorkDayId workDayId = new WorkDayId(date, employeeId);
            Optional<WorkDay> optionalWorkDay = workDayRepository.findById(workDayId);

            return optionalWorkDay.orElse(null);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<WorkDay> getByEmpAndDateRange(String email, String startDateStr, String endDateStr) {
        try {
            Integer employeeId = getEmployeeIdByEmail(email);
            Date startDate = Date.valueOf(startDateStr);
            Date endDate = Date.valueOf(endDateStr);

            return workDayRepository.findByEmployeeIdAndDateBetween(employeeId, startDate, endDate);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Integer getEmployeeIdByEmail(String email) {
        return employeeRepository.findByEmail(email).getEmployeeId();
    }

    public List<WorkDay> getWorkDaysForWeek(int employeeId) {
        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        LocalDate endOfWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));

        return workDayRepository.findByEmployeeIdAndDateBetween(employeeId, Date.valueOf(startOfWeek), Date.valueOf(endOfWeek));
    }

    public List<WorkDay> getWorkDaysForWeekByStartDay(String email, String startDayOfWeekStr) {
        try {
            Integer employeeId = getEmployeeIdByEmail(email);
            LocalDate startDayOfWeek = LocalDate.parse(startDayOfWeekStr, DateTimeFormatter.ISO_DATE);
            LocalDate endDayOfWeek = startDayOfWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));

            return workDayRepository.findByEmployeeIdAndDateBetween(employeeId, Date.valueOf(startDayOfWeek), Date.valueOf(endDayOfWeek));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }
    }
}
