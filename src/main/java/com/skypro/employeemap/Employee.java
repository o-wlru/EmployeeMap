package com.skypro.employeemap;

import java.util.Objects;

public class Employee {

    private String firstName;
    private String lastName;


    public Employee(String latName, String firstName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    @Override
    public boolean equals(Object other) {
        if (this.getClass() != other.getClass()) {
            return false;
        }
        Employee employee = (Employee) other;
        return Objects.equals(lastName, employee.lastName) && Objects.equals(firstName, employee.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName);
    }
    @Override
    public String toString() {
        return "Employee: " + " lastname=" + lastName + " firstname=" + firstName;
    }

}
