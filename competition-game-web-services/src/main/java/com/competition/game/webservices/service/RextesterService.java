package com.competition.game.webservices.service;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import com.competition.game.webservices.exception.CustomException;
import com.competition.game.webservices.model.Language;
import com.competition.game.webservices.model.Player;
import com.competition.game.webservices.model.PreLoadedTask;
import com.competition.game.webservices.model.Rextester;

public interface RextesterService {

	CompletableFuture<Rextester> submitChallenge(String program, Language lang, Player player, PreLoadedTask preLoadedTask)
			throws InterruptedException, IOException;
}
