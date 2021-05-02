package com.onlineVip.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.onlineVip.entities.AppUser;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<AppUser, Long>{
	AppUser findByUsername(String username);
	AppUser save(AppUser user);
	AppUser findByEmailOrUsername(String email,String name);
	Optional<AppUser> findByUsernameOrEmail(String username, String email);

	List<AppUser> findByIdIn(List<Long> userIds);
	Optional<AppUser> findByEmail(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	 
	
}
