package ru.ko4erijka.tickettracker.dto;

public class WorkloadDTO {
    private String name;
    private String authorId;

    public WorkloadDTO(String name, String authorId) {
        this.name = name;
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }
}
