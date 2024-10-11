package edu.jsp.ProjectTask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import edu.jsp.ProjectTask.entity.Task;

import edu.jsp.ProjectTask.serice.TaskService;

@Controller
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	
	@GetMapping("/")
    public String homePage() {
        return "tasks";  
    }
	
	
	// handler method to handle list Task and return mode and view
	@GetMapping("/tasks")
	public String listStudents(Model model) {
		model.addAttribute("tasks", taskService.getAllTasks());
		return "tasks";
	}
	
	@GetMapping("/tasks/new")
	public String createTaskForm(Model model) {
		
		// create task object to hold task form data
		Task task = new Task();
		model.addAttribute("task", task);
		return "create_task";
		
	}
	
	@PostMapping("/tasks")
	public String savetask(@ModelAttribute("task") Task task) {
	
		taskService.saveStudent(task);
		return "redirect:/tasks";
	}
	
	@GetMapping("/tasks/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("task",taskService.getTaskById(id));
		return "edit_task";
	}
	
	@GetMapping("/tasks/{id}")
	public String deleteTask(@PathVariable Long id) {
		
		taskService.deleteTaskById(id);
		return "redirect:/tasks";
	}
	
	 @PostMapping("/tasks/{id}")
	    public String updateTask(@PathVariable Long id,  @ModelAttribute("task")  Task taskDetails) {
	        Task task = taskService.getTaskById(id);
	        
	            task.setTittle(taskDetails.getTittle());
	            task.setDescription(taskDetails.getDescription());
	            task.setStatus(taskDetails.getStatus());
	            Task updatedTask = taskService.updateTask(task);
	            return "redirect:/tasks";
	        
	    }

	
}
