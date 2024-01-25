package com.HospitalManage.MyCRUDApp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Patient {
	
	long patientId;
	String name;
    int age;
	String doctorName;
	
//	public long getPatientId() {
//		return patientId;
//	}
//	public void setPatientId(long patientId) {
//		this.patientId = patientId;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}
//	public String getDoctorName() {
//		return doctorName;
//	}
//	public void setDoctorName(String doctorName) {
//		this.doctorName = doctorName;
//	}

}
