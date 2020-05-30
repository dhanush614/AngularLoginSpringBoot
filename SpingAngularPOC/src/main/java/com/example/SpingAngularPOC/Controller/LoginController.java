package com.example.SpingAngularPOC.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpingAngularPOC.Pojo.LoginDetails;
import com.example.SpingAngularPOC.Pojo.RequestDetails;
import com.example.SpingAngularPOC.Repository.RequestRepository;
import com.example.SpingAngularPOC.Repository.UserRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoginController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RequestRepository requestRepository;

	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@PostMapping(value = "/save")
	public LoginDetails saveUser(@RequestBody LoginDetails loginDetails) {
		loginDetails.setPassword(passwordEncoder.encode(loginDetails.getPassword()));
		LoginDetails user = userRepository.save(loginDetails);
		return user;
	}

	@PostMapping(value = "/saveRequest")
	public RequestDetails saveRequest(@RequestBody RequestDetails requestDetails) {
		RequestDetails request = requestRepository.save(requestDetails);
		return request;
	}

	@GetMapping(value = "/getRequests")
	public List<RequestDetails> getRequests() {
		List<RequestDetails> requests = new ArrayList<RequestDetails>();
		requestRepository.findAll().forEach(RequestDetails -> requests.add(RequestDetails));
		return requests;
	}

	@PutMapping(value = "/update")
	public LoginDetails updateUser(@RequestBody LoginDetails loginDetails) {
		LoginDetails user = userRepository.save(loginDetails);
		return user;
	}

	@DeleteMapping(value = "/delete")
	public void deleteUser(@RequestParam("userid") String userid) {
		userRepository.deleteById(userid);
	}

	@GetMapping(value = "/users")
	public List<LoginDetails> getUsers() {
		List<LoginDetails> users = new ArrayList<LoginDetails>();
		userRepository.findAll().forEach(LoginDetails -> users.add(LoginDetails));
		return users;
	}

	@GetMapping(value = "/login")
	public boolean login(@RequestParam("userid") String userid, @RequestParam("password") String password) {
		LoginDetails user = new LoginDetails();
		user = userRepository.findById(userid).get();
		LoginDetails user1 = new LoginDetails(userid, password);
		if ((user.getUserid().equals(user1.getUserid()))
				&& (passwordEncoder.matches(user1.getPassword(), user.getPassword()))) {
			return true;
		} else {
			return false;
		}
	}

	@GetMapping(value = "/users/{id}")
	public LoginDetails getUser(@PathVariable("id") String id) {
		return userRepository.findById(id).get();
	}

}
