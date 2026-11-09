package in.johnrafaellim.expensetrackerapi.service;

import java.util.List;
import java.util.Optional;

import in.johnrafaellim.expensetrackerapi.exception.ResourceNotFoundException;
import in.johnrafaellim.expensetrackerapi.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.johnrafaellim.expensetrackerapi.entity.Task;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepo;

    @Override
    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        Optional<Task> task = taskRepo.findById(id);

        if (task.isPresent()) {
            return task.get();
        }

        throw new ResourceNotFoundException("Task not found with id: " + id);
    }

    @Override
    public void deleteTaskById(Long id) {
        taskRepo.deleteById(id);
    }
}
