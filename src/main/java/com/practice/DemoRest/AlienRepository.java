package com.practice.DemoRest;
//D:\Executables\apache-tomcat-6.0.53\bin
import java.sql.Connection;
import com.practice.DemoRest.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlienRepository 
{
	//List<Alien> alians = new ArrayList<Alien>();

	Connection con = null;
public AlienRepository() 
	{ 	
	try
	{
	Class.forName("oracle.jdbc.driver.OracleDriver") ;
	//con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
	con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
	
	System.out.println("Connected from AlienRepository.java Class !!!");
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	}

public List<Alien> getAllAlians()
{
	/*try
	{
	Class.forName("oracle.jdbc.driver.OracleDriver") ;
	//con= DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","scott","tiger");
	con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
	System.out.println("Connected !!!");
	}
	catch(Exception e)
	{
		System.out.println(e);
	}*/
	
	List <Alien> aliens = new ArrayList<Alien>();
	
	String sql = "select * from alien"; 
	
	try
	{
		System.out.println("Getting All Alien... !!!");
		Connection con = null;
		Class.forName("oracle.jdbc.driver.OracleDriver") ;
		//con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while (rs.next())
		{
			Alien a = new Alien();
			a.setId(rs.getInt(1));
			a.setName(rs.getString(2));
			a.setPoints(rs.getInt(3));
			aliens.add(a);
		}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}

	return aliens;
	
}

public Alien getAlian(int identity) {

String sql = "select * from alien where id=" +identity; 
Alien a = new Alien();
	try
	{
		System.out.println("Getting An Alien With Perticular ID... !!!");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		if(rs.next())
		{
			a.setId(rs.getInt(1));
			a.setName(rs.getString(2));
			a.setPoints(rs.getInt(3));
		}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}

	return a;
}

public void create(Alien a1) {
	String sql = "insert into alien values(?,?,?)"; 

	try
	{
		System.out.println("Creating An Alien... !!!");
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, a1.getId());
		pst.setString(2, a1.getName());
		pst.setInt(3, a1.getPoints());
		pst.executeUpdate();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}	
}


public void updateDB(Alien a1) {
	String sql = "update alien set name= ?, points= ? where id=?" ; 

	try
	{
		System.out.println("Creating An Alien... !!!");
		PreparedStatement pst = con.prepareStatement(sql);
		
		pst.setString(1, a1.getName());
		pst.setInt(2, a1.getPoints());
		pst.setInt(3, a1.getId());
		pst.executeUpdate();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}	
}

public void delete(int id) 
{

	String sql = "delete from  alien where id=?" ; 

	try
	{
		System.out.println("Deleting from Alien Database... !!!");
		PreparedStatement pst = con.prepareStatement(sql);
		
		pst.setInt(1, id);
		//pst.setString(1, a1.getName());
	int count=	pst.executeUpdate();
		System.out.println(count+"Records Deleted Successfully !!!");
	}
	catch(Exception e)
	{
		System.out.println(e);
	}	
	
}
}
