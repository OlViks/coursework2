package task;

import exceptions.NoDescException;
import exceptions.NoNameException;
import exceptions.NoRepeatException;
import exceptions.NoTypeException;
import taskService.Repeatable;
import taskService.TypeOfTasks;

import java.time.LocalDate;
import java.util.Objects;

public class Task {
    private String name;
    private String describe;
    private final TypeOfTasks type;
    private final LocalDate creationDate;
    private final Repeatable repeatable;
    private final int ID;
    private static int counter;


    public Task(String name, String describe, TypeOfTasks type, Repeatable repeatable)
            throws NoNameException, NoTypeException, NoDescException, NoRepeatException {
        if (name != null && !name.isEmpty() && !name.isBlank()) {
            this.name = name;
        } else {
            throw new NoNameException("У задачи отсутствует заголовок!");
        }
        if (type != null) {
            this.type = type;
        } else {
            throw new NoTypeException("У задачи отсутствует тип личная/рабочая!");
        }
        if (describe != null && !describe.isBlank() && !describe.isEmpty()) {
            this.describe = describe;
        } else {
            throw new NoDescException("У задачи нет описания!");
        }
        creationDate = LocalDate.now();
        ID = counter+1;
        counter++;
        if (repeatable != null) {
            this.repeatable = repeatable;
        } else {
            throw new NoRepeatException("У задачи нет признака повторяемости!");
        }
        System.out.println("Задача " + name + " создана!");
    }
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getDescribe() {
        return describe;
    }

    public TypeOfTasks getType() {
        return type;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Repeatable getRepeatable() {
        return repeatable;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Задача: " +
                " Заголовок - " + name +
                ", описание - " + describe +
                ", тип - " + type +
                ", дата создания: " + creationDate.getDayOfMonth() + "." + creationDate.getMonthValue() + "." + creationDate.getYear() +
                ", повторяется - " + repeatable +
                ", ID - " + ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return ID == task.ID && Objects.equals(name, task.name) &&
                Objects.equals(describe, task.describe) &&
                type == task.type && Objects.equals(creationDate, task.creationDate) &&
                repeatable == task.repeatable;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, describe, type, creationDate, repeatable, ID);
    }
}