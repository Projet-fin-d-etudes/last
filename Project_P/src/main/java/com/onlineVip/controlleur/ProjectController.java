package com.onlineVip.controlleur;

import com.onlineVip.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.onlineVip.dao.ProjectDao;
import com.onlineVip.entities.AppUser;

import com.onlineVip.repo.ProjectRepository;


@RestController
@RequestMapping("/api")
public class ProjectController{
	
	

	 
	@Autowired
	public ProjectDao dao;
	
	 
	@Autowired
	public ProjectRepository repo;
	


	@RequestMapping(value="/allproject", method = RequestMethod.GET)
    public List <Project> getAllProjects(){
	return dao.getAll();
	}

	@RequestMapping(value = "AddProject", method = RequestMethod.POST)
	private String AddProject(@Validated @RequestBody Project project ){
		dao.save(project);
	return  (project.getFondateur()+ " " + "votre projet sous le nom de "+ " " +project.getProjectName()+ " est créer avec succée !"  )  ;
		}
   
	 @DeleteMapping("/deleteProject/{id}")
	    public String deleteP(@PathVariable(value = "id") String id) {

	       Project project=dao.getById(id);
	       dao.delete(project);
	        return "Project deleted";
	    }
	
	 @RequestMapping(value="/edit",method = RequestMethod.GET)
		public String editProduit(Model model,Long id) {
			Project p = dao.getProjectById(id);
			model.addAttribute("project",p);
			return "/editProject";
		}
}



