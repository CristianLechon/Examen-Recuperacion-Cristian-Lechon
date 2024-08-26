package ec.edu.uce.TaskList.contoller;

import ec.edu.uce.TaskList.model.Task;
import ec.edu.uce.TaskList.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
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
}



