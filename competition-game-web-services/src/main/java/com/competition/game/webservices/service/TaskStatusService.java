package com.competition.game.webservices.service;

import java.util.List;

public interface TaskStatusService {

	List<Integer> getTasksAlreadyPerformed(String nickName);

}
