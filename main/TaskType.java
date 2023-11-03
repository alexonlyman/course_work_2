package main;

public enum TaskType {
    WORKING(0),
    PERSONAL(1);
    public final int value;

    TaskType(int value) {
        this.value = value;
    }

}
