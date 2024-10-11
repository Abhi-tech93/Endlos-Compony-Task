package edu.jsp.ProjectTask.serice;

import java.util.List;


import edu.jsp.ProjectTask.entity.Task;

public interface TaskService {

	
List<Task> getAllTasks();
	
	Task saveStudent(Task task);
	
	Task getTaskById(Long id);
	
	Task updateTask(Task task);
	
	void deleteTaskById(Long id);
}
