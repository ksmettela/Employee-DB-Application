package com.projects.Employees;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {
    @Autowired
    private EmpRev rep;

    public List<Employee> getAllEmp(){
        return rep.findAll();
    }

    public void loadEmp(Employee e) {
        rep.save(e);
    }

    public Optional<Employee> getEmpById(int empId) {
        return rep.findById(empId);
    }

    public ResponseEntity<Employee> updateEmp(Employee e, int empId) {
        //return rep.save(e);
        final Employee updatedEmployee = rep.save(e);
        return ResponseEntity.ok(updatedEmployee);
    }

    public void deleteEmp(Employee e,int empId) {
        rep.delete(e);
    }

}