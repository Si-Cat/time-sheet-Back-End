package com.satge.satge.Service;

import com.satge.satge.Entity.Employee;
import com.satge.satge.Repository.EmployeeRepository;
import com.satge.satge.Utils.EncryptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        try {
            employee.setPassword(EncryptionUtils.encrypt(employee.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
            // handle encryption error
        }
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            try {
                employee.setPassword(EncryptionUtils.decrypt(employee.getPassword()));
            } catch (Exception e) {
                e.printStackTrace();
                // handle decryption error
            }
        }
        return employee;
    }

    public Employee findByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    public String login(String email, String password) {
        Employee employee = findByEmail(email);
        if (employee != null) {
            try {
                String decryptedPassword = EncryptionUtils.decrypt(employee.getPassword());
                if (decryptedPassword.equals(password)) {
                    return employee.getEmail();
                }
            } catch (Exception e) {
                e.printStackTrace();
                // handle decryption error
            }
        }
        return null;
    }

    public Employee findByFullName(String firstName, String lastName) {
        return employeeRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public boolean changePermissionByEmail(String email, boolean permission) {
        Employee employee = employeeRepository.findByEmail(email);
        if (employee != null) {
            employee.setPermission(permission);
            employeeRepository.save(employee);
            return true;
        }
        return false;
    }

    public boolean changePermissionByName(String firstName, String lastName, boolean permission) {

        Employee employee = employeeRepository.findByFirstNameAndLastName(firstName, lastName);
        if (employee != null) {
            employee.setPermission(permission);
            employeeRepository.save(employee);
            return true;
        }
        return false;
    }

    public Boolean getPermissionByEmail(String email) {
        Employee employee = employeeRepository.findByEmail(email);
        return (employee != null) ? employee.isPermission() : null;
    }
}
