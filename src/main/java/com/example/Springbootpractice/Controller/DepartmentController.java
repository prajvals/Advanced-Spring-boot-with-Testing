package com.example.Springbootpractice.Controller;

import com.example.Springbootpractice.Entity.Department;
import com.example.Springbootpractice.Error.DepartmentNotFoundException;
import com.example.Springbootpractice.Service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    DepartmentService departmentService;//why we are using the service instead of directly using the repository is because
    //when we are in a real application, there is a business logic processing in this stage and then only after this we
    // return the response


    //@valid is used for the validation setting
    @PostMapping("/departments")
    private List<Department> saveDepartment(@Valid @RequestBody Department department) {
        return departmentService.saveDepartment(department);
//        departmentRepository.save(department);
//        System.out.println("the value recieved is "+department);
//        return departmentRepository.findAll();
    }

    @GetMapping("/departments")
    private List<Department> getDepartment() {
        LOGGER.info("Recieved the first request");
        return departmentService.getDepartment();
    }

    @GetMapping("/departments/{id}")
    private Department getDepartmentById(@PathVariable(value = "id") Long id) throws DepartmentNotFoundException {
        return departmentService.getDepartmentById(id);
    }

    //path variable name mentioned in the path and in the code should be the same
    @DeleteMapping("/departments/{id}")
    private List<Department> deleteDepartment(@PathVariable(value = "id") Long id) {
        return departmentService.deleteDepartmentByID(id);
    }

    //request params is actually the query parameter
    @PutMapping("/departmentsByMe/{id}")
    private List<Department> updateDepartment(@PathVariable(value = "id") Long id, @RequestParam(name = "name") String departmentName) {
        return departmentService.updateDepartment(id, departmentName);
    }

    @PutMapping("departments/{id}")
    private List<Department> updateDepartment(@PathVariable(value = "id") Long id, @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }

    @GetMapping("/departments/name")
    private Department getDepartmentByName(@RequestParam(name = "departmentName") String departmentName) {
        System.out.println("departmentName = " + departmentName);
        return departmentService.getDepartmentByName(departmentName);

    }
}
