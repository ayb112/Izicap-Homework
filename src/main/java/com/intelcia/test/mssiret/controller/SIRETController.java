package com.intelcia.test.mssiret.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intelcia.test.mssiret.service.interfaces.ICompanyService;



@RestController
@RequestMapping("/api/v1/SIRET")
public class SIRETController {
	
	
	/**
	 * service de l entreprise
	 */
	@Autowired
	private ICompanyService companyService;
	
	
	
	@GetMapping(value = "/{numSiret}")
	public Collection<Object> getInfoComany(
			@PathVariable String numSiret) {
		return companyService.getdataComany(numSiret);
	}
	
	
	
	/**
	 * 
	 * @param response
	 */
    @RequestMapping(value = "/external-redirect", method = RequestMethod.GET)
    public void method(HttpServletResponse response) {

        String externalUrl = "https://some-domain.com/path/to/somewhere";
        response.setStatus(302);
        response.setHeader("Location", externalUrl);
    }
    

}
