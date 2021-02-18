package com.competition.game.rest.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.competition.game.rest.webservices.model.Languages;

@Repository
public interface LanguagesRepository extends JpaRepository<Languages, Integer> {
}