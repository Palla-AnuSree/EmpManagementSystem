package com.empmanagment;

import java.sql.*;

public class EmployeeDaoImp implements EmployeeDeoInterf {
     
	Connection con;
	 PreparedStatement ps;
	@Override
	public void createEmployee(Employee emp) {
		 con=DBConnection.createDBConnection();
		 String query="Insert into employee values(?,?,?,?)";
	   try
	   {
		   
		ps=con.prepareStatement(query);
		ps.setInt(1,emp.getId());
		ps.setString(2,emp.getName());
		ps.setDouble(3,emp.getSalary());
		ps.setInt(4, emp.getAge());
		int cnt=ps.executeUpdate();
		if(cnt!=0)
			System.out.println("Employee Inserted Successfully!!");
	   } 
	   catch (Exception e)
	   {
		e.printStackTrace();
	   }
	   finally
	   {
		   try 
		   {
			   if(ps!=null)
			   ps.close();
			   if(con!=null)
			   con.close();  
		   }
		   catch (SQLException e) 
		   {
			e.printStackTrace();
		   }
		   
	   }
	}

	@Override
	public void showAllEmployee() {
		con=DBConnection.createDBConnection();
		String query="select * from employee";
		System.out.println("Employee Details :");
		System.out.format("%s\t%s\t%s\t%s\n","ID","NAME","SALARY","AGE");
		System.out.println("---------------------------");
		try {
			Statement s=con.createStatement();
			ResultSet result=s.executeQuery(query);
			while(result.next())
			{
				System.out.format("%d\t%s\t%f\t%d\n", 
						result.getInt(1),
						result.getString(2),
						result.getDouble(3),
						result.getInt(4));
				System.out.println("--------------------------------");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void showEmployeeBasedOnId(int id) {
		con=DBConnection.createDBConnection();
		String query="select * from employee where id="+id;
		try {
			Statement s=con.createStatement();
			ResultSet result=s.executeQuery(query);
			while(result.next())
			{
				System.out.format("%d\t%s\t%f\t%d\n", 
						result.getInt(1),
						result.getString(2),
						result.getDouble(3),
						result.getInt(4));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateEmployee(int id, String name) {
		con=DBConnection.createDBConnection();
		String query="update employee set name=? where id=?";
		try 
		{
			ps=con.prepareStatement(query);
			ps.setString(1,name);
			ps.setInt(2,id);
			int cnt=ps.executeUpdate();
			if(cnt!=0)
				System.out.println("Employee Details updated successfully!!!");
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void deleteEmployee(int id) {
		con=DBConnection.createDBConnection();
		String query="delete from employee where id=?";
		try
		{
			ps=con.prepareStatement(query);
			ps.setInt(1, id);
			int cnt=ps.executeUpdate();
		    if(cnt!=0)
		    {
		    	System.out.println("Employee Deleted Successfully!!!");
		    	
		    }
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}

}
