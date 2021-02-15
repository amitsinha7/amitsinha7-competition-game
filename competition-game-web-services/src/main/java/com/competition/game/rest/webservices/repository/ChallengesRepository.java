package com.competition.game.rest.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.competition.game.rest.webservices.api.model.dbapi.Challenges;

@Repository
public interface ChallengesRepository extends JpaRepository<Challenges, Integer> {
}