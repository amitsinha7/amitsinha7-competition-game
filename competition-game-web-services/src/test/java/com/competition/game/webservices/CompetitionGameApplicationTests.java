package com.competition.game.webservices;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.competition.game.webservices.endpoint.v1.ChallengeController;
import com.competition.game.webservices.exception.CustomExceptionHandler;
import com.competition.game.webservices.model.Languages;
import com.competition.game.webservices.repository.LanguagesRepository;
import com.competition.game.webservices.service.LanguagesService;
import com.competition.game.webservices.service.RextesterService;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = CompetitionGameApplication.class)
public class CompetitionGameApplicationTests {

	@Autowired
	private LanguagesService languagesService;

	@Autowired
	private LanguagesRepository languagesRepository;

	@Autowired
	private RextesterService rextesterService;

	@Autowired
	private CustomExceptionHandler exceptionTranslator;

	@Autowired
	private MappingJackson2HttpMessageConverter jacksonMessageConverter;

	private Languages languages;

	private MockMvc restLanguagesMockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(false);
		ChallengeController challengeController = new ChallengeController(languagesService, rextesterService);
		this.restLanguagesMockMvc = MockMvcBuilders.standaloneSetup(challengeController)
				.setControllerAdvice(exceptionTranslator)
				.setConversionService(TestUtil.createFormattingConversionService())
				.setMessageConverters(jacksonMessageConverter).build();
	}

	@Before
	public void initTest() {
		this.languages = createEntity();
	}

	public static Languages createEntity() {
		Languages employee = new Languages("Custom", 7777);
		employee.setId(0L);
		return employee;
	}

	@Test
	public void getEmployee() throws Exception {
		// save
		Languages lang = languagesRepository.saveAndFlush(languages);
		// fetch the inserted record
		restLanguagesMockMvc.perform(MockMvcRequestBuilders.get("/api/v1/getAllLanguages", lang.getId()))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
