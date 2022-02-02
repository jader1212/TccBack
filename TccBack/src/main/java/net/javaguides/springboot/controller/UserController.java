package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
// @RequestMapping("/api/v1/")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	// get all users
	@GetMapping("/users")
	public List<User> getAllContas() {
		return userRepository.findAll();
	}

	// authenticate
	// @GetMapping("/contas-tipo/{tipo}")
	// public List<User> getContaByType(@PathVariable Long tipo) {
	// 	return userRepository.findByTipo(tipo);
	// }

	// @GetMapping("/authenticate/{username}")
	// public ResponseEntity<User> getContaById(@PathVariable Long username) {
	// 	User user = userRepository.findByUsername(username)
	// 			.orElseThrow(() -> new ResourceNotFoundException("Conta inexistente com o id :" + id));
	// 	return ResponseEntity.ok(user);
	// }

	// create conta rest api
	@PostMapping("/register")
	public User registerUser(@RequestBody User user) {
		return userRepository.save(user);
	}
}
