package com.example.services;

import com.example.exception.EntriesException;
import com.example.models.Entries;

public interface EntriesService {
	public Entries AddNewEntries(Entries entries)throws EntriesException;

}
