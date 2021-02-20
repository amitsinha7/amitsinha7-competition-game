package com.competition.game.webservices.service;

import java.util.List;

import com.competition.game.webservices.exception.RecordNotFoundException;
import com.competition.game.webservices.model.Language;

public interface LanguageService {

	List<Language> getAllLanguages();

	Language findLanguageByNumber(int languageChoice) throws RecordNotFoundException;

}
