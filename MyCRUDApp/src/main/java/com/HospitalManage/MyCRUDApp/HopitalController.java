package com.HospitalManage.MyCRUDApp;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HopitalController {
	
	@Autowired
	PatientService ps;
	
	@GetMapping("/getPatientbyId")
	public Patient getPatientbyId(@RequestParam("id") int id) throws SQLException {
		
		return ps.getPatientbyid(id);
	}
	
	@PostMapping("/createPatient")
	public void createPatient(@RequestBody Patient patient) throws SQLException {
		if(patient!=null) {
			ps.createPatient(patient);
		}
	}
	
	@GetMapping(value= "/getAllPatientDetails")
	public List<Patient> getPatientDetail() throws SQLException {
		
		return ps.getAllPatient();
	}
	
	@DeleteMapping(value = "/deletePatient")
	public boolean deletePatient(@RequestParam("id") int id) throws SQLException {
		
		return ps.deletePatient(id);
	}
	
	
}
