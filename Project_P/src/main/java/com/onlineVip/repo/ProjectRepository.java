package com.onlineVip.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



import com.onlineVip.entities.Project;



@Repository
public interface ProjectRepository extends MongoRepository <Project, String> {
	
	void deleteProjectById(long id);

	Optional<Project> findById(long id);
	
	@Query("select p from Produit p where p.designation like:x ")
	public Page<Project> chercher(@Param ("x")String mc, Pageable pageable);
}
