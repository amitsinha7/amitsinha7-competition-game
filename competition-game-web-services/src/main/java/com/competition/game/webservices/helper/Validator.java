package com.competition.game.webservices.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.competition.game.webservices.exception.RecordNotFoundException;
import com.competition.game.webservices.model.Languages;
import com.competition.game.webservices.service.LanguagesService;

@Component
public class Validator {

	@Autowired
	private LanguagesService languagesService;

	public Languages validateLanguageMapping(int languageChoice) throws RecordNotFoundException {
		return this.languagesService.findLanguageByNumber(languageChoice);
	}

}
