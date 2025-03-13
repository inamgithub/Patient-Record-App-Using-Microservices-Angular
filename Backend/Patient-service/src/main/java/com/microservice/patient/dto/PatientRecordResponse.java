package com.microservice.patient.dto;


import java.util.List;

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
public class PatientRecordResponse {
	
    private PatientDTO patientDetails;
    private List<RecordDTO> patientRecords;

    // Constructors
//    public PatientRecordResponse() {}
//
//    public PatientRecordResponse(PatientDTO patientDetails, List<RecordDTO> patientRecords) {
//        this.patientDetails = patientDetails;
//        this.patientRecords = patientRecords;
//    }

    // Getters and Setters
}
