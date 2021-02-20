package com.competition.game.webservices.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.competition.game.webservices.exception.RecordNotFoundException;
import com.competition.game.webservices.model.Language;
import com.competition.game.webservices.service.LanguageService;

@Component
public class Validator {

	@Autowired
	private LanguageService languagesService;

	public Language validateLanguageMapping(int languageChoice) throws RecordNotFoundException {
		return this.languagesService.findLanguageByNumber(languageChoice);
	}

}
