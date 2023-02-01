package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.EntriesException;
import com.example.models.Entries;
import com.example.repository.EntriesRepository;

@Service
public class EntriesIMPL implements EntriesService{
	
	@Autowired
	private EntriesRepository entriesRepo;
	

	@Override
	public Entries AddNewEntries(Entries entries) throws EntriesException {
		// TODO Auto-generated method stub
		Entries ent = entriesRepo.save(entries);
		
		return ent;
	}
	
	

}
