package at.luzi.easy.billy.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import at.luzi.easy.billy.rest.controller.annotation.PublicController;

@PublicController
public class IndexController {

	@GetMapping("/index")
	public ResponseEntity<String> info() {
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
