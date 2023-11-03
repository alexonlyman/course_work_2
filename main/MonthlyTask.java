package main;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task implements Repitable {

    public MonthlyTask(String name, String description, LocalDateTime dateTime, TaskType taskType) {
        super(name, description, dateTime, taskType);
    }

    @Override
    public boolean getNextTime(LocalDateTime date) {
        return getDateTime().getMonth().equals(date.getMonth());
    }
}
