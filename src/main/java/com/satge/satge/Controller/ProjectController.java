package com.satge.satge.Controller;

import com.satge.satge.DTO.ProjectDTO;
import com.satge.satge.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/byClientId")
    public List<ProjectDTO> getProjectsByClientId(@RequestParam("clientId") int clientId) {
        return projectService.getProjectsByClientId(clientId);
    }
}
