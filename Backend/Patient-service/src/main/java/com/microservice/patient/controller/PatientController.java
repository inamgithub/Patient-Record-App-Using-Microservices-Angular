package com.microservice.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.patient.dto.PatientDTO;
import com.microservice.patient.dto.PatientRecordResponse;
import com.microservice.patient.dto.RecordDTO;
import com.microservice.patient.model.Patient;
import com.microservice.patient.service.PatientService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/patients")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping
	public List<PatientDTO> getAllPatient(){
		return patientService.getAllPatients();
	}
	
	@PutMapping("/{patientId}")
	public PatientDTO updatePatientDetails(@PathVariable Long patientId, @RequestBody PatientDTO updatePatientDTO) {
		return patientService.updatePatientDetails(patientId, updatePatientDTO);
	}
	
	 @PostMapping
	 public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
	        Patient savedPatient = patientService.addPatient(patient);
	        return ResponseEntity.ok(savedPatient);
	 }
	 
	 
	   @GetMapping("/{patientId}/records")
	    public List<RecordDTO> getPatientRecords(@PathVariable Long patientId) {
	        return patientService.getPatientRecords(patientId);
	    }
	   
	   @GetMapping("/{patientId}/detailrecords")
	    public PatientRecordResponse getPatientWithRecords(@PathVariable Long patientId) {
	        return patientService.getPatientWithRecords(patientId);
	    }

}
