package com.competition.game.webservices.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.competition.game.webservices.model.Languages;

@Repository
public interface LanguagesRepository extends JpaRepository<Languages, Integer> {

	@Query("SELECT u FROM Languages u WHERE u.number = ?1")
	Optional<Languages> findLanguageByNumber(int languageChoice);

}