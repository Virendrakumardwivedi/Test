package com.example.models;

import java.util.List;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
public class EntriesallData {
	
	private Integer countData;
	private List<Entries> entries;
 
}
