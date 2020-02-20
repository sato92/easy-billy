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
import at.luzi.easy.billy.service.ItemService;
import at.luzi.easy.billy.service.resource.ItemResource;

@SecureController
public class ItemController {

	@Autowired
	private ItemService itemService;

	@GetMapping(path = "/item/all")
	public List<ItemResource> findAll() {
		return itemService.findAll();
	}

	@PostMapping(path = "/item/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@Valid @RequestBody final ItemResource item) {
		itemService.save(item);
	}
}
