package com.techelevator;

public class Employee {
   private int employeeId;
    private String firstName;
    private String lastName;
    private String getFirstName;
    private String department;

    private double annualSalary;

    public Employee(int employeeId,String firstName, String lastName, double annualSalary ) {
        this.employeeId = employeeId;
        this.firstName=firstName;
        this.lastName=lastName;
        this.annualSalary=annualSalary;
    }

    public void setLastName(String lastplease) {
        this.lastName = lastplease;
    }

    public void setDepartment(String theyone) {
        this.department = theyone;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return lastName+ ", " +firstName;
    }

    public String getDepartment() {
        return department;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void raiseSalary(double percent){
        double fornow = percent/100;
        double ofcourse  = annualSalary*fornow;
        this.annualSalary= annualSalary+ofcourse;
    }
}
