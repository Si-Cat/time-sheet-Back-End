package com.satge.satge.Service;

import com.satge.satge.DTO.ProjectDTO;
import com.satge.satge.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<ProjectDTO> getProjectsByClientId(int clientId) {
        return projectRepository.findProjectDTOsByClientId(clientId);
    }
}
