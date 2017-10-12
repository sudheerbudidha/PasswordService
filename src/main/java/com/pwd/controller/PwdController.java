package com.pwd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pwd.dto.SiteDTO;
import com.pwd.exception.SiteNotFoundException;
import com.pwd.service.impl.PwdServiceImpl;

@RestController
@RequestMapping("/pwd")
public class PwdController {

	private final PwdServiceImpl service;

	@Autowired
	public PwdController(PwdServiceImpl service) {
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public SiteDTO create(SiteDTO site) {
		return service.create(site);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public SiteDTO delelte(@PathVariable("id") String id) {
		System.out.println("in delete");
		return service.delete(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<SiteDTO> findAll() {
		System.out.println("in findall");
		return service.findAll();
	}

	public List<SiteDTO> findBySite(SiteDTO site) {
		System.out.println("in findBySite");
		return service.findBySite(site);
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public void handleSiteNotFound(SiteNotFoundException exception) {

	}
}
