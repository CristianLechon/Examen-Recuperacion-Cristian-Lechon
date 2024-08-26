package ec.edu.uce.TaskList.service;

import ec.edu.uce.TaskList.model.Task;
import ec.edu.uce.TaskList.repository.ITaskRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private ITaskRepository taskRepository;

    //Listar
    public List<Task> getAllList(){
        return taskRepository.findAll();
    }

    //Crear
    public void save(Task task){
        taskRepository.save(task);
    }

    //Eliminar
    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

    //Actualizar
    public Optional<Task> updateTask(Long id, Task task){
        Optional<Task> result = taskRepository.findById(id);
        if (result.isPresent()){
            taskRepository.save(task);
        }else {
            System.out.println("No actualizado, no encontrado.");
        }
        return result;
    }

    public Optional<Task> findById(Long id, Task task) {
        return taskRepository.findById(id);
    }

    public List<Task> findByState(String state){
        List<Task> result = taskRepository.findByState(state);
        result.stream().filter(task -> state.equals(task.getState()))
                .collect(Collectors.toList());
        result.forEach(task -> System.out.println(task.toString()));
        return result;
    }

}
