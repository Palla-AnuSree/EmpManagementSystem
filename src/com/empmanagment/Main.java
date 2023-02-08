package com.empmanagment;

import java.util.Scanner;

public class Main {
     public static void main(String[]args)
     {
    	 String name;
    	 int id;
    	 EmployeeDeoInterf dao=new EmployeeDaoImp();
    	System.out.println("WELCOME TO EMPLOYEE MANAGEMENT APPLICATION!!"); 
       Scanner sc=new Scanner(System.in);
    	do {
        	System.out.println("1.Add Employee\n"+
                    "2.Show All Employee\n"+
        			"3.Show Employee based on id\n"+
                    "4.Update the Employee\n"+
                    "5.Delete Employee\n");
        	System.out.println("ENTER CHOICE :");
        	int ch=sc.nextInt();
        	switch(ch) {
        	case 1:
        		Employee emp=new Employee();
        		System.out.println("Enter ID ");
        		 id=sc.nextInt();
        		System.out.println("Enter name  ");
        	     name=sc.next();
        		System.out.println("Enter salary ");
        		double salary=sc.nextDouble();
        		System.out.println("Enter age ");
        		int age=sc.nextInt();
        		emp.setId(id);
        		emp.setName(name);
        		emp.setSalary(salary);
        		emp.setAge(age);
        		dao.createEmployee(emp);
        		break;
        	case 2:
        		dao.showAllEmployee();
        		break;
        	case 3:
        		System.out.println("ENTER ID TO SHOW THE DETAILS");
        		int empid=sc.nextInt();
        		dao.showEmployeeBasedOnId(empid);
        		break;
        	case 4:
        		System.out.println("ENTER ID TO TO UPDATE DETAILS");
        	    empid=sc.nextInt();
        		System.out.println("ENTER THE NEW NAME");
        		sc.nextLine();
        		name=sc.nextLine();
        		dao.updateEmployee(empid, name);
        		break;
        	case 5:
        		System.out.println("ENTER THE ID TO DELETE");
        	    empid=sc.nextInt();
        	    dao.deleteEmployee(empid);
        		break;
        	case 6:
        		System.out.println("Thank you for using our application!!");
        		System.exit(0);
        	default:
        		System.out.println("Enter valid choice!!");
        		id=sc.nextInt();
        		dao.deleteEmployee(id);
        		break;
        	}
        	
        	
        }while(true);
     
     
     }
	
}
