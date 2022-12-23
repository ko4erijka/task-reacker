package ru.ko4erijka.tickettracker.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ko4erijka.tickettracker.dto.ProjectDTO;
import ru.ko4erijka.tickettracker.dto.SuccessDTO;
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
    @ApiOperation(value = "Сохранить проект", response = ProjectDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешный ответ"),
            @ApiResponse(code = 422, message = "Ошибка валидации"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервиса")
    })
    public ResponseEntity<ProjectDTO> save(@RequestBody ProjectDTO dto){
        ProjectDTO project = projectService.save(dto);
        return ResponseEntity.ok(project);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> get(@PathVariable String id){
        ProjectDTO project = projectService.getById(id);
        return ResponseEntity.ok(project);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDTO> update(@RequestBody ProjectDTO dto, @PathVariable String id){
        ProjectDTO projectDTO = projectService.update(dto, id);
        return ResponseEntity.ok(projectDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessDTO> delete(@PathVariable String id){
        projectService.deleteById(id);
        return ResponseEntity.ok(new SuccessDTO("Проект успешно удален"));
    }
}
