package com.satge.satge.Repository;

import com.satge.satge.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByEmail(String email);
    Employee findByFirstNameAndLastName(String firstName, String lastName);
}
