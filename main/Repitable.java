package main;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Repitable {
    boolean getNextTime(LocalDateTime date);

}
