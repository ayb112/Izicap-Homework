package com.intelcia.test.mssiret.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class CompanyDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2581848812070855361L;

	private Long id;

	private String nic;

	private String complement_adresse;

	private LocalDate date_creation;

	private String enseigne_1;

	private String numero_tva_intra;

}
