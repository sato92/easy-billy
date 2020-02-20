package at.luzi.easy.billy.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import at.luzi.easy.billy.rest.controller.annotation.SecureController;
import at.luzi.easy.billy.service.UserService;
import at.luzi.easy.billy.service.resource.UserResource;

@SecureController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(path = "/user/all")
	public List<UserResource> findAll() {
		return userService.findAll();
	}

	@PostMapping(path = "/user/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@Valid @RequestBody final UserResource user) {
		userService.save(user);
	}

}
