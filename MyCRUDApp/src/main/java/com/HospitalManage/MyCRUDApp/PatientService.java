package com.HospitalManage.MyCRUDApp;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
	
	@Autowired
	PatientRepo pr;
	
	
	public void createPatient(Patient patient) throws SQLException {
		if(patient.getAge()>0) {
			pr.insertPatient(patient);
		}
	}
	
	public List<Patient> getAllPatient() throws SQLException{
		return pr.getAllPatient();
	}
	
	public boolean deletePatient(int id) throws SQLException {
		return pr.deletePatient(id);
	}
	
	public Patient getPatientbyid(int id) throws SQLException {
		return pr.getDetailsbyId(id);
	}
	
}
