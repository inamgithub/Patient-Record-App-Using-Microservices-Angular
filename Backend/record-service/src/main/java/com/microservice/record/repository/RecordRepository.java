package com.microservice.record.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.record.model.Record;


@Repository
public interface RecordRepository extends JpaRepository<Record, Long>  {
	
	List<Record> findByPatientId(Long patientId);

}
