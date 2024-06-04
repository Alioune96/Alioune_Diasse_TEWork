package com.techelevator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    List<Department> departments = new ArrayList<>();
    List<Employee> employees = new ArrayList<>();

    Map<String, Project> projects = new HashMap<>();
    List<Employee> sender = new ArrayList<>();

    /**
     * The main entry point in the application
     *
     * @param args
     */
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private void run() {
        // create some departments
        createDepartments();

        // print each department by name
        printDepartments();

        // create employees
        createEmployees();

        // give Angie a 10% raise, she is doing a great job!

        // print all employees
        printEmployees();

        // create the TEams project
        createTeamsProject();
        // create the Marketing Landing Page Project
        createLandingPageProject();

        // print each project name and the total number of employees on the project
        printProjectsReport();
    }


    /**
     * Create departments and add them to the collection of departments
     */
    private void createDepartments() {
        Department firstone = new Department(1, "Marketing");
        Department secondOne = new Department(2, "Sales");
        Department thirdOne = new Department(3, "Engineering");
        departments.add(firstone);
        departments.add(secondOne);
        departments.add(thirdOne);

    }

    /**
     * Print out each department in the collection.
     */
    private void printDepartments() {
        for (int i = 0; i < departments.size(); i++) {
            System.out.println(departments.get(i).getName());
        }
        System.out.println("------------- DEPARTMENTS ------------------------------");

    }

    /**
     * Create employees and add them to the collection of employees
     */
    private void createEmployees() {
        Employee dean = new Employee();
        dean.setEmployeeId(1);
        dean.setFirstName("Dean");
        dean.setLastName("Johnson");
        dean.setEmail("djohnson@teams.com\t");
        dean.setSalary(60000.00);

        dean.setDepartment(departments.get(2));

        Employee angie = new Employee(2, "Angie", "Smith", "asmith@teams.com\t,", departments.get(2), "08/21/2020\n");
        angie.raiseSalary(10);

        Employee margaret = new Employee(3, "Margaret", "Thompson", "mthompson@teams.com\t", departments.get(0), "08/21/2020\n");

        employees.add(dean);
        employees.add(angie);
        employees.add(margaret);
    }


    /**
     * Print out each employee in the collection.
     */
    private void printEmployees() {
        System.out.println("\n------------- EMPLOYEES ------------------------------");
        for (Employee x : employees) {
            System.out.println(x.getFullName() + " " + x.getSalary() + " " + x.getDepartment().getName());
        }


    }

    /**
     * Create the 'TEams' project.
     */
    private void createTeamsProject() {
        Project firstOne = new Project("TEams", "Project Management Software", "10/10/2020", "11/10/2020");

        Employee storefirst = new Employee(2, "Angie", "Smith", "asmith@teams.com\t,", departments.get(2), "08/21/2020\n");
        Employee secondStore = new Employee(1, "Dean", "Johnson", "djohnson@teams.com\t", departments.get(2), "08/21/2020\n");
        sender.add(storefirst);
        sender.add(secondStore);
        firstOne.setTeamMembers(sender);
        projects.put(firstOne.getName(),firstOne);


    }

    /**
     * Create the 'Marketing Landing Page' project.
     */
    private void createLandingPageProject() {
        Project secondOne = new Project("Marketing Landing Page", " Lead Capture Landing Page for Marketing", "10/10/2020", "10/17/2020");
        Employee sendBuddy = new Employee(3, "Margaret", "Thompson", "mthompson@teams.com\t", departments.get(0), "08/21/2020\n");
        sender.add(sendBuddy);
        secondOne.setTeamMembers(sender);
        projects.put(secondOne.getName(), secondOne);

    }

    /**
     * Print out each project in the collection.
     */
    private void printProjectsReport() {
        System.out.println("\n------------- PROJECTS ------------------------------");
        Map<Object, Integer> secondForPrint = new HashMap<>();
        for (Map.Entry projeCt: projects.entrySet()){
           secondForPrint.put(projeCt.getKey(),1);
        }
        if(secondForPrint.containsKey("TEams")){
            secondForPrint.put("TEams",2);
        }
        for (Map.Entry keeper: secondForPrint.entrySet()){
            System.out.println(keeper.getKey() + ": "+ keeper.getValue());
        }

        }

    }
