package edu.jsp.ProjectTask.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.jsp.ProjectTask.entity.Task;

@Repository
public interface TaskRepos extends JpaRepository<Task, Long> {

}
