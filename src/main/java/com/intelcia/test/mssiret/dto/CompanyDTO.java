package com.intelcia.test.mssiret.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class CompanyDTO implements Serializable {

	private Long id;

	private String nic;

	private String complement_adresse;

	private LocalDate date_creation;

	private String enseigne_1;

	private String numero_tva_intra;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nic
	 */
	public String getNic() {
		return nic;
	}

	/**
	 * @param nic the nic to set
	 */
	public void setNic(String nic) {
		this.nic = nic;
	}

	/**
	 * @return the complement_adresse
	 */
	public String getComplement_adresse() {
		return complement_adresse;
	}

	/**
	 * @param complement_adresse the complement_adresse to set
	 */
	public void setComplement_adresse(String complement_adresse) {
		this.complement_adresse = complement_adresse;
	}

	/**
	 * @return the date_creation
	 */
	public LocalDate getDate_creation() {
		return date_creation;
	}

	/**
	 * @param date_creation the date_creation to set
	 */
	public void setDate_creation(LocalDate date_creation) {
		this.date_creation = date_creation;
	}

	/**
	 * @return the enseigne_1
	 */
	public String getEnseigne_1() {
		return enseigne_1;
	}

	/**
	 * @param enseigne_1 the enseigne_1 to set
	 */
	public void setEnseigne_1(String enseigne_1) {
		this.enseigne_1 = enseigne_1;
	}

	/**
	 * @return the numero_tva_intra
	 */
	public String getNumero_tva_intra() {
		return numero_tva_intra;
	}

	/**
	 * @param numero_tva_intra the numero_tva_intra to set
	 */
	public void setNumero_tva_intra(String numero_tva_intra) {
		this.numero_tva_intra = numero_tva_intra;
	}


	/* (non-javadoc)
	* @see java.lang.Object#toString()
	*/
	@Override
	public String toString() {
		StringBuilder dataBuilder = new StringBuilder();
		appendFieldValue(dataBuilder, id!=null ? id.toString() : "");
		appendFieldValue(dataBuilder, nic!=null ?nic : "");
		appendFieldValue(dataBuilder, complement_adresse!=null ?complement_adresse : "");
		appendFieldValue(dataBuilder, date_creation!=null ?date_creation.toString() : "");
		appendFieldValue(dataBuilder, enseigne_1!=null ?enseigne_1.toString() : "");
		appendFieldValue(dataBuilder, numero_tva_intra!=null ?numero_tva_intra.toString() : "");

		return dataBuilder.toString();
	}

	/**
	 * @param dataBuilder
	 * @param fieldValue
	 */
	private void appendFieldValue(StringBuilder dataBuilder, String fieldValue) {
		if (fieldValue != null) {
			dataBuilder.append(fieldValue).append(",");
		} else {
			dataBuilder.append("").append(",");
		}
	}

}
