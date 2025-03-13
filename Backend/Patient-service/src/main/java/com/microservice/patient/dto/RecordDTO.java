package com.microservice.patient.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RecordDTO {

    private Long recordId;
    private Long patientId;
    private String diagnosis;
    private String treatment;
    

    // Constructors
    public RecordDTO() {}
    
    public RecordDTO(Long recordId, Long patientId, String diagnosis, String treatment) {
        this.recordId = recordId;
        this.patientId = patientId;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        
    }

    // Getters and Setters
}
