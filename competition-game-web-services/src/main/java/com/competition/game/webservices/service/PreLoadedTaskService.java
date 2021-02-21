package com.competition.game.webservices.service;

import java.util.List;

import com.competition.game.webservices.model.PreLoadedTask;

public interface PreLoadedTaskService {

	List<PreLoadedTask> getTasksForLanguageChoice(int languageChoice);

}
