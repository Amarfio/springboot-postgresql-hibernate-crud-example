package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ("/employee/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeRespository employeeRespository;

    //get employees : get all employees records saved in the database
    @GetMapping("/employees")
    public List<Employee> getAllEmployee(){
        return this.employeeRespository.findAll();
    }

    //get employee by id : get a particular employee details by the specified id
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") Long employeeId) throws ResourceNotFoundException {
        Employee employee = employeeRespository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee not found for this id::"+ employeeId));
        return ResponseEntity.ok().body(employee);
    }

    //save employee: post new employee details
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return this.employeeRespository.save(employee);
    }

    //update employee: post to edit employee details by a specified id
    @PutMapping("/employees/{id}")
    public ResponseEntity updateEmployee(@PathVariable(value="id") Long employeeId, @Validated @RequestBody Employee employeeDetails) throws ResourceNotFoundException{
        Employee employee = employeeRespository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee not found for this id::"+ employeeId));
        employee.setEmail(employeeDetails.getEmail());
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());

        return ResponseEntity.ok(this.employeeRespository.save(employee));
    }

    //delete employee: remove employee details from the database by a specified id
    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value="id") Long employeeId) throws ResourceNotFoundException{
        Employee employee = employeeRespository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee not found for this id ::"+ employeeId));
        this.employeeRespository.delete(employee);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}
