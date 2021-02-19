package com.competition.game.webservices.service;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.competition.game.webservices.api.v1.RextesterRequest;
import com.competition.game.webservices.api.v1.RextesterResponse;

public interface RextesterService {
	CompletableFuture<RextesterResponse> submitChallenge(@Valid RextesterRequest rextesterReq)
			throws InterruptedException, IOException;
}
