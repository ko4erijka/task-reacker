package ru.ko4erijka.tickettracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO {
    @NotNull
    @Size(max = 128)
    private int status;
    @NotNull
    @Size(max = 128)
    private List<String> messages;
    @NotNull
    @Size(max = 128)
    private LocalDateTime timestamp;
    public ErrorDTO(int status, String message) {
        this.status = status;
        this.messages = Collections.singletonList(message);
        this.timestamp = LocalDateTime.now();
    }
    public ErrorDTO(int status, List<String> messages) {
        this.status = status;
        this.messages = messages;
    }

}
