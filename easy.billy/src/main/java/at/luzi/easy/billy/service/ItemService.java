package at.luzi.easy.billy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import at.luzi.easy.billy.persistence.domain.Item;
import at.luzi.easy.billy.service.mapper.ItemMapper;
import at.luzi.easy.billy.service.resource.ItemResource;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ItemService {

	@Autowired
	private MongoOperations ops;

	@Autowired
	private ItemMapper mapper;

	public List<ItemResource> findAll() {
		log.info("findAll");
		return mapper.map(ops.findAll(Item.class));
	}

	public void save(final ItemResource item) {
		log.info("save start");

		ops.save(mapper.map(item));

		log.info("save end");

	}

}
