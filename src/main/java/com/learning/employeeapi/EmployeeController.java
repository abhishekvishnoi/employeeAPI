package com.learning.employeeapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpResponse;
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
        emp3.setFirstName("shakti");
        emp3.setLastName("man");
        emp3.setOrganization("lizard");
        emp3.setPhone("91-9953-812918");

        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);

    }

    @GetMapping("/getEmp/{id}")
    public Employee getEmployee(@PathVariable String id, final HttpServletResponse response){
        logger.info("a request received to get employee with id :" + id);
        Employee emp = new Employee() ;
        emp.setFirstName("abhishek");
        emp.setLastName("vishnoi");
        emp.setOrganization("lizard");
        emp.setPhone("91-9810-337170");

        response.setHeader("user" , "abhishekvishnoi");

        return emp;
    }


    @GetMapping("/getEmp")
    public List<Employee> getEmployees(final HttpServletResponse response){
        logger.info("a request received to get all employees");
        response.setHeader("user" , "abhishekvishnoi");
        return employees;
    }


    @GetMapping("/browseEmp")
    public List<Employee> browseEmployees(final HttpServletResponse response) throws Exception {

        try{
            logger.info("a request received to get all employees");
            response.setHeader("user" , "abhishekvishnoi");

            if(Math.random() >= 0.45)
            {
             throw new Exception("an exception occured...!!");
            }

        }catch(Exception exp){
            logger.info("a request received to get all employees");
            throw new Exception("an exception occured...!!");
        }
        return employees;
    }

    @PostMapping("/addEmp")
    public void addEmployee(@RequestBody Employee emp) {
        logger.info("a request received to add a new employee");
        employees.add(emp);
    }




}
