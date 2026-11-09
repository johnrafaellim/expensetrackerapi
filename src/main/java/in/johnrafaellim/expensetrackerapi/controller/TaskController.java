package in.johnrafaellim.expensetrackerapi.controller;

import in.johnrafaellim.expensetrackerapi.entity.Task;
import in.johnrafaellim.expensetrackerapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @DeleteMapping("/tasks")
    public void deleteTaskById(@RequestParam Long id) {
        taskService.deleteTaskById(id);
    }
}
