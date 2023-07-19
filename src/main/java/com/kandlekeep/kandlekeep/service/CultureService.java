package com.kandlekeep.kandlekeep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kandlekeep.kandlekeep.domain.Culture;
import com.kandlekeep.kandlekeep.repository.CultureRepository;

@Service
public class CultureService {

	@Autowired
	CultureRepository repository;
	
	public List<Culture> findAll(){
		return repository.findAll();
	}
	
}
