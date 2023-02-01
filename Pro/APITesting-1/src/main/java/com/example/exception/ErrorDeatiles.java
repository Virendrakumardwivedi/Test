package com.example.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;

import com.example.models.Entries;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
public class ErrorDeatiles {

	
	private LocalDateTime timestamp;
	private String message;
	private String descripation;
	
}
