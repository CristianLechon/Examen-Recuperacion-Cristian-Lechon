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
    public void run(String... args) {

        Task task = new Task("Tarea 1","Tarea de prueba","Pendiente","26/08/2024");
        taskService.save(task);
        Task task2 = new Task("Tarea 2","Tarea de prueba 2","Completada","20/08/2024");
        taskService.save(task2);
        Task task3 = new Task("Tarea 3","Tarea de prueba 3","Pendiente","16/08/2024");
        taskService.save(task3);

        //taskService.findByState("Completada");

        Task task1 = new Task();
        task1.setTittle("Tarea 1");
        task1.setDescription("Tarea de prueba");
        task1.setState("Completada");
        task1.setDateCreation("26/08/2024");
        //taskService.updateTask(1L, task1);

        //taskService.deleteTask(10L);

    }
}
