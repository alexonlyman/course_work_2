package main;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Calendar {
    private static final Map<Integer, Repitable> actualTask = new HashMap<>();
    /*
    adding a task by scanner input
     */
    public static void addTask(Scanner scanner) {
        scanner.nextLine();
        System.out.println("введите название задачи");
        String title = scanner.nextLine();
        System.out.println("введите описание задачи");
        String description = scanner.nextLine();
        System.out.println("введите тип задачи 0 - рабочая, 1 - личная");
        TaskType taskType = TaskType.values()[scanner.nextInt()];
        System.out.println("введите повторяемость задачи: 0 - однократная, 1 - дневная, 2 - недельная, 3 - месячная" +
                "4 - годовая");
        int occurance = scanner.nextInt();
        System.out.println("введите дату dd.MM.yyyy HH.mm.ss  ");
        scanner.nextLine();
        createEvent(scanner, title, description, occurance, taskType);
        System.out.println("для выходна нажмите Enter");
        scanner.nextLine();
    }
    /*
    creating a date with pattern DateTimeFormatter
     */
    private static void createEvent(Scanner scanner, String title, String description, int occurance, TaskType taskType) {
        LocalDateTime dateTime = LocalDateTime.parse(scanner.nextLine(), Task.DATE_TIME_FORMATTER);
        Repitable task = null;
        do {
            System.out.println("введите формат даты dd.MM.yyyy HH.mm.ss ");
            task = createTask(occurance, title, description, taskType, dateTime);
            System.out.println("зачада создана " + task);
        } while (false);

    }
    /*
    creating task repeatability
     */
    private static Repitable createTask(int occurance, String title, String description, TaskType taskType, LocalDateTime localDateTime) {
        return switch (occurance) {
            case 0 -> {
                SingleTask singleTask = new SingleTask(title, description, localDateTime, taskType);
                actualTask.put(singleTask.getId(), singleTask);
                yield singleTask;
            }
            case 1 -> {
                DailyTask dailyTask = new DailyTask(title, description, localDateTime, taskType);
                actualTask.put(dailyTask.getId(), dailyTask);
                yield dailyTask;
            }
            case 2 -> {
                WeeklyTask weeklyTask = new WeeklyTask(title, description, localDateTime, taskType);
                actualTask.put(weeklyTask.getId(), weeklyTask);
                yield weeklyTask;
            }
            case 3 -> {
                MonthlyTask monthlyTask = new MonthlyTask(title, description, localDateTime, taskType);
                actualTask.put(monthlyTask.getId(), monthlyTask);
                yield monthlyTask;

            }
            case 4 -> {
                AnnualTask annualTask = new AnnualTask(title, description, localDateTime, taskType);
                actualTask.put(annualTask.getId(), annualTask);
                yield annualTask;
            }

        default -> throw new IllegalStateException("Unexpected value: " + occurance);
    };
    }


    /*
    deleting task by id
     */

    public static void deleteTaskById(Scanner scanner) {
        scanner.nextLine();
        System.out.println("введите id задачи");
        Integer id = scanner.nextInt();
        if (actualTask.containsKey(id)) {
            actualTask.remove(id);
            System.out.println("задача успешно удалена");;
        } else {
            System.out.println("такого id не найдено");
        }
    }

    /*
     finding task by date
     */
    public static void taskByDay(Scanner scanner) {
        scanner.nextLine();
        System.out.println("введите дату для поиска задачи в формате dd.MM.yyyy");
        String date = scanner.next();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate requestDate = LocalDate.parse(date, dateTimeFormatter);
        List<Repitable> foundEvents = findTaskByDay(requestDate);
        System.out.println("события на " + date + ":");
        for (Repitable task : foundEvents) {
            System.out.println(task);
        }
        scanner.nextLine();
        System.out.println("для выхода нажмите Enter\n");
    }

    private static List<Repitable> findTaskByDay(LocalDate date) {
        List<Repitable> list = new ArrayList<>();
        for (Repitable task : actualTask.values()) {
            if (task.getNextTime(date.atStartOfDay())) {
                list.add(task);
            }
        }
        return list;
    }



}
