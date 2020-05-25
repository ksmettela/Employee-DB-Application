package com.projects.Employees;


import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRev extends JpaRepository<Employee, Integer> {
}
