package in.johnrafaellim.expensetrackerapi.service;

import in.johnrafaellim.expensetrackerapi.entity.Task;

import java.util.List;

public interface TaskService {

    List<Task> getAllTasks();
    Task getTaskById(Long id);
    void deleteTaskById(Long id);
}
