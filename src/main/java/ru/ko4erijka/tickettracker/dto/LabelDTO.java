package ru.ko4erijka.tickettracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LabelDTO {
    @NotNull
    @Size(max = 128)
    private String label;
    @NotNull
    @Size(max = 128)
    private String taskId;
    @NotNull
    @Size(max = 128)
    private String authorId;
}
