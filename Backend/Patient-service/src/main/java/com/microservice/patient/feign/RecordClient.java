package com.microservice.patient.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.patient.dto.RecordDTO;

@FeignClient(name = "record-service")
public interface RecordClient {
	
    @GetMapping("/records/patient/{patientId}")
    List<RecordDTO> getRecordsByPatientId(@PathVariable("patientId") Long patientId);
}

