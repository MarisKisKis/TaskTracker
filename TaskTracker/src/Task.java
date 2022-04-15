import java.util.ArrayList;
import java.util.Objects;

public class Task {
    private String taskName;
    private String taskDescription;
    private int taskId;
    private Status taskStatus;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return true;
        //return getTaskId() == task.getTaskId() && getTaskName().equals(task.getTaskName()) && getTaskDescription().equals(task.getTaskDescription()) && getTaskStatus().equals(task.getTaskStatus()) && getTasks().equals(task.getTasks());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTaskName(), getTaskDescription(), getTaskId(), getTaskStatus());
    }


    public Task(String taskName, String taskDescription, int taskId, Status taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskId = taskId;
        this.taskStatus = taskStatus;
    }


    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public Status getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Status taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskId=" + taskId +
                ", taskStatus='" + taskStatus.toString() + '\'' +
                '}';
    }
}
