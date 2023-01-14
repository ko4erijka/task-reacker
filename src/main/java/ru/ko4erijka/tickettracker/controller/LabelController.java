package ru.ko4erijka.tickettracker.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
    public ResponseEntity<LabelDTO> save(@RequestBody @Validated LabelDTO dto){
        LabelDTO label = labelService.save(dto);
        return ResponseEntity.ok(label);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Найти метку", response = LabelDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешный ответ"),
            @ApiResponse(code = 422, message = "Ошибка валидации"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервиса")
    })
    public ResponseEntity<LabelDTO> get(@PathVariable String id){
        LabelDTO label = labelService.getById(id);
        return ResponseEntity.ok(label);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Изменить метку", response = LabelDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешный ответ"),
            @ApiResponse(code = 422, message = "Ошибка валидации"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервиса")
    })
    public ResponseEntity<LabelDTO> update(@RequestBody @Validated LabelDTO dto, @PathVariable String id){
        LabelDTO labelDTO = labelService.update(dto, id);
        return ResponseEntity.ok(labelDTO);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удалить метку", response = LabelDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешный ответ"),
            @ApiResponse(code = 422, message = "Ошибка валидации"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервиса")
    })
    public ResponseEntity<SuccessDTO> delete(@PathVariable String id){
        labelService.deleteById(id);
        return ResponseEntity.ok(new SuccessDTO("Метка успешно удалена"));
    }
    @GetMapping("/getAll")
    @ApiOperation(value = "Найти все метки", response = LabelDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешный ответ"),
            @ApiResponse(code = 422, message = "Ошибка валидации"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервиса")
    })
    public ResponseEntity<Page<LabelDTO>> getAll(@RequestParam Integer pageSize, @RequestParam Integer pageNumber){
        Page<LabelDTO> pageLabelDTO =  labelService.getAll(pageSize,pageNumber);
        return ResponseEntity.ok(pageLabelDTO);
    }
}
