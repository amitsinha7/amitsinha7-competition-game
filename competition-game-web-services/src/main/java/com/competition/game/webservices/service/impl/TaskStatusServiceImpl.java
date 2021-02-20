package com.competition.game.webservices.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.competition.game.webservices.model.TaskStatus;
import com.competition.game.webservices.repository.TaskStatusRepository;
import com.competition.game.webservices.service.TaskStatusService;

@Service
public class TaskStatusServiceImpl implements TaskStatusService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	TaskStatusRepository taskRepository;

	

	@Override
	public List<Integer> getTasksAlreadyPerformed(String nickName) {

		List<TaskStatus> listOfTaskStatus;
		logger.debug("getTasksAlreadyPerformed");
		try {
			listOfTaskStatus = taskRepository.findAllByNickName(nickName);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
