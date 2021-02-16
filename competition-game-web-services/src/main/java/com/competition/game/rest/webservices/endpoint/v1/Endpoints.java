package com.competition.game.rest.webservices.endpoint.v1;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.competition.game.rest.webservices.api.model.dbapi.Challenges;
import com.competition.game.rest.webservices.exception.RecordNotFoundException;
import com.competition.game.rest.webservices.service.ChallengesService;



@RestController
@RequestMapping("/api/v1")
public class Endpoints {

	 private static final Logger LOG = LoggerFactory.getLogger(Endpoints.class);
	 
	 @Autowired
	 private ChallengesService challengesService;
	
	@GetMapping("/getAllChallengeIds")
    public ResponseEntity<List<Challenges>> getAllChallengeIds() throws RecordNotFoundException {
        LOG.debug("/v1/getAllChallengeIds method started");
        List<Challenges> list = challengesService.getAllChallengeIds();
        if(list.size()<=0){
            throw new RecordNotFoundException("Challenges Id are not found");
        }
        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }
}
