package ru.ko4erijka.tickettracker.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ko4erijka.tickettracker.dto.LabelDTO;
import ru.ko4erijka.tickettracker.dto.SuccessDTO;
import ru.ko4erijka.tickettracker.service.LabelService;

@RestController
@RequestMapping(value = "/api/label",
        produces = {MediaType.APPLICATION_JSON_VALUE},
        consumes = {MediaType.APPLICATION_JSON_VALUE})
public class LabelController {
    private final LabelService labelService;
    public LabelController(LabelService labelService) {
        this.labelService = labelService;
    }

    @PostMapping
    @ApiOperation(value = "Сохранить метку", response = LabelDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешный ответ"),
            @ApiResponse(code = 422, message = "Ошибка валидации"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервиса")
    })
    public ResponseEntity<LabelDTO> save(@RequestBody LabelDTO dto){
        LabelDTO label = labelService.save(dto);
        return ResponseEntity.ok(label);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LabelDTO> get(@PathVariable String id){
        LabelDTO label = labelService.getById(id);
        return ResponseEntity.ok(label);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LabelDTO> update(@RequestBody LabelDTO dto, @PathVariable String id){
        LabelDTO labelDTO = labelService.update(dto, id);
        return ResponseEntity.ok(labelDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessDTO> delete(@PathVariable String id){
        labelService.deleteById(id);
        return ResponseEntity.ok(new SuccessDTO("Метка успешно удалена"));
    }
}
