import java.util.ArrayList;
import java.util.HashMap;

public class TaskManager {
    // 3*6+1
    //Task task = new Task("taskName", "taskDescription", 1, Status.NEW);
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

    public ArrayList<Task> getAllEpics() {
        System.out.println("get epics lists");

        return new ArrayList<>(epicSubTasks.values());

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
    public Task createTask(String Name, String Description) {
        int id = ++ generatorId;
        Task task = new Task(Name,Description,id, Status.NEW);
        taskKeeping.put(task.getTaskId(), task);
        return task;
    }
    // Обновление. Новая версия объекта с верным идентификатором передаются в виде параметра
    public void updateTask (Task task) {

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
    public Epic createEpic(String Name, String Description) {
        int id = ++generatorId;
        Epic epic = new Epic(Name, Description, id, Status.NEW);
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
    public Subtask getSubtaskById(int subtaskId) {
        return subTaskKeeping.get(subtaskId);
        //   return null;
    }
    public Subtask createSubtask(String Name, String Description, int EpicId) {
        if (epicSubTasks.containsKey(EpicId)== false)
        {
            System.out.println("нет такого эпика");
            return new Subtask(Name,  "Нет такого эпика",0, Status.NEW, EpicId);
        }
        int id = ++generatorId;

        Subtask subtask = new Subtask(Name,Description,id, Status.NEW, EpicId);
        subTaskKeeping.put(subtask.getTaskId(), subtask);
        return subtask;
    }
    public void subtaskUpdate(Subtask subtask) {
        subTaskKeeping.put(subtask.getEpicId(), subtask);
    }
    public void deleteSubtaskById(int subtaskId) {
        Subtask subtask = subTaskKeeping.get(subtaskId);
        subTaskKeeping.remove(subtaskId);
        epicSubTasks.get(subtask.getEpicId()).deleteSubTask(subtask);

    }
    private Status epicStatusUpdate(int id, Status status) {
        Epic epic = epicSubTasks.get(id);
        epic.setTaskStatus(status);
        return status;
    }
    public Status taskStatusUpdate(int id, Status status) {
       taskKeeping.get(id).setTaskStatus(status);
       return status;
    }

    //Дополнительные методы: Получение списка всех подзадач определённого эпика.//


}
