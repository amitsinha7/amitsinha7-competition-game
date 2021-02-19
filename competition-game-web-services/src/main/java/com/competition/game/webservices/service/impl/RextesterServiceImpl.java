package com.competition.game.webservices.service.impl;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.competition.game.webservices.api.v1.RextesterRequest;
import com.competition.game.webservices.api.v1.RextesterResponse;
import com.competition.game.webservices.model.JwtToken;
import com.competition.game.webservices.service.RextesterService;

@Service
public class RextesterServiceImpl implements RextesterService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private final RestTemplate restTemplate;

	public RextesterServiceImpl(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	protected HttpHeaders createHttpHeaders() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
		httpHeaders.set("Authorization", JwtToken.getJwtToken());
		return httpHeaders;
	}

	@Override
	public CompletableFuture<RextesterResponse> submitChallenge(@Valid RextesterRequest rextesterReq)
			throws InterruptedException, IOException {
		logger.debug("submitChallenge Of RextesterServiceImpl");
		LinkedMultiValueMap<String, Object> request = new LinkedMultiValueMap<>();
		String response;
		RextesterResponse rextesterResponse = null;
		HttpStatus httpStatus = HttpStatus.CREATED;
		try {
			request.add("LanguageChoice", rextesterReq.getLanguageChoice());
			request.add("Program", rextesterReq.getProgram());
			request.add("Input", httpStatus);
			request.add("CompilerArgs", httpStatus);

			HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<>(request,
					this.createHttpHeaders());
			String url = "https://rextester.com/rundotnet/api";
			rextesterResponse = restTemplate.postForObject(url, entity, RextesterResponse.class);

			Thread.sleep(1000L);
		} catch (HttpStatusCodeException e) {
			httpStatus = HttpStatus.valueOf(e.getStatusCode().value());
			response = e.getResponseBodyAsString();
		} catch (Exception e) {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response = e.getMessage();
		}
		return CompletableFuture.completedFuture(rextesterResponse);

	}

}
