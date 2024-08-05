package com.satge.satge.Repository;

import com.satge.satge.DTO.ProjectDTO;
import com.satge.satge.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Query("SELECT new com.satge.satge.DTO.ProjectDTO(p.projectId, p.projectName) FROM Project p WHERE p.clientId = :clientId")
    List<ProjectDTO> findProjectDTOsByClientId(int clientId);
}
