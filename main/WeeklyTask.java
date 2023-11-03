package main;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task implements Repitable {

    public WeeklyTask(String name, String description, LocalDateTime dateTime, TaskType taskType) {
        super(name, description, dateTime, taskType);
    }

    @Override
    public boolean getNextTime(LocalDateTime date) {
        return getDateTime().getDayOfWeek().equals(date.getDayOfWeek());
    }
}
