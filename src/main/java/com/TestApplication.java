package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pwd.controller.PwdController;
import com.pwd.dto.SiteDTO;
import com.pwd.entity.Site;
import com.pwd.service.SiteRepository;

@SpringBootApplication
public class TestApplication implements CommandLineRunner {

	@Autowired
	private PwdController controller;
	
	@Autowired
	private SiteRepository repository;
	
	public static void main(String[] args) {
		System.out.println("----START----");
		SpringApplication.run(TestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Site site = Site.getBuilder().username("Sudheer").password("Password").build();
		repository.save(site);
		
		SiteDTO dto = new SiteDTO();
		dto.setUsername(site.getUsername());
		dto.setPassword(site.getPassword());
		// fetch all sites match with criteria
		System.out.println("Sites found with findAll():");
		System.out.println("-------------------------------");
		for (SiteDTO customer : controller.findBySite(dto)) {
			System.out.println(customer.getUsername());
			System.out.println(customer.getPassword());
		}
	}
}