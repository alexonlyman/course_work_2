package main;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AnnualTask extends Task implements Repitable  {

    public AnnualTask(String name, String description, LocalDateTime dateTime, TaskType taskType) {
        super(name, description, dateTime, taskType);
    }

    @Override
    public boolean getNextTime(LocalDateTime date) {
        return getDateTime().getYear() == date.getYear();
    }
}
