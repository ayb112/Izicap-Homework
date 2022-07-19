package com.intelcia.test.mssiret.service.implementations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.intelcia.test.mssiret.dto.CompanyDTO;
import com.intelcia.test.mssiret.service.interfaces.ICompanyService;

@Service
public class CompanyService implements ICompanyService {
	
	private final String EXTERNAL_URL = "https://entreprise.data.gouv.fr/api/sirene/v3/etablissements/";
	

	@Override
	public Collection<CompanyDTO> findInfoCompanyBySiret(String siret) {
		return null;
	}
	
	@Override
    public Collection<Object> getdataComany(String numSiret) {
        RestTemplate rt = new RestTemplate();
        Object[] list = rt.getForObject(EXTERNAL_URL+numSiret,Object[].class);
        return Arrays.asList(list);
    }

}
