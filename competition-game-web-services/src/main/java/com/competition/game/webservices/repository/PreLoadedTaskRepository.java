package com.competition.game.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.competition.game.webservices.model.PreLoadedTask;

@Repository
public interface PreLoadedTaskRepository extends JpaRepository<PreLoadedTask, Integer> {

}