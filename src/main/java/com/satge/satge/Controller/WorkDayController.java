package com.satge.satge.Controller;

import com.satge.satge.DTO.WorkDayUpdateDTO;
import com.satge.satge.Entity.WorkDay;
import com.satge.satge.Service.WorkDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workday")
public class WorkDayController {

    @Autowired
    private WorkDayService workDayService;

    @PostMapping("/update")
    public void updateWorkDay(@RequestBody WorkDayUpdateDTO workDayUpdateDTO) {
        String userEmail = workDayUpdateDTO.getEmail();
        if (userEmail != null) {
            Integer employeeId = workDayService.getEmployeeIdByEmail(userEmail);
            workDayUpdateDTO.setEmployeeId(employeeId);
            workDayService.updateWorkDay(workDayUpdateDTO);
        } else {
            throw new RuntimeException("User email not provided");
        }
    }

    @GetMapping("/get")
    public WorkDay getWorkDay(@RequestParam("date") String date, @RequestParam("employeeId") int employeeId) {
        return workDayService.getWorkDay(date, employeeId);
    }

    @GetMapping("/getRange")
    public List<WorkDay> getByEmpAndDateRange(@RequestParam("email") String email,
                                              @RequestParam("startDate") String startDate,
                                              @RequestParam("endDate") String endDate) {
        return workDayService.getByEmpAndDateRange(email, startDate, endDate);
    }

    @GetMapping("/getWeek")
    public List<WorkDay> getWorkDaysForWeek(@RequestParam("email") String email) {
        Integer employeeId = workDayService.getEmployeeIdByEmail(email);
        return workDayService.getWorkDaysForWeek(employeeId);
    }

    @GetMapping("/getMap")
    public List<WorkDay> getWorkDaysForWeekByStartDay(@RequestParam("email") String email,
                                                      @RequestParam("startDayOfWeek") String startDayOfWeek) {
        return workDayService.getWorkDaysForWeekByStartDay(email, startDayOfWeek);
    }
}
