package com.skypro.employeemap;

import com.skypro.employeemap.exception.EmployeeExistsException;
import com.skypro.employeemap.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceMapImpl implements EmployeeMapService {

    private Map<String, Employee> employees = new HashMap<>();

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee addingEmployee = new Employee(firstName, lastName);

        String key = firstName +lastName;

        if (employees.containsKey(key)) {
            throw new EmployeeExistsException("Этот сотрудник уже добавлен");
        }
        employees.put(key, addingEmployee);
        return addingEmployee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        String key = firstName + lastName;

        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("Этот сотрудник не найден");
        }
        return employees.remove(key);
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        String key = firstName + lastName;

        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("Этот сотрудник не найден");
        }
        return employees.get(key);
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }
}

