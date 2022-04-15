import java.util.ArrayList;

public class Epic extends Task {
    private ArrayList<Subtask>subtasks = new ArrayList<>();

    public Epic(String taskName, String taskDescription, int taskId, Status taskStatus) {
        super(taskName, taskDescription, taskId, taskStatus);
    }
    public ArrayList<Subtask> getSubtask() {
        return subtasks;
    }
    public void deleteSubTask(Subtask subtask)
    {
        this.subtasks.remove(subtask);
    }

    public void setSubtask(ArrayList<Subtask> subtask) {
        this.subtasks = subtask;
    }

    public void addSubtask(Subtask subtask){ this.subtasks.add(subtask);}

    public Status getEpicStatus()
    {
        for (int i=0; i<this.subtasks.size(); i++)
        {
            Status status = this.subtasks.get(i).getTaskStatus();
            if (( status == Status.NEW) | (status == Status.IN_PROGRESS))
            {
                return status;
            }
        }
        return Status.DONE;
    }


}
