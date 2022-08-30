package com.example.Springbootpractice.Service;

import com.example.Springbootpractice.Entity.Department;
import com.example.Springbootpractice.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImp implements DepartmentService{

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public List<Department> saveDepartment(Department department) {
         departmentRepository.save(department);
         return departmentRepository.findAll();
    }

    @Override
    public List<Department> getDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).get();
    }

    @Override
    public List<Department> deleteDepartmentByID(Long id) {
        departmentRepository.deleteById(id);
        return departmentRepository.findAll();
    }

    @Override
    public List<Department> updateDepartment(Long id, String departmentName) {
        if(departmentRepository.existsById(id))
        {
            Department department = departmentRepository.findById(id).get();
            department.setDepartmentName(departmentName);
            departmentRepository.save(department);
        }
        else {
            throw new IllegalStateException("the instance is not available");
        }
        return departmentRepository.findAll();
    }
}
