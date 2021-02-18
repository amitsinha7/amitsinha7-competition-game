package com.competition.game.webservices.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.competition.game.webservices.model.Languages;
import com.competition.game.webservices.repository.LanguagesRepository;
import com.competition.game.webservices.service.LanguagesService;

@Service
public class LanguagesServiceImpl implements LanguagesService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private LanguagesRepository languagesRepository;

	@Override
	public List<Languages> getAllLanguages() {
		logger.debug("getAllEmployees method started");
		List<Languages> challengesList = languagesRepository.findAll();
		if (challengesList.size() > 0)
			return challengesList;
		else
			return new ArrayList<>();
	}

}
