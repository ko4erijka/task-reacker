package ru.ko4erijka.tickettracker.dto;

public class SuccessDTO {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SuccessDTO(String message) {
        this.message = message;
    }
}
