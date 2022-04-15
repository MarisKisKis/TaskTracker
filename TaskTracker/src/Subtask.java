public class Subtask extends Task  {
    int epicId;

    public Subtask (String taskName, String taskDescription, int taskId, String taskStatus,int epicId){
            super(taskName, taskDescription, taskId, taskStatus);
            this.epicId = epicId;

        }

        public int getEpicId () {
            return epicId;
        }

        public void setEpicId ( int epicId){
            this.epicId = epicId;
        }
    }