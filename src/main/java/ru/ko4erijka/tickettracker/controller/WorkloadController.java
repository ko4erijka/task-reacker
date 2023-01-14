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
import ru.ko4erijka.tickettracker.dto.WorkloadDTO;
import ru.ko4erijka.tickettracker.service.WorkloadService;

@RestController
@RequestMapping(value = "/api/workload",
        produces = {MediaType.APPLICATION_JSON_VALUE},
        consumes = {MediaType.APPLICATION_JSON_VALUE})
public class WorkloadController {

    private final WorkloadService workloadService;

    public WorkloadController(WorkloadService workloadService) {
        this.workloadService = workloadService;
    }

    @PostMapping
    @ApiOperation(value = "Сохранить рабочее пространство", response = WorkloadDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешный ответ"),
            @ApiResponse(code = 422, message = "Ошибка валидации"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервиса")
    })
    public ResponseEntity<WorkloadDTO> save(@RequestBody @Validated WorkloadDTO dto){
        WorkloadDTO workloadRs = workloadService.save(dto);
        return ResponseEntity.ok(workloadRs);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Найти рабочее пространство", response = WorkloadDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешный ответ"),
            @ApiResponse(code = 422, message = "Ошибка валидации"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервиса")
    })
    public ResponseEntity<WorkloadDTO> get(@PathVariable String id){
        WorkloadDTO workload = workloadService.getById(id);
        return ResponseEntity.ok(workload);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Изменить рабочее пространство", response = WorkloadDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешный ответ"),
            @ApiResponse(code = 422, message = "Ошибка валидации"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервиса")
    })
    public ResponseEntity<WorkloadDTO> update(@RequestBody @Validated WorkloadDTO dto, @PathVariable String id){
        WorkloadDTO workloadDTO = workloadService.update(dto, id);
        return ResponseEntity.ok(workloadDTO);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удалить рабочее пространство", response = WorkloadDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешный ответ"),
            @ApiResponse(code = 422, message = "Ошибка валидации"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервиса")
    })
    public ResponseEntity<SuccessDTO> delete(@PathVariable String id){
        workloadService.deleteById(id);
        return ResponseEntity.ok(new SuccessDTO("Рабочее пространство успешно удалено"));
    }

    @GetMapping("/getAll")
    @ApiOperation(value = "Найти все рабочие пространства", response = WorkloadDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешный ответ"),
            @ApiResponse(code = 422, message = "Ошибка валидации"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервиса")
    })
    public ResponseEntity<Page<WorkloadDTO>> getAll(@RequestParam Integer pageSize,@RequestParam Integer pageNumber){
       Page<WorkloadDTO> pageWorkloadDTO =  workloadService.getAll(pageSize,pageNumber);
       return ResponseEntity.ok(pageWorkloadDTO);
    }
    @GetMapping("/search")
    @ApiOperation(value = "Найти рабочее пространство по названию", response = WorkloadDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешный ответ"),
            @ApiResponse(code = 422, message = "Ошибка валидации"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервиса")
    })
    public ResponseEntity<Page<WorkloadDTO>> getByName(@RequestParam String name, @RequestParam Integer pageSize,@RequestParam Integer pageNumber){
        Page<WorkloadDTO> pageWorkloadDTO =  workloadService.find(name,pageSize,pageNumber);
        return ResponseEntity.ok(pageWorkloadDTO);
    }

}
