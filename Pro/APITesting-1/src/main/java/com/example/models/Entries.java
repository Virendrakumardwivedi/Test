package com.example.models;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
public class Entries {
	
	@Id
	@JsonProperty("API")
	private String api;
	
	@JsonProperty("Description")
	private String description;
	@JsonProperty("Auth")
	private String auth;
	
	@JsonProperty("Https")
	private String https;
	@JsonProperty("Cors")
	private String cors;
	
	@JsonProperty("Category")
	private String category;
	
	
	

}
