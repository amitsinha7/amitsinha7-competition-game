package com.competition.game.rest.webservices.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.competition.game.rest.webservices.model.Languages;
import com.competition.game.rest.webservices.repository.LanguagesRepository;
import com.competition.game.rest.webservices.service.LanguagesService;

@Service
public class LanguagesServiceImpl implements LanguagesService {

	private static final Logger LOG = LoggerFactory.getLogger(LanguagesServiceImpl.class);

	@Autowired
	private LanguagesRepository languagesRepository;

	@Override
	public List<Languages> getAllLanguages() {
		LOG.debug("getAllEmployees method started");
		List<Languages> challengesList = languagesRepository.findAll();
		if (challengesList.size() > 0)
			return challengesList;
		else
			return new ArrayList<>();
	}

}
