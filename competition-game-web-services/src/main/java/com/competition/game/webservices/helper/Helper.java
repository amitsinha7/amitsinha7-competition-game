package com.competition.game.webservices.helper;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.competition.game.webservices.api.v1.RextesterRequest;
import com.competition.game.webservices.exception.RecordNotFoundException;
import com.competition.game.webservices.model.PreLoadedTask;
import com.competition.game.webservices.model.TaskStatus;
import com.competition.game.webservices.service.PreLoadedTaskService;
import com.competition.game.webservices.service.TaskStatusService;

@Component
public class Helper {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TaskStatusService taskStatusService;

	@Autowired
	PreLoadedTaskService preLoadedTaskService;

	public List<PreLoadedTask> randomTasksForPlayer(String nickName, String languageName)
			throws RecordNotFoundException {

		logger.debug("randomTasksForPlayer started");

		List<PreLoadedTask> preLoadedTasks = this.preLoadedTaskService.getTasksForLanguageName(languageName);
		List<TaskStatus> tasksAlreadyPerformed = this.taskStatusService.getTasksAlreadyPerformed(nickName,
				languageName);

		if (tasksAlreadyPerformed.size() <= 0) {
			return preLoadedTasks;
		} else if (preLoadedTasks.size() > tasksAlreadyPerformed.size()) {
			for (TaskStatus taskStatus : tasksAlreadyPerformed) {
				preLoadedTasks.remove(taskStatus.getTaskStatusId());
			}
			return preLoadedTasks;
		} else {
			throw new RecordNotFoundException("No Task Available For Language And User Detail Provided");
		}

	}

	public boolean validatePreLoadedTask(RextesterRequest rextesterReq, PreLoadedTask preLoadedTask) {
		boolean isValidated = false;
		if (rextesterReq.getCompilerArgs() != null && !rextesterReq.getCompilerArgs().isEmpty()) {
			if (preLoadedTask.getCompilerArgs() != null && !preLoadedTask.getCompilerArgs().isEmpty()) {
				isValidated = rextesterReq.getCompilerArgs().equals(preLoadedTask.getCompilerArgs());
			} else
				return false;
		}
		if (rextesterReq.getDescription() != null && !rextesterReq.getDescription().isEmpty()) {
			if (preLoadedTask.getDescription() != null && !preLoadedTask.getDescription().isEmpty()) {
				isValidated = rextesterReq.getDescription().equals(preLoadedTask.getDescription());
			} else
				return false;
		}
		if (rextesterReq.getInput() != null && !rextesterReq.getInput().isEmpty()) {
			if (preLoadedTask.getInput() != null && !preLoadedTask.getInput().isEmpty()) {
				isValidated = rextesterReq.getInput().equals(preLoadedTask.getInput());
			} else
				return false;
		}
		if (rextesterReq.getOutput() != null && !rextesterReq.getOutput().isEmpty()) {
			if (preLoadedTask.getOutput() != null && !preLoadedTask.getOutput().isEmpty()) {
				isValidated = rextesterReq.getOutput().equals(preLoadedTask.getOutput());
			} else
				return false;
		}
		return isValidated;
	}

}
