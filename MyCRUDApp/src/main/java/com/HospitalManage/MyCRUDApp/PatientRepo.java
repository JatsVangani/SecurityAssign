package com.HospitalManage.MyCRUDApp;

import java.sql.Connection; 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




@Component
public class PatientRepo {
	
	private static Logger logger= LoggerFactory.getLogger(PatientRepo.class);
	
	private static Connection con;
	
	public PatientRepo() throws SQLException {
		logger.info("Inside Patient Repo constructor");
		System.out.println("Hell0");
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_sys", "LearnSpring", "abcd@1234");
		
		createTable();
	}
	
	public void createTable() throws SQLException {
		logger.info("Inside create Table method");
		
		String sqlQuery= "create table if not exists patient_jdbl61( id int primary key auto_increment, name varchar(40), age int, doctorName varchar(50))";
		
		//Statement is an interface by java
		Statement stm = con.createStatement();
		boolean val= stm.execute(sqlQuery);
		
		logger.info("Table create query val "+val);
	}
	
	public void insertPatient(Patient patient) throws SQLException {
		
		logger.info("Inside the insert patient Method");
		
		// those 3 ? marks in values represents Dynamic Query
		//Dynamic query - is preferable becoz only parameter changes so it never needs to compile whole query
		String sqlQueryin = "INSERT into patient_jdbl61(name,age,doctorName) values(?,?,?)";
		
		PreparedStatement ps=con.prepareStatement(sqlQueryin);
		
		ps.setString(1, patient.getName());
		ps.setInt(2,patient.getAge());
		ps.setString(3,patient.getDoctorName());
		
		int rowsAffected=ps.executeUpdate();
		//ResultSet rs=ps.executeQuery();
		
		logger.info("Patient got inserted with values "+rowsAffected);
	}
	
	public List<Patient> getAllPatient() throws SQLException{
		
		String sqlQueryall= "Select * from patient_jdbl61";
		
		List<Patient> list = new ArrayList<>();
		
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sqlQueryall);
		
		while(rs.next()) {
			
			long pId= rs.getLong("id");
			String pname= rs.getString("name");
			int pAge= rs.getInt("age");
			String docname= rs.getString("doctorName");
			
			Patient patient = new Patient(pId,pname,pAge,docname);
			
			list.add(patient);
		}
		
		return list;
	}
	
	public boolean deletePatient(int id) throws SQLException{
		
		String sqlQuery = "delete from patient_jdbl61 where id = "+id;
		
		Statement stm = con.createStatement();
		int val = stm.executeUpdate(sqlQuery);
		
		logger.info("deletePatient id "+ id);
		
		if(val>0) {
			return true;
		}
		return false;
	}

	public Patient getDetailsbyId(int id) throws SQLException {
		
		String sqlQuery = "select * from patient_jdbl61 where id = "+id;
		
		logger.info("INSIDE PATIENT BY ID METHOD");
		Statement stm= con.createStatement();
		ResultSet rs=stm.executeQuery(sqlQuery);
		
		if(rs.next()) {
			long pId=rs.getLong("id");
			String pname=rs.getString("name");
			int pAge=rs.getInt("age");
			String dname=rs.getString("doctorName");
			
			return new Patient(pId,pname,pAge,dname);
		}
		
		return null;
	}
	
}
