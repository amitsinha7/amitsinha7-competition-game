package com.competition.game.webservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.competition.game.webservices.model.TaskStatus;

@Repository
public interface TaskStatusRepository extends JpaRepository<TaskStatus, Integer> {

	@Query(value = "SELECT DISTINCT taskstatus_id FROM taskstatus WHERE player.nickName= :nickName", nativeQuery = true)
	List<TaskStatus> findAllByNickName(@Param("nickName") String nickName);

}