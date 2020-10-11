package kz.karyakin.employeeservice.controller;

import kz.karyakin.employeeservice.model.dto.EmployeeDTO;
import kz.karyakin.employeeservice.model.entity.Employee;
import kz.karyakin.employeeservice.repository.EmployeeRepository;
import kz.karyakin.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;

    private static final String EMPLOYEE = "/employee";
    private static final String GET_EMPLOYEE = EMPLOYEE + "/{id}";
    private static final String GET_EMPLOYEES = EMPLOYEE + "/list";

    @GetMapping(GET_EMPLOYEE)
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK);
    }

    @GetMapping(GET_EMPLOYEES)
    public ResponseEntity<List<Employee>> getEmployees(){
        return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(EMPLOYEE)
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        return new ResponseEntity<>(employeeService.addEmployee(employeeDTO), HttpStatus.CREATED);
    }

}
