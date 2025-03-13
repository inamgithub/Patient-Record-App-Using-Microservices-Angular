package com.microservice.patient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
   	private Long patientId;
	
	private String patientName;
	
	private int patientAge;
	
	private String patientAddress;
	
	private String phone;
	
	private String gender;
}
