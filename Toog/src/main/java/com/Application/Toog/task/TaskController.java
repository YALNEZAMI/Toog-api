package com.Application.Toog.task;

import java.util.List;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("")
    public Task create(@RequestBody Task task) {
        return this.taskService.create(task);
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable String id) {
        return this.taskService.getTaskById(id);
    }

    @PostMapping("/uploadTaskPhoto")
    public Task uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("taskId") String taskId) {
        Task task = this.taskService.uploadTaskPhoto(file, taskId);
        return task;
    }

    @GetMapping("/withParticipantId/{participantId}")
    public List<Task> getWithMemberId(@PathVariable String participantId) {
        return this.taskService.getWithMemberId(participantId);
    }

    @GetMapping("/getTasksByProjectId/{projectId}")
    public List<Task> getTasksByProjectId(@PathVariable String projectId) {
        return this.taskService.getTasksByProjectId(projectId);
    }

    @DeleteMapping("/{id}")
    public void deleteTaskById(@PathVariable String id) {
        this.taskService.deleteTaskById(id);
    }

}