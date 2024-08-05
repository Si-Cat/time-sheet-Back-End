package com.satge.satge.Controller;

import com.satge.satge.Entity.Employee;
import com.satge.satge.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeControllers {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/signup")
    public Employee addEmployee(@RequestBody Employee employee) {
        System.out.println("Received Employee: " + employee); // Debugging statement
        return employeeService.addEmployee(employee);
    }

//    @GetMapping
//    public List<Employee> getAllEmployees() {
//        return employeeService.getAllEmployees();
//    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email");
        String password = loginData.get("password");

        String userEmail = employeeService.login(email, password);
        Map<String, String> response = new HashMap<>();

        if (userEmail != null) {
            response.put("status", "success");
            response.put("email", userEmail);
        } else {
            response.put("status", "failure");
        }

        return response;
    }
}
