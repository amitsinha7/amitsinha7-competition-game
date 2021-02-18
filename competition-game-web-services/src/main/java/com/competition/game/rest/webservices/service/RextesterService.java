package com.competition.game.rest.webservices.service;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.competition.game.rest.webservices.api.v1.RextesterRequest;
import com.competition.game.rest.webservices.api.v1.RextesterResponse;

public interface RextesterService {

	CompletableFuture<RextesterResponse> submitChallenge(@Valid RextesterRequest rextesterReq, String token) throws InterruptedException, IOException;

}
