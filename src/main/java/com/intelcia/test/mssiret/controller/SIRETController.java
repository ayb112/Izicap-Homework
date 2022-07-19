package com.intelcia.test.mssiret.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intelcia.test.mssiret.helper.CompanyList;
import com.intelcia.test.mssiret.service.interfaces.ICompanyService;

@RestController
@RequestMapping("/api/v1/SIRET")
public class SIRETController {

	private static final String EXTERNAL_URL = "https://entreprise.data.gouv.fr/api/sirene/v3/etablissements/";

	@Autowired
	private ICompanyService companyService;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ObjectMapper objectMapper;

	@GetMapping(value = "/allCompanies")
	public CompanyList getInfoAllComanies() {

		try {
			ResponseEntity<String> response = restTemplate.getForEntity(EXTERNAL_URL, String.class);

			objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
			CompanyList companies = objectMapper.readValue(response.getBody(), CompanyList.class);
			//generate CSV file
			List<CompanyList> listCompany= new ArrayList<>(1);
			listCompany.add(companies);
			companyService.writeToCsv(companies.getEtablissements());
			
			return  companies;
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping(value = "/siret/{numSiret}")
	public Collection<Object> getInfoComany(@PathVariable String numSiret) {
		return companyService.getdataComany(numSiret);
	}

	@GetMapping("/restCompany/{numSiret}")
	public CompanyList getCompaniesBySiret(@PathVariable String numSiret) {
		try {
			ResponseEntity<String> response = restTemplate.getForEntity(EXTERNAL_URL + numSiret, String.class);
			objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
			//generate CSV file
			CompanyList company = objectMapper.readValue(response.getBody(), CompanyList.class);
			List<CompanyList> listCompany= new ArrayList<>(1);
			listCompany.add(company);
			companyService.writeToCsv(company.getEtablissement());
			
			
			return company;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
