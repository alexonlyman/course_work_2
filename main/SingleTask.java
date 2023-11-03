package main;

import java.time.LocalDateTime;

public class SingleTask extends Task implements Repitable {


    public SingleTask(String name, String description, LocalDateTime dateTime, TaskType taskType) {
        super(name, description, dateTime, taskType);
    }

    @Override
    public boolean getNextTime(LocalDateTime date) {
        return getDateTime().toLocalTime().equals(date.toLocalTime());
    }
}
