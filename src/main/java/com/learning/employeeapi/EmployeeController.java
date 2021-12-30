package com.learning.employeeapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class EmployeeController {

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private static List<Employee> employees = new ArrayList<>();


    static{
        Employee emp1 = new Employee() ;
        emp1.setFirstName("abhishek");
        emp1.setLastName("vishnoi");
        emp1.setOrganization("lizard");
        emp1.setPhone("91-9810-337170");

        Employee emp2 = new Employee() ;
        emp2.setFirstName("arushi");
        emp2.setLastName("goyal");
        emp2.setOrganization("lizard");
        emp2.setPhone("91-9953-827918");

        Employee emp3 = new Employee() ;
        emp3.setFirstName("bahu");
        emp3.setLastName("bali");
        emp3.setOrganization("lizard");
        emp3.setPhone("91-9953-812918");

        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);

    }

    @GetMapping("/getEmp/{id}")
    public Employee getEmployee(@PathVariable String id){
        logger.info("a request received to get employee with id :" + id);
        Employee emp = new Employee() ;
        emp.setFirstName("abhishek");
        emp.setLastName("vishnoi");
        emp.setOrganization("lizard");
        emp.setPhone("91-9810-337170");

        return emp;
    }


    @GetMapping("/getEmp")
    public List<Employee> getEmployees(){
        logger.info("a request received to get all employees");
        return employees;
    }

    @PostMapping("/addEmp")
    public void addEmployee(@RequestBody Employee emp) {
        logger.info("a request received to add a new employee");
        employees.add(emp);
    }




}
