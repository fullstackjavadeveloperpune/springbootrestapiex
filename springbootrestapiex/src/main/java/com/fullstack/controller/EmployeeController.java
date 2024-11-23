package com.fullstack.controller;

import com.fullstack.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    List<Employee> employeeList = Stream.of(new Employee(121, "SWARA", 96000.22),
            new Employee(122, "LAKSHMI", 95000.22),
            new Employee(111, "DARSHAN", 91000.22),
            new Employee(110, "APARNA", 93000.22),
            new Employee(151, "LAKSHMI", 97000.22)).toList();


    @GetMapping("/sortbyid")
    public ResponseEntity<List<Employee>> sortById() {
        return ResponseEntity.ok(employeeList.stream().sorted(Comparator.comparing(Employee::getEmpId).reversed()).toList());
    }

    @GetMapping("/sortbyname")
    public ResponseEntity<List<Employee>> sortByName() {
        return ResponseEntity.ok(employeeList.stream().sorted(Comparator.comparing(Employee::getEmpName).reversed()).toList());
    }

    @GetMapping("/sortbysalarydesc")
    public ResponseEntity<List<Employee>> sortBySalaryDesc() {
        return ResponseEntity.ok(employeeList.stream().sorted(Comparator.comparing(Employee::getEmpSalary).reversed()).toList());
    }

    @GetMapping("/findbyname/{empName}")
    public ResponseEntity<List<Employee>> findByName(@PathVariable String empName) {
        return ResponseEntity.ok(employeeList.stream().filter(emp -> emp.getEmpName().equals(empName)).toList());
    }


}
