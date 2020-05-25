package com.projects.Employees;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class EmpController {

    @Autowired
    private EmpService serv;

    @GetMapping("/employee")
    public List<Employee> getAllEmp(){
        return serv.getAllEmp();
    }
    @PostMapping("/employee")
    public void loadStudents(@Valid @RequestBody Employee e) {
        serv.loadEmp(e);
    }
    @GetMapping("/employee/{empId}")
    public ResponseEntity<Employee> getEmpById(@PathVariable int empId)throws ResourceNotFoundException {
        Employee employee = serv.getEmpById(empId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + empId));
        return ResponseEntity.ok().body(employee);
    }

    @PutMapping("/employee/{empId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int empId,
                                             @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = serv.getEmpById(empId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + empId));
    serv.updateEmp(employeeDetails,empId);
        return ResponseEntity.ok(employee);
    }
    @DeleteMapping("/employee/{empId}")
    public Map<String, Boolean> deleteEmployee(@PathVariable int empId)
            throws ResourceNotFoundException {
        Employee employee = serv.getEmpById(empId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + empId));

        serv.deleteEmp(employee,empId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
