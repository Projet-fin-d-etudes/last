package com.onlineVip.controlleur;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.onlineVip.payloads.AuthentificationResponse;
import com.onlineVip.repo.UserRepository;
import com.onlineVip.securityConf.JwtTokenProvider;
import org.springframework.validation.annotation.Validated;

import com.onlineVip.dao.SequenceGeneratorService;
import com.onlineVip.entities.AppUser;
import com.onlineVip.entities.Role;
import com.onlineVip.entities.RoleName;
import com.onlineVip.repo.RoleRepo;
import com.onlineVip.securityConf.JwtAuthenticationResponse;
import java.util.Collections;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api")
public class AuthController {
	
	
	
  
        @Autowired
	private RoleRepo roleRepo;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	AuthenticationManager authenticationManager;
        @Autowired
	RoleRepo roleRepository;
	@Autowired
	JwtTokenProvider tokenProvider;
        @Autowired
	PasswordEncoder passwordEncoder;
    	@Autowired
        private SequenceGeneratorService sequenceGeneratorService;
	@RequestMapping(value = "subs", method = RequestMethod.GET)
	private ResponseEntity<?> subscribeClient(@Validated @RequestBody AppUser user ){
	String username=user.getUsername();
	String password = user.getPassword();
	String email=user.getEmail();
	AppUser AppUser = new AppUser();
	AppUser.setUsername(username);
	AppUser.setPassword(password);
	AppUser.setEmail(email);
	try {
		userRepository.save(AppUser);
	} catch (Exception e) {
		return ResponseEntity.ok(new AuthentificationResponse(username +" "+ "vous etes deja inscrit"));
	}
	userRepository.save(AppUser);
	return ResponseEntity.ok(new AuthentificationResponse(username +" "+ " Done , let's get started !"));
	}
	@PostMapping("/addRole")
	public Role role(@RequestBody Role roles) {
		return roleRepository.save(roles);
	}
        @PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody AppUser loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
                AppUser user=userRepository.findByUsername(loginRequest.getEmail());
                SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = tokenProvider.generateToken(authentication);
		return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));		
	}
	@PostMapping("/Signup")
	private ResponseEntity<?> authtificateClient( @RequestBody AppUser user  ){
	
		String username=user.getUsername();
		AppUser userExists = userRepository.findByEmailOrUsername(user.getEmail(),user.getUsername());
		if(userExists==null) {
 		Role userRole = roleRepository.findByName(RoleName.ROLE_ADMIN).get();
		user.setRoles(Collections.singleton(userRole));
        user.setId(sequenceGeneratorService.generateSequence(AppUser.SEQUENCE_NAME));
		user.setPassword(passwordEncoder.encode(user.getPassword()));
                userRepository.save(user);
    			return  ResponseEntity.ok(new AuthentificationResponse(username +" "+ " Done , let's get started !"));


		}
		else {
			return ResponseEntity.ok(new AuthentificationResponse(username +" "+ "vous etes deja inscrit"));

		}
	}
}

