package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Entries;

@Repository
public interface EntriesRepository extends JpaRepository<Entries, String>{

}
