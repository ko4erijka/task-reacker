package ru.ko4erijka.tickettracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkloadDTO {
    @NotNull
    @Size(max = 128)
    private String name;
    @NotNull
    @Size(max = 128)
    private String authorId;
}
