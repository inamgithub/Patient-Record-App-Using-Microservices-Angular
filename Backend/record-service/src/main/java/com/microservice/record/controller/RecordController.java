package com.microservice.record.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.record.dto.RecordDTO;
import com.microservice.record.model.Record;
import com.microservice.record.repository.RecordRepository;
import com.microservice.record.service.RecordService;

@RestController
@RequestMapping("/records")
public class RecordController {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private RecordService recordService;
	
	@Autowired
	private RecordRepository recordRepository;
	
	@GetMapping
	public List<RecordDTO> getAllRecords(){
		return recordService.getAllRecords();
	}
	
	@PutMapping("/{recordId}")
	public RecordDTO updateRecordDetails(@PathVariable Long recordId, @RequestBody RecordDTO updateRecordDTO) {
		return recordService.updateRecordDetails(recordId, updateRecordDTO);
	}

	 @PostMapping
	    public ResponseEntity<RecordDTO> addRecord(@RequestBody RecordDTO recordDTO) {
	        RecordDTO savedRecord = recordService.addRecord(recordDTO);
	        return ResponseEntity.ok(savedRecord);
	 }
//	@PostMapping
//	public RecordDTO addRecord(RecordDTO recordDTO) {
//	    System.out.println("Received RecordDTO: " + recordDTO);
//	    
//	    Record record = modelMapper.map(recordDTO, Record.class);
//	    System.out.println("Mapped Record Entity: " + record);
//	    
//	    Record savedRecord = recordRepository.save(record);
//	    System.out.println("Saved Record Entity: " + savedRecord);
//	    
//	    return modelMapper.map(savedRecord, RecordDTO.class);
//	}

	 
	 
	    @GetMapping("/patient/{patientId}")
	    public List<Record> getRecordsByPatientId(@PathVariable Long patientId) {
	        return recordRepository.findByPatientId(patientId);
	    }
}
