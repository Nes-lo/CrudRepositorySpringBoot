package com.codingdojo.projectmanager.repositories;

import com.codingdojo.projectmanager.model.Project;
import com.codingdojo.projectmanager.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    /*
        List<Project> findAllByUserNotId(Long userId);

        @Query("SELECT DISTINCT p FROM projects p JOIN p.project_members m WHERE p.leader.id <> :userId AND m.id <> :userId")
        List<Project> findAllByLeaderIdNotAndMembersIdNot(@Param("userId") Long userId);

        @Query("SELECT DISTINCT p FROM projects p JOIN p.project_members m WHERE p.project_members.id <> :user_id AND NOT EXISTS (SELECT 1 FROM m.users u WHERE u.id = :userId)")
        List<Project> findAllByManagerIdNotAndMembersUserIdNot(@Param("userId") Long userId);
    */
    List<Project> findAll();

    Project findByIdIs(Long id);

    List<Project> findAllByUsers(User user);
   // List<Project> findA

    List<Project> findByUsersNotContains(User user);
}
