package com.intelcia.test.mssiret.helper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import com.intelcia.test.mssiret.dto.CompanyDTO;

public class CompanyList implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -836271619983063358L;
	
	private Collection<CompanyDTO> etablissements;
	
	private Collection<CompanyDTO> etablissement;

    public CompanyList() {
    	setEtablissements(new ArrayList<>());
    }

	/**
	 * @return the etablissements
	 */
	public Collection<CompanyDTO> getEtablissements() {
		return etablissements;
	}

	/**
	 * @param etablissements the etablissements to set
	 */
	public void setEtablissements(Collection<CompanyDTO> etablissements) {
		this.etablissements = etablissements;
	}

	/**
	 * @return the etablissement
	 */
	public Collection<CompanyDTO> getEtablissement() {
		return etablissement;
	}

	/**
	 * @param etablissement the etablissement to set
	 */
	public void setEtablissement(Collection<CompanyDTO> etablissement) {
		this.etablissement = etablissement;
	}
	
	

}
