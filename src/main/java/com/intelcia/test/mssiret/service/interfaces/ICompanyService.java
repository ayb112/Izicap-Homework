package com.intelcia.test.mssiret.service.interfaces;

import java.io.IOException;
import java.util.Collection;

import com.intelcia.test.mssiret.dto.CompanyDTO;


public interface ICompanyService {
	
	Collection<CompanyDTO> findInfoCompanyBySiret(String siret);
	
	Collection<Object> getdataComany(String numSiret);

	void writeToCsv(Collection<CompanyDTO> sampleList, String header) throws IOException;
	
	void writeToCsv(Collection<CompanyDTO> sampleList) throws IOException;

}
