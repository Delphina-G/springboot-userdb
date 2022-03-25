package com.example.pmdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	
	@PostMapping("/insertUser")
	public void insertUser(@RequestBody UserPOJO user) {
		userRepo.save(user);
	}
	
	@PostMapping("/insertUsers")
	public String insertUsers(@RequestBody List<UserPOJO> users) {
		
		userRepo.saveAll(users);
		return "Users added successfully...";	
	}
	
	@GetMapping("/displayUsers")
	public List<UserPOJO> displayUser(){
		return (List<UserPOJO>) userRepo.findAll();
	}
	
	@GetMapping("/fetchUser/{id}")
	public UserPOJO fetchUser(@PathVariable Integer id) {
		UserPOJO user=userRepo.findById(id).orElse(null);
		return user;
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable Integer id) {
		userRepo.deleteById(id);
		return "user "+id+" deleted successfully...";
	}
	
	@PutMapping("/updateUser")
	public UserPOJO updateUser(@RequestBody UserPOJO user) {
		UserPOJO userDet=userRepo.findById(user.getId()).orElse(null);
		userDet.setName(user.getName());
		return userRepo.save(userDet);
	}
	
}
