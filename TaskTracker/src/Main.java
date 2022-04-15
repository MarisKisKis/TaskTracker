import java.util.Scanner;
public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        Task task = new Task("taskName", "taskDescription", 0, Status.NEW);
        Epic epic = new Epic("taskName", "taskDescription", 1, Status.NEW);

        Subtask subtask = new Subtask("taskName", "taskDescription", 1, Status.NEW, 2);
        // final Task task = taskManager.createTask();
        // final Task task1 = taskManager.getTaskById();
        //if (task.equals(task1)) {
        //      System.out.println("Ошибка: задача не находится по id " + task.getTaskId());
        //  }
        //  System.out.println(taskManager.getTaskById());
        //taskManager.deleteAllTasks(task.getTaskId());
        printMenu();
        String userCommand = scanner.nextLine();

        while (userCommand != "0") {
            switch (userCommand) {
                case "1":
                    System.out.println("Введите задачу");
                    String taskName = scanner.nextLine();

                    System.out.println("Введите описание");
                    String taskDescription = scanner.nextLine();
                    task = taskManager.createTask(taskName, taskDescription);
                   // String taskName = scanner.nextLine();

                    break;

                case "2":
                    System.out.println("Введите epic");
                    String epicName = scanner.nextLine();
                    System.out.println("Введите описание");
                    String epicDescription = scanner.nextLine();

                    taskManager.createEpic(epicName, epicDescription);
                    break;
                case "3":
                    System.out.println("Введите subtask");
                    String subtaskName = scanner.nextLine();
                    System.out.println("Введите описание");
                    String subtaskDescription = scanner.nextLine();
                    System.out.println("Введите айди эпика");
                    int epicId = scanner.nextInt();

                    scanner.nextLine();
                    taskManager.createSubtask(subtaskName, subtaskDescription, epicId);
                    break;
                case "4":
                    System.out.println("print all tasks" + taskManager.getAllTasks());


                    break;
                case "5":
                    System.out.println("Введите ID");
                    int id = scanner.nextInt();
                    System.out.println("get task by ID" + taskManager.getTaskById(task));


                    break;
                case "6":
                    System.out.println("print all subtasks" + taskManager.getAllSubTasks());
                    break;
                case "7":
                    taskManager.deleteAllTasks();
                    break;
                case "8":
                    System.out.println("Введите ID");
                    int id2 = scanner.nextInt();
                    taskManager.updateTask(task);
                    System.out.println("print upradetasks" + taskManager.getTaskById(task));
                    break;
                case "9":
                    //task = new Task("taskName", "taskDescription", 1, taskManager.taskStatusUpdate());
                    break;
                case "10":
                    System.out.println("print all subtasks" + taskManager.getAllSubTasks());
                    break;
                case "11":
                    System.out.println("print all subtasks" + taskManager.getAllEpics());
                    break;
                default:
                    System.out.println("Извините, такой команды пока нет.");
            }

            printMenu();
            userCommand = scanner.nextLine();
        }
        System.out.println("Программа завершена");


    }



    private static void printMenu() {
            System.out.println("Что вы хотите сделать? ");
            System.out.println("1 - Ввести задачу");
            System.out.println("2 - ввести эпик");
            System.out.println("3 - ввести подзадачу");
            System.out.println("4 - напечатать задачу");
            System.out.println("5 - получить задачу по ИД");
            System.out.println("6 - напечатать подзадачу");
            System.out.println("7 - удалить все задачи");
            System.out.println("8 - обновить задачу по ИД");
            System.out.println("9 - обновить статус задачи");
            System.out.println("10 - все задачи");
            System.out.println("11 - все эпики");
        }
    }
