package com.microservice.record.dto;

import com.microservice.record.model.Record;

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


}
