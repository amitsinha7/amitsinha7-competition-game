package com.competition.game.rest.webservices.endpoint.v1;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.competition.game.rest.webservices.api.v1.RextesterRequest;
import com.competition.game.rest.webservices.exception.RecordNotFoundException;
import com.competition.game.rest.webservices.model.JwtToken;
import com.competition.game.rest.webservices.model.Languages;
import com.competition.game.rest.webservices.service.LanguagesService;
import com.competition.game.rest.webservices.service.RextesterService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class ChallengeController {

	private static final Logger LOG = LoggerFactory.getLogger(ChallengeController.class);

	@Autowired
	private LanguagesService languagesService;

	@Autowired
	private RextesterService rextesterService;

	@GetMapping("/getAllLanguages")
	public ResponseEntity<List<Languages>> getAllLanguages(
			@RequestHeader(required = false, value = "Authorization") String token) throws RecordNotFoundException {
		LOG.debug("/v1/getAllChallengeIds method started");
		List<Languages> list = languagesService.getAllLanguages();
		if (list.size() <= 0) {
			throw new RecordNotFoundException("Languages are not found");
		}
		return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/submitChallenges")
	public ResponseEntity<Object> submitChallenges(
			@RequestHeader(required = false, value = "Authorization") String token,
			@Valid @ModelAttribute RextesterRequest rextesterReq) throws RecordNotFoundException, InterruptedException, IOException {
		LOG.debug("createOrUpdateEmployee method started {}", rextesterReq);
		JwtToken.jwtToken=token;
		this.rextesterService.submitChallenge(rextesterReq,token);

		return new ResponseEntity<>("!!! Thank you for participating in Challenge !!!! ", new HttpHeaders(),
				HttpStatus.CREATED);
	}
}
