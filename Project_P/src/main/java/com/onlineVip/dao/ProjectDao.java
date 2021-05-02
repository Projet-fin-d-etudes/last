package com.onlineVip.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.onlineVip.entities.Project;
import com.onlineVip.repo.ProjectRepository;

@Service
public class ProjectDao {
	@Autowired
	public ProjectRepository repo;
	public Project save(Project project) {
		return repo.save(project);
	}
	public List<Project> getAll() {
		return repo.findAll();
	}
	public void delete(Project project) {
		 repo.delete(project);
	}
	public Project getById(String project) {
		 return repo.findById(project).get();
	}

    
    public Project getProjectById(long id) {
        Optional < Project > optional = repo.findById(id);
        Project project = null;
        if (optional.isPresent()) {
            project = optional.get();
        } else {
            throw new RuntimeException(" Project not found for id :: " + id);
        }
        return project;
    }

}
