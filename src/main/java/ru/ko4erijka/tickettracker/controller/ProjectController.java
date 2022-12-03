package ru.ko4erijka.tickettracker.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ko4erijka.tickettracker.dto.ProjectDTO;
import ru.ko4erijka.tickettracker.service.ProjectService;

@RestController
@RequestMapping(value = "/api/project",
        produces = {MediaType.APPLICATION_JSON_VALUE},
        consumes = {MediaType.APPLICATION_JSON_VALUE})
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<ProjectDTO> save(@RequestBody ProjectDTO dto){
        ProjectDTO project = projectService.save(dto);
        return ResponseEntity.ok(project);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> get(@PathVariable String id){
        ProjectDTO project = projectService.getById(id);
        return ResponseEntity.ok(project);
    }
}
