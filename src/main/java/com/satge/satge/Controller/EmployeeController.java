package com.satge.satge.Controller;

import com.satge.satge.Entity.Employee;
import com.satge.satge.Repository.EmployeeRepository;
import com.satge.satge.Service.EmployeeService;
import com.satge.satge.DTO.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/signup")
    public Employee addEmployee(@RequestBody Employee employee) {
        System.out.println("Received Employee: " + employee); // Debugging statement
        return employeeService.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest loginData) {
        String email = loginData.getEmail();
        System.out.println("Received LoginRequest: " + loginData);
        String password = loginData.getPassword();
        String userEmail = employeeService.login(email, password);
        Map<String, String> response = new HashMap<>();
        if (userEmail != null) {
            response.put("status", "success");
            response.put("email", userEmail);
        } else {
            System.out.println("Email or password is incorrect");
            response.put("status", "failure");
        }
        return response;
    }

    @GetMapping("/names")
    public List<String> getFullNames() {
        List<Employee> employees = employeeService.getAllEmployees();
        return employees.stream()
                .map(employee -> employee.getFirstName() + " " + employee.getLastName())
                .collect(Collectors.toList());
    }

    @GetMapping("/emailfullname")
    public String getEmailByFullName(@RequestParam String fullName) {
        String[] nameParts = fullName.split(" ");
        if (nameParts.length < 2) {
            return "Invalid full name provided";
        }
        String firstName = nameParts[0];
        String lastName = nameParts[nameParts.length - 1];
        Employee employee = employeeService.findByFullName(firstName, lastName);
        return (employee != null) ? employee.getEmail() : "Employee not found";
    }

    @GetMapping("/change-permission")
    public String changeEmployeePermissionByEmail(@RequestParam String email) {
        boolean result = employeeService.changePermissionByEmail(email, false);
        return result ? "Permission changed successfully" : "Employee not found";
    }

    @PostMapping("/changepermission")
    public String changeEmployeePermissionByName(@RequestParam String fullName) {
        String[] nameParts = fullName.split(" ");
        if (nameParts.length < 2) {
            return "Invalid full name provided";
        }
        String firstName = nameParts[0];
        String lastName = nameParts[nameParts.length - 1];
        Employee employee = employeeService.findByFullName(firstName, lastName);
        if (employee != null) {
            employee.setPermission(true);
            employeeRepository.save(employee);
            return "Permission changed successfully";
        } else {
            return "Employee not found";
        }
    }

    @GetMapping("/permission")
    public Map<String, Boolean> getEmployeePermissionByEmail(@RequestParam String email) {
        Boolean permission = employeeService.getPermissionByEmail(email);
        Map<String, Boolean> response = new HashMap<>();
        response.put("permission", permission);
        return response;
    }
}
