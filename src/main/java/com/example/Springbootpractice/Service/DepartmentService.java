package com.example.Springbootpractice.Service;

import com.example.Springbootpractice.Entity.Department;

import java.util.List;

public interface DepartmentService {
    public List<Department> saveDepartment(Department department);
}
