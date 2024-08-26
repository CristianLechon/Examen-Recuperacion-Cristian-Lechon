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
    public Task save(Task task){
       return taskRepository.save(task);
    }

    //Eliminar
    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

    //Actualizar
    public Optional<Task> updateTask(Long id, Task task) {
        Optional<Task> result = taskRepository.findById(id);

        if (result.isPresent()) {
            Task existingTask = result.get();

            existingTask.setTittle(task.getTittle());
            existingTask.setDescription(task.getDescription());
            existingTask.setDateCreation(task.getDateCreation());
            existingTask.setState(task.getState());

            taskRepository.save(existingTask);
            return Optional.of(existingTask);
        } else {
            System.out.println("No actualizado, no encontrado.");
            return Optional.empty();
        }
    }

    public List<Task> findByState(String state){
        List<Task> result = taskRepository.findByState(state);
        result.stream().filter(task -> state.equals(task.getState()))
                .collect(Collectors.toList());
        result.forEach(task -> System.out.println(task.toString()));
        return result;
    }

}
