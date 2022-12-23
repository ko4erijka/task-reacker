package ru.ko4erijka.tickettracker.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ko4erijka.tickettracker.dto.CommentDTO;
import ru.ko4erijka.tickettracker.dto.SuccessDTO;
import ru.ko4erijka.tickettracker.service.CommentService;

@RestController
@RequestMapping(value = "/api/comment",
        produces = {MediaType.APPLICATION_JSON_VALUE},
        consumes = {MediaType.APPLICATION_JSON_VALUE})
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    @ApiOperation(value = "Сохранить комментарий", response = CommentDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешный ответ"),
            @ApiResponse(code = 422, message = "Ошибка валидации"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервиса")
    })
    public ResponseEntity<CommentDTO> save(@RequestBody CommentDTO dto){
        CommentDTO comment = commentService.save(dto);
        return ResponseEntity.ok(comment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDTO> get(@PathVariable String id){
        CommentDTO comment = commentService.getById(id);
        return ResponseEntity.ok(comment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentDTO> update(@RequestBody CommentDTO dto, @PathVariable String id){
        CommentDTO commentDTO = commentService.update(dto, id);
        return ResponseEntity.ok(commentDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessDTO> delete(@PathVariable String id){
        commentService.deleteById(id);
        return ResponseEntity.ok(new SuccessDTO("Комментарий успешно удален"));
    }
}
