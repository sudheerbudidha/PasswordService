package com.pwd.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pwd.dto.SiteDTO;
import com.pwd.entity.QSite;
import com.pwd.entity.Site;
import com.pwd.service.PwdService;
import com.pwd.service.SiteRepository;
import com.querydsl.core.types.Predicate;

@Service
public class PwdServiceImpl implements PwdService{

	private final SiteRepository repository;
	
	@Autowired
	PwdServiceImpl(SiteRepository repository) {
        this.repository = repository;
    }
	
	@Override
	public SiteDTO create(SiteDTO site) {
		Site persisted = Site.getBuilder().username(site.getUsername()).password(site.getPassword()).build();
		persisted = repository.save(persisted);
		return convertToDTO(persisted);
	}

	@Override
	public SiteDTO delete(String id) {
		Site deleted = findSiteById(id);
		return convertToDTO(deleted);
	}

	@Override
	public List<SiteDTO> findAll() {
		List<Site> sites = repository.findAll();
		return convertToDTOs(sites);
	}
	
	@Override
	public List<SiteDTO> findBySite(SiteDTO site) {
		QSite query = new QSite("site");
		Predicate  p = query.username.eq(site.getUsername()).and(query.password.eq(site.getPassword()));
		Iterable<Site> sites = repository.findAll(p);
		List<SiteDTO> siteDtos = convertToDTOs(sites);
		return siteDtos;
	}
	
	public Site findSiteById(String id) {
		Site site  = repository.findOne(id);
		return site;
	}
	
	public List<SiteDTO> convertToDTOs(Iterable<Site> sites){
		return ((Collection<Site>) sites).stream().map(this::convertToDTO).collect(Collectors.toList());
	}
	
	public SiteDTO convertToDTO(Site site) {
		SiteDTO dto = new SiteDTO();
		dto.setPassword(site.getPassword());
		dto.setUsername(site.getUsername());
		return dto;
	}

	
}
