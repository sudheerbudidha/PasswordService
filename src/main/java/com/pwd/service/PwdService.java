package com.pwd.service;

import java.util.List;

import com.pwd.dto.SiteDTO;

public interface PwdService {

	SiteDTO create(SiteDTO site);
	SiteDTO delete(String id);
	List<SiteDTO> findAll();
	List<SiteDTO> findBySite(SiteDTO site);

}
