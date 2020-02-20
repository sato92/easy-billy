package at.luzi.easy.billy.rest.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import at.luzi.easy.billy.rest.controller.annotation.SecureController;
import at.luzi.easy.billy.service.OrderService;
import at.luzi.easy.billy.service.resource.OrderResource;

@SecureController
@Validated
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping(path = "/order/all")
	public List<OrderResource> findAll() {
		return orderService.findAll();
	}

	@GetMapping(path = "/order/table/{table}")
	public List<OrderResource> findByTable(@PathVariable final String table) {
		return orderService.findByTable(table);
	}

	@GetMapping(path = "/order/user/{email}")
	public List<OrderResource> findByUser(@Valid @PathVariable final @Email String email) {
		return orderService.findByUser(email);
	}

	@PostMapping(path = "/order/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@Valid @RequestBody final OrderResource order) {
		orderService.save(order);
	}

}
