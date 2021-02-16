package com.competition.game.rest.webservices.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.competition.game.rest.webservices.api.model.dbapi.Challenges;
import com.competition.game.rest.webservices.repository.ChallengesRepository;
import com.competition.game.rest.webservices.service.ChallengesService;

@Service
@Transactional
public class ChallengesServiceImpl implements ChallengesService {

	private static final Logger LOG = LoggerFactory.getLogger(ChallengesServiceImpl.class);

	@Autowired
	private ChallengesRepository challengesRepository;

	@Override
	public List<Challenges> getAllChallengeIds() {
		LOG.debug("getAllEmployees method started");
		List<Challenges> challengesList = challengesRepository.findAll();
		if (challengesList.size() > 0)
			return challengesList;
		else
			return new ArrayList<>();
	}

}
