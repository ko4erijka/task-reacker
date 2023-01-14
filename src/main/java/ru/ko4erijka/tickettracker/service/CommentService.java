package ru.ko4erijka.tickettracker.service;

import org.springframework.data.domain.Page;
import ru.ko4erijka.tickettracker.dto.CommentDTO;

public interface CommentService {
    CommentDTO save(CommentDTO dto);

    CommentDTO getById(String id);

    CommentDTO update(CommentDTO dto, String id);

    void deleteById(String id);
    Page<CommentDTO> getAll(Integer pageSize, Integer pageNumber);
}
