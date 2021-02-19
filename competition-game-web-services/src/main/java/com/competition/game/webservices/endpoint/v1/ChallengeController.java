package com.competition.game.webservices.endpoint.v1;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.competition.game.webservices.api.v1.RextesterRequest;
import com.competition.game.webservices.exception.RecordNotFoundException;
import com.competition.game.webservices.helper.Validator;
import com.competition.game.webservices.model.Languages;
import com.competition.game.webservices.service.LanguagesService;
import com.competition.game.webservices.service.RextesterService;

@RestController
@RequestMapping("${api.path}")
@CrossOrigin(origins = "${cross.origins}")
public class ChallengeController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private LanguagesService languagesService;

	@Autowired
	private Validator validator;

	@Autowired
	private RextesterService rextesterService;

	// Constructor for Integration Testing
	public ChallengeController(LanguagesService languagesService, RextesterService rextesterService) {
		this.languagesService = languagesService;
		this.rextesterService = rextesterService;
	}

	// API to get All Languages
	@GetMapping("/getAllLanguages")
	public ResponseEntity<List<Languages>> getAllLanguages() throws RecordNotFoundException {

		logger.debug("/v1/getAllChallengeIds method started");

		List<Languages> list = languagesService.getAllLanguages();

		if (list.size() <= 0) {
			throw new RecordNotFoundException("Languages are not found");
		}

		return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
	}

	// API to submit challenges
	@PostMapping("/submitChallenges")
	public ResponseEntity<Object> submitChallenges(@Valid @ModelAttribute RextesterRequest rextesterReq)
			throws RecordNotFoundException, InterruptedException, IOException {

		logger.debug("submitChallenges method started {}", rextesterReq);

		Languages lang = this.validator.validateLanguageMapping(rextesterReq.getLanguageChoice());

		if (lang.getName().equals(rextesterReq.getLanguageName())) {
			this.rextesterService.submitChallenge(rextesterReq);
		} else {
			return new ResponseEntity<>("Language Choice and Language Name mismatch ", new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>("!!! Thank you for participating in Challenge !!!! ", new HttpHeaders(),
				HttpStatus.ACCEPTED);
	}
}
