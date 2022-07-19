package com.intelcia.test.mssiret.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

import java.time.LocalDate;

@Table
@DynamicInsert
@Getter
@Setter
@Log
@DynamicUpdate
@Entity
public class Company implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String nic;
	
	private String fullAddress;
	
	private LocalDate creationDate;
	
	private String name;
	
	private String TVANumber;
	
	
	

}
