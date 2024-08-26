package ec.edu.uce.TaskList.service;

import ec.edu.uce.TaskList.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements CommandLineRunner {

    @Autowired
    private TaskService taskService;

    @Override
    public void run(String... args) throws Exception {

        Task task = new Task("Tarea 1","Tarea de prueba","Pendiente","26/08/2024");
        taskService.save(task);
        Task task2 = new Task("Tarea 2","Tarea de prueba2","Completada","20/08/2024");
        taskService.save(task2);
        Task task3 = new Task("Tarea 3","Tarea de prueba3","Pendiente","16/08/2024");
        taskService.save(task3);

        //taskService.findByState("Completada");

        //taskService.updateTask(1L, new Task("Tarea 4","Tarea de prueba4","Pendiente","26/08/2024"));

        //taskService.deleteTask(10L);

        //System.out.println(taskService.findByState("Pendiente") + "\n");

    }
}
