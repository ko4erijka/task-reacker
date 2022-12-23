package ru.ko4erijka.tickettracker.dto;

public class CommentDTO {
    private String text;
    private String taskId;
    private String authorId;

    public CommentDTO(String text, String taskId, String authorId) {
        this.text = text;
        this.taskId = taskId;
        this.authorId = authorId;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
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
