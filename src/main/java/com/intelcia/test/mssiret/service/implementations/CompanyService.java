package com.intelcia.test.mssiret.service.implementations;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.intelcia.test.mssiret.dto.CompanyDTO;
import com.intelcia.test.mssiret.service.interfaces.ICompanyService;

@Service
public class CompanyService implements ICompanyService {

	private static final String EXTERNAL_URL = "https://entreprise.data.gouv.fr/api/sirene/v3/etablissements/";
	private static final String SEPARATOR = ",";
	private static final String CSV_DIRECTORY = System.getProperty("user.dir")+"\\csv-files\\";
	private static final String CSV_FILE_ALL_COMPANIES ="info_of_All_Companies.csv";

	@Override
	public Collection<CompanyDTO> findInfoCompanyBySiret(String siret) {
		return null;
	}

	@Override
	public Collection<Object> getdataComany(String numSiret) {
		RestTemplate rt = new RestTemplate();
		Object[] list = rt.getForObject(EXTERNAL_URL + numSiret, Object[].class);
		return Arrays.asList(list);
	}

	@Override
	public void writeToCsv(Collection<CompanyDTO> sampleList, String header) throws IOException {
		PrintWriter writer = new PrintWriter(CSV_DIRECTORY+"sample.csv");
		writer.println(header);

		for (CompanyDTO sample : sampleList) {
			writer.println(sample.toString());
		}
		writer.close();
	}
	
	
	@Override
	public void writeToCsv(Collection<CompanyDTO> sampleList) throws IOException {
		PrintWriter writer = null;
		if(sampleList.size() == 1)
			writer = new PrintWriter(CSV_DIRECTORY+"info_of_"+sampleList.iterator().next().getId().toString()+"_company.csv");
		else	
			writer = new PrintWriter(CSV_DIRECTORY+CSV_FILE_ALL_COMPANIES);
		writer.println(getHeaderForCSV(CompanyDTO.class));
		for (CompanyDTO sample : sampleList) {
			writer.println(sample.toString());
		}
		writer.close();
		
	}
	
	private static <T> String getHeaderForCSV(Class<T> klazz) {
        Field[] fields = klazz.getDeclaredFields();
        Collection<String> listField = new ArrayList<>();
        for (Field field : fields) {
            listField.add(field.getName());
        }
        return String.join(SEPARATOR, listField);
    }

}
