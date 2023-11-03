package main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class Task {
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH.mm.ss");

    private String name;
    private String description;
    private LocalDateTime dateTime;
    private TaskType taskType;
    private Integer id;
    private int counter = 0;

    public Task(String name, String description, LocalDateTime dateTime, TaskType taskType) {
        this.name = name;
        this.description = description;
        this.dateTime = dateTime;
        this.taskType = taskType;
        id = counter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return counter == task.counter && Objects.equals(name, task.name) && Objects.equals(description, task.description) && Objects.equals(dateTime, task.dateTime) && taskType == task.taskType && Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, dateTime, taskType, id, counter);
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dateTime=" + dateTime +
                ", taskType=" + taskType +
                ", id=" + id +
                '}';
    }
}
