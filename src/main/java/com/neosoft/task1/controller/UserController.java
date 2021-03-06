package com.neosoft.task1.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.task1.entity.User;
import com.neosoft.task1.service.UserService;

@RestController
@RequestMapping("/api/user/v1")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;

	// get all users

	@GetMapping("/getAll")
	public ResponseEntity<?> getAllUsers() {
		List<User> all = userService.getAllUsers();
		return new ResponseEntity<>(all, HttpStatus.OK);

	}

	// Add new users

	@PostMapping("/add")
	public ResponseEntity<?> addNewUser(@Valid @RequestBody User user) {

		User createdUser = userService.addNewUser(user);

		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}

	// update user

	@PutMapping("/{id}")
	public ResponseEntity<?> updateUser(@PathVariable long id, @RequestBody User existing) {
		User updatedUser = userService.updateUser(id, existing);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}

	// search by name

	@GetMapping("/searchByName/{name}")
	public ResponseEntity<?> getUserByName(@Valid @PathVariable String name) {
		User user = userService.getUserByName(name);
		return new ResponseEntity<>(user, HttpStatus.OK);

	}

	// search by surname

	@GetMapping("/searchBySurName/{sname}")
	public ResponseEntity<?> getUserBySurName(@PathVariable String sname) {
		User user = userService.getUserBySurName(sname);
		System.out.println(user);
		return new ResponseEntity<>(user, HttpStatus.OK);

	}

	// search by pin

	@GetMapping("/searchBypin/{pin}")
	public ResponseEntity<?> getUserByPincode(@PathVariable String pin) {
		User user = userService.getUserByPincode(pin);
		return new ResponseEntity<>(user, HttpStatus.OK);

	}

	// sort user By Joining Date

	@GetMapping("/getAllByJoining")
	public ResponseEntity<?> sortByJoiningDate() {
		List<User> sorted = userService.sortByJoiningDate();
		System.err.println(sorted);
		return new ResponseEntity<>(sorted, HttpStatus.OK);

	}

	// sort user By Date of birth

	@GetMapping("/getAllByDob")
	public ResponseEntity<?> sortByJoiningDOB() {
		List<User> sorted = userService.sortByJoiningDOB();
		System.err.println(sorted);
		return new ResponseEntity<>(sorted, HttpStatus.OK);

	}

	// delete an user

	@DeleteMapping("/delete/{id}")
	public void deleteUserById(@PathVariable Long id) {
		userService.deleteUserById(id);

	}

}
