package kda.spring.security.controller;

import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kda.spring.security.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/user")
public class RestUser {
	
	private final Logger log = LoggerFactory.getLogger(RestUser.class);

	private List<User> listUser = Stream.of(new User(1, "Name 1", 20), new User(2, "Name 2", 30),
			new User(3, "Name 3", 25), new User(4, "Name 4", 23)).toList();

	@GetMapping("/list")
	public List<User> getAll() {
		log.info("listUser.size()={}", listUser.size());
		return listUser;
	}

	@GetMapping("/get/{id}")
	public User getById(@PathVariable("id") Integer id) {
		log.info("user id={}", id);
		return listUser.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
	}

	@PostMapping("/add")
	public User postMethodName(@RequestBody User user) {
		listUser.add(user);
		return user;
	}
	
	
}
