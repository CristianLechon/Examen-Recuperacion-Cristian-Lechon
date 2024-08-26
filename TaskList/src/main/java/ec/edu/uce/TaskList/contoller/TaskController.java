package ec.edu.uce.TaskList.contoller;

import ec.edu.uce.TaskList.model.Task;
import ec.edu.uce.TaskList.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serial;
import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    //Listar
    @GetMapping(value = "/All")
    public List<Task> getAllTask(){
        return taskService.getAllList();
    }

    //Listar por Estado
    @GetMapping(value = "/{state}")
    public List<Task> getFindState(@PathVariable String state) {
        return taskService.findByState(state);
    }

    //Guardar
    @PostMapping(value = "/save")
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        return ResponseEntity.ok(taskService.save(task));
    }

    //Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<Optional<Task>> updateTask(@PathVariable Long id, @RequestBody Task task) {
        return ResponseEntity.ok(taskService.updateTask(id, task));
    }

    //Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}



