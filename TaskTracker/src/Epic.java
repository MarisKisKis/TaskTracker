import java.util.ArrayList;

public class Epic extends Task {
    private ArrayList<Subtask>subtasks = new ArrayList<>();

    public Epic(String taskName, String taskDescription, int taskId, String taskStatus) {
        super(taskName, taskDescription, taskId, taskStatus);
    }
    public ArrayList<Subtask> getSubtask() {
        return subtasks;
    }

    public void setSubtask(ArrayList<Subtask> subtask) {
        this.subtasks = subtask;
    }
}
