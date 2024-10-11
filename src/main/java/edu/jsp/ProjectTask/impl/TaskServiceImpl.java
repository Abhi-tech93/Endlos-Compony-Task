package edu.jsp.ProjectTask.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import edu.jsp.ProjectTask.entity.Task;

import edu.jsp.ProjectTask.repos.TaskRepos;
import edu.jsp.ProjectTask.serice.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	
@Autowired
	private TaskRepos taskRepos;

@Override
public List<Task> getAllTasks() {
	// TODO Auto-generated method stub
	return taskRepos.findAll();
}

@Override
public Task saveStudent(Task task) {
	// TODO Auto-generated method stub
	return taskRepos.save(task);
}

@Override
public Task getTaskById(Long id) {
	// TODO Auto-generated method stub
	return taskRepos.findById(id).get();
}

@Override
public Task updateTask(Task task) {
	// TODO Auto-generated method stub
	return taskRepos
			.save(task);
}

@Override
public void deleteTaskById(Long id) {
	// TODO Auto-generated method stub
	taskRepos.deleteById(id);
}
	
	




	
	
}
