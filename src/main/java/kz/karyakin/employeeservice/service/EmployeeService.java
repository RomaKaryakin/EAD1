package kz.karyakin.employeeservice.service;

import kz.karyakin.employeeservice.model.entity.Employee;
import kz.karyakin.employeeservice.model.dto.EmployeeDTO;
import kz.karyakin.employeeservice.repository.EmployeeRepository;
import kz.karyakin.employeeservice.util.ExceptionUtils;
import kz.karyakin.employeeservice.util.MessageCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ExceptionUtils exceptionUtils;

    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO){
        Employee employee = new Employee();
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setSalary(employeeDTO.getSalary());
        employee.setBirthDate(employeeDTO.getBirthDate());

        employee = employeeRepository.save(employee);
        employeeDTO.setId(employee.getId());

        return employeeDTO;

    }

    public Employee getEmployee(Long id){

        if(!employeeRepository.existsById(id)){
            exceptionUtils.throwDefaultException(MessageCode.EMPLOYEE_DOES_NOT_EXISTS);
        }

        return employeeRepository.findById(id).get();

    }



}
