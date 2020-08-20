package com.atlhq.cache.controller;

import com.atlhq.cache.bean.Employee;
import com.atlhq.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id){
        return employeeService.getEmp(id);
    }
    @GetMapping("/emp")
    public Employee upd(Employee employee){
        Employee emp = employeeService.updEmp(employee);
        return emp;
    }
    @GetMapping("/delEmp")
    public String delEmp(Integer id){
        employeeService.delEmp(id);
        return "success";
    }
    @GetMapping("/emp/lastName/{lastName}")
    public Employee getEmpByLastName(@PathVariable(value = "lastName")String lastName){
        return employeeService.getEmpByLastName(lastName);
    }
}
