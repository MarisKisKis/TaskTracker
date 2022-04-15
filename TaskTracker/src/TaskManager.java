import java.util.ArrayList;
import java.util.HashMap;

public class TaskManager {
    // 3*6+1
    Task task = new Task("taskName", "taskDescription", 1, Status.NEW);
    private HashMap<Integer, Task> taskKeeping = new HashMap<>();
    private HashMap<Integer, Epic> epicSubTasks = new HashMap<>();
    private HashMap<Integer, Subtask> subTaskKeeping = new HashMap<>();
    private int generatorId = 1;
    // Получение списка всех задач
    public ArrayList<Task> getAllTasks() {
        System.out.println("get tasks lists");

        return new ArrayList<>(taskKeeping.values());

    // return null;
    }
    public ArrayList<Task> getAllSubTasks() {
        System.out.println("get subTasks lists");
        return new ArrayList<>(subTaskKeeping.values());
        // return null;
    }
    // Удаление всех задач
    public void deleteAllTasks() {
        taskKeeping.clear();
        epicSubTasks.clear();
        subTaskKeeping.clear();
    }
    // Получение по идентификатору
    public Task getTaskById(Task task) {
        return taskKeeping.get(task.getTaskId());
     //   return null;
    }
    //Создание. Сам объект должен передаваться в качестве параметра
    public Task createTask(Task task) {
        task.setTaskId(++generatorId);
        taskKeeping.put(task.getTaskId(), task);
        return task;
    }
    // Обновление. Новая версия объекта с верным идентификатором передаются в виде параметра
    public void updateTask (Task task) {
       if (taskKeeping.containsKey(task.getTaskId())) {
           return;
        }
       taskKeeping.put(task.getTaskId(), task);
    }
    // Удаление по идентификатору
    public void deleteTaskById(int taskId) {
         taskKeeping.remove(taskId);
    }

    public Epic getEpicById(int taskId) {
        return epicSubTasks.get(taskId);
        //   return null;
    }
    public Epic createEpic(Epic epic) {
        epic.setTaskId(++generatorId);
        epicSubTasks.put(epic.getTaskId(), epic);
        return epic;
    }
    public void epicUpdate(Epic epic) {
        if (epicSubTasks.containsKey(epic.getTaskId())) {
            return;
        }
        epicSubTasks.put(epic.getTaskId(), epic);
    }
    public void deleteEpicById(int taskId) {
        epicSubTasks.remove(taskId);
    }
    public Subtask getSubtaskById(int epicId) {
        return subTaskKeeping.get(epicId);
        //   return null;
    }
    public Subtask createSubtask(Subtask subtask) {
        subtask.setEpicId(++generatorId);
        subTaskKeeping.put(subtask.getEpicId(), subtask);
        return subtask;
    }
    public void subtaskUpdate(Subtask subtask) {
        if (subTaskKeeping.containsKey(subtask.getEpicId())) {
            return;
        }
        subTaskKeeping.put(subtask.getEpicId(), subtask);
    }
    public void deleteSubtaskById(int epicId) {
        subTaskKeeping.remove(epicId);
    }
    private void epicStatusUpdate(Epic epic) {
        for (Subtask subtasks : epic.getSubtask()) {
            if ((subtasks != null) || (epic.getSubtask().contains(epic.getTaskId()))) {
                String taskStatus = "NEW";
                System.out.println("NEW");
            }
        }
    }
    public String taskStatusUpdate() {
        String taskStatus = "";
        for (Task task : task.getTasks()) {
            if ((task != null)||(task.getTasks().contains(task.getTaskId()))) {
               taskStatus = Status.DONE;
                System.out.println(taskStatus);
                    }
          //  all subtasks new  new
            //    if all done - done
                //    сравнивать статусы, если совпадают нью /дан, если не совпадают - ин прогресс
              //  если нет никаких подзадач - это новое, если статусы подзадач совпадают, то у эпика тот же статус, если статусы где-то не совпадают, то всегда ин прогресс

        }
        return taskStatus;
    }

    //Дополнительные методы: Получение списка всех подзадач определённого эпика.//


}
