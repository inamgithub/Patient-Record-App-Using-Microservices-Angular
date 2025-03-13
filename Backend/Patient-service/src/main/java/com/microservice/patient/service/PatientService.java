package com.microservice.patient.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.patient.dto.PatientDTO;
import com.microservice.patient.dto.PatientRecordResponse;
import com.microservice.patient.dto.RecordDTO;
import com.microservice.patient.feign.RecordClient;
import com.microservice.patient.model.Patient;
import com.microservice.patient.repository.PatientRepository;

import jakarta.ws.rs.NotFoundException;

@Service
public class PatientService {
    
    @Autowired
    private PatientRepository patientRepository;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private RecordClient recordClient;
    
    
    
    // Method to fetch all patients
    public List<PatientDTO> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(patient -> modelMapper.map(patient, PatientDTO.class))
                .collect(Collectors.toList());
    }
    
    // Method to update patient details
    public PatientDTO updatePatientDetails(Long patientId, PatientDTO updatePatientDTO) {
        // Fetch the existing patient
        Optional<Patient> p = patientRepository.findById(patientId);
                
        if(p.isPresent()) {
        // Map the updated values from the DTO to the existing patient entity
        Patient patient = p.get();
//        modelMapper.map(updatePatientDTO, patient);
        patient.setPatientName(updatePatientDTO.getPatientName());
        patient.setGender(updatePatientDTO.getGender());
        patient.setPatientAge(updatePatientDTO.getPatientAge());
        patient.setPhone(updatePatientDTO.getPhone());
        patient.setPatientAddress(updatePatientDTO.getPatientAddress());
        
        // Save the updated patient and return the updated DTO
        Patient updatedPatient = patientRepository.save(patient);
        return modelMapper.map(updatedPatient, PatientDTO.class);
        }else {
        	throw new NotFoundException("Patient not found with id " + patientId);
        }
    }
    
    public Patient addPatient(Patient patient) {
        
        return patientRepository.save(patient);
        
    }
    
    
    public List<RecordDTO> getPatientRecords(Long patientId) {
        // Check if patient exists
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        // Fetch patient records from Record Service
        return recordClient.getRecordsByPatientId(patientId);
    }
    
    
    
    
    public PatientRecordResponse getPatientWithRecords(Long patientId) {
        // Fetch patient details
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        PatientDTO patientDTO = modelMapper.map(patient, PatientDTO.class);
        // Fetch patient records from Record Service
        List<RecordDTO> records = recordClient.getRecordsByPatientId(patientId);

        // Combine into one response
        return new PatientRecordResponse(patientDTO, records);
    }
    
}
