package com.HospitalManage.MyCRUDApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MySqlExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySqlExampleApplication.class, args);
	}

	
	//http://localhost:8089/getPatientbyId?id=5
    //http://localhost:8089/createPatient	
	//http://localhost:8089/getAllPatientDetails
	//http://localhost:8089/deletePatient?id=4
}
