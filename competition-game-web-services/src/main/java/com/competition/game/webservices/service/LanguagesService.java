package com.competition.game.webservices.service;

import java.util.List;

import com.competition.game.webservices.exception.RecordNotFoundException;
import com.competition.game.webservices.model.Languages;

public interface LanguagesService {

	List<Languages> getAllLanguages();

	Languages findLanguageByNumber(int languageChoice) throws RecordNotFoundException;

}
