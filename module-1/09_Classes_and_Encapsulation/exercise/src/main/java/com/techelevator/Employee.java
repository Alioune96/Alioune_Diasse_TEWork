package com.techelevator;

public class Employee {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String fullName;
    private String department;
    private double annualSalary;

    public Employee(int employeeId, String firstName,String lastName, double annualSalary) {
        this.employeeId = employeeId;
        this.lastName=lastName;
        this.annualSalary=annualSalary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void raiseSalary(double annualSalary){
       double resulted = annualSalary+.05;
       this.annualSalary=resulted;
    }

    public void getFirstName(String gether){
        this.firstName=gether;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return lastName+firstName;
    }

    public String getDepartment() {
        return department;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }
}
