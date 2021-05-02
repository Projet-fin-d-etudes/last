package com.onlineVip.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.onlineVip.entities.Role;
import com.onlineVip.entities.RoleName;
import java.util.Optional;
import org.springframework.stereotype.Repository;
@Repository

public interface RoleRepo extends MongoRepository<Role, Long> {
	Optional<Role> findByName(RoleName roleName);

}
