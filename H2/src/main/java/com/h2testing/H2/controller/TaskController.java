package com.h2testing.H2.controller;

import com.h2testing.H2.model.Task;
import com.h2testing.H2.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {

    @Autowired
    TaskRepo taskRepo;

    // showing all the task
    @GetMapping("/getAllTask")
    public ResponseEntity<List<Task>> getAllTask(){
        try{
            List<Task> taskList = taskRepo.findAll();

            if(taskList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(taskList,HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //get task by id
    @GetMapping("/getTaskById/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
        Optional<Task> findTask = taskRepo.findById(id);
        if (findTask.isPresent()) {
            return new ResponseEntity<Task>(findTask.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //add the task
    @PostMapping("/addTask")
    public ResponseEntity<Task> addTaskById(@RequestBody Task task){
        try{
            taskRepo.save(task);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // update task
    @PutMapping("/updateTaskByID/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id,@RequestBody Task task){
        try{
            Optional<Task> tempTask = taskRepo.findById(id);
            if (tempTask.isPresent()){
                Task updateTask = tempTask.get();
                updateTask.setTitle(task.getTitle());
                updateTask.setDescription(task.getDescription());
                updateTask.setDueDate(task.getDueDate());
                return new ResponseEntity<>(updateTask,HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //delete task by id
    @DeleteMapping("/deleteByID/{id}")
    public ResponseEntity<HttpStatus> deleteTaskByID(@PathVariable Long id){
        try{
            Optional<Task> tempTask = taskRepo.findById(id);
            if(tempTask.isPresent()){
                taskRepo.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
