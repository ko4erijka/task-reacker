package ru.ko4erijka.tickettracker.dto;

public class LabelDTO {
    private String label;
    private String taskId;
    private String authorId;

    public LabelDTO(String label, String taskId, String authorId) {
        this.label = label;
        this.taskId = taskId;
        this.authorId = authorId;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public String getTaskId() {
        return taskId;
    }
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
    public String getAuthorId() {
        return authorId;
    }
    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }
}
