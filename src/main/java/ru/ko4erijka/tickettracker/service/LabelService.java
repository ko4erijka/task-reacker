package ru.ko4erijka.tickettracker.service;

import org.springframework.data.domain.Page;
import ru.ko4erijka.tickettracker.dto.LabelDTO;

public interface LabelService {
    LabelDTO save(LabelDTO dto);

    LabelDTO getById(String id);

    LabelDTO update(LabelDTO dto, String id);

    void deleteById(String id);

    Page<LabelDTO> getAll(Integer pageSize, Integer pageNumber);
}
