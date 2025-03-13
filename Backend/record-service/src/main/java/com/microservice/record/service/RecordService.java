package com.microservice.record.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.microservice.record.dto.RecordDTO;
import com.microservice.record.model.Record;
import com.microservice.record.repository.RecordRepository;

import jakarta.ws.rs.NotFoundException;

@Service
public class RecordService {
	
	@Autowired
	private RecordRepository recordRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	
	public List<RecordDTO> getAllRecords(){
		 List<Record> records = recordRepository.findAll();
	        return records.stream()
	                .map(record -> modelMapper.map(record, RecordDTO.class))
	                .collect(Collectors.toList());
	}
	
	public RecordDTO updateRecordDetails(Long recordId, RecordDTO updateRecord) {
		Record record = recordRepository.findById(recordId).orElseThrow(() -> new NotFoundException("Patient not forind with id"+recordId));;
		modelMapper.map(updateRecord, record);
        Record savedRecord = recordRepository.save(record);

        return modelMapper.map(savedRecord, RecordDTO.class);
	}
	
	   
    public RecordDTO addRecord(RecordDTO recordDTO) {
        Record record = modelMapper.map(recordDTO, Record.class);
        Record savedRecord = recordRepository.save(record);
        return modelMapper.map(savedRecord, RecordDTO.class);
    }
		
}

