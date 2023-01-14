package ru.ko4erijka.tickettracker.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.ko4erijka.tickettracker.dto.SuccessDTO;
import ru.ko4erijka.tickettracker.dto.TaskDTO;
import ru.ko4erijka.tickettracker.service.TaskService;


@RestController
@RequestMapping(value = "/api/task",
        produces = {MediaType.APPLICATION_JSON_VALUE},
        consumes = {MediaType.APPLICATION_JSON_VALUE})
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    @ApiOperation(value = "Сохранить задание", response = TaskDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешный ответ"),
            @ApiResponse(code = 422, message = "Ошибка валидации"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервиса")
    })
    public ResponseEntity<TaskDTO> save(@RequestBody @Validated TaskDTO dto){
        TaskDTO task = taskService.save(dto);
        return ResponseEntity.ok(task);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Найти задание", response = TaskDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешный ответ"),
            @ApiResponse(code = 422, message = "Ошибка валидации"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервиса")
    })
    public ResponseEntity<TaskDTO> get(@PathVariable String id){
        TaskDTO task = taskService.getById(id);
        return ResponseEntity.ok(task);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Изменить задание", response = TaskDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешный ответ"),
            @ApiResponse(code = 422, message = "Ошибка валидации"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервиса")
    })
    public ResponseEntity<TaskDTO> update(@RequestBody @Validated TaskDTO dto, @PathVariable String id){
        TaskDTO taskDTO = taskService.update(dto, id);
        return ResponseEntity.ok(taskDTO);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удалить задание", response = TaskDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешный ответ"),
            @ApiResponse(code = 422, message = "Ошибка валидации"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервиса")
    })
    public ResponseEntity<SuccessDTO> delete(@PathVariable String id){
        taskService.deleteById(id);
        return ResponseEntity.ok(new SuccessDTO("Задание успешно удалено"));
    }

    @GetMapping("/getAll")
    @ApiOperation(value = "Найти все задания", response = TaskDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешный ответ"),
            @ApiResponse(code = 422, message = "Ошибка валидации"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервиса")
    })
    public ResponseEntity<Page<TaskDTO>> getAll(@RequestParam Integer pageSize, @RequestParam Integer pageNumber){
        Page<TaskDTO> pageTaskDTO =  taskService.getAll(pageSize,pageNumber);
        return ResponseEntity.ok(pageTaskDTO);
    }
    @GetMapping("/search")
    @ApiOperation(value = "Найти задание по имени", response = TaskDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешный ответ"),
            @ApiResponse(code = 422, message = "Ошибка валидации"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервиса")
    })
    public ResponseEntity<Page<TaskDTO>> getByName(@RequestParam String name, @RequestParam Integer pageSize, @RequestParam Integer pageNumber){
        Page<TaskDTO> pageTaskDTO =  taskService.find(name, pageSize,pageNumber);
        return ResponseEntity.ok(pageTaskDTO);
    }
}
