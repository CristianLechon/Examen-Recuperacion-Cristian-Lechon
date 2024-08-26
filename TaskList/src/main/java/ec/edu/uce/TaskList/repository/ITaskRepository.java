package ec.edu.uce.TaskList.repository;

import ec.edu.uce.TaskList.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByState(String State);
}
