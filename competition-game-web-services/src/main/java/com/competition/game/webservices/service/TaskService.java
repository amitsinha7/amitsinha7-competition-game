package com.competition.game.webservices.service;

import com.competition.game.webservices.model.TaskStatus;

public interface TaskService {

	TaskStatus getAnyUnusedRandomTask();

}
