package br.edu.ifpe.dio_apis_swagger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpe.dio_apis_swagger.model.User;
import br.edu.ifpe.dio_apis_swagger.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserRepository userRepository;

	@GetMapping()
	public List<User> getUsers(){
		
		return userRepository.listAll();
	}
	
	@GetMapping("/{usernameVar}")
	public User getOne(@PathVariable("usernameVar") String username) {
		return userRepository.finByUsername(username);
	}
	
	/* DELETE Só é possível testar com um HTTP client. E.g. Postman */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		userRepository.remove(id);
	}
	
	/* POST Só é possível testar com um HTTP client. E.g. Postman */
	/*@RequestBody converte objeto passado no body da requisição
	para o formato JSON */
	@PostMapping()
	public void postUser(@RequestBody User user) {
		userRepository.save(user);
	}
	
}
