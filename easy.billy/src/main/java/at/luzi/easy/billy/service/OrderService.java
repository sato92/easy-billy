package at.luzi.easy.billy.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import at.luzi.easy.billy.persistence.domain.Order;
import at.luzi.easy.billy.service.mapper.ItemMapper;
import at.luzi.easy.billy.service.mapper.OrderMapper;
import at.luzi.easy.billy.service.mapper.UserMapper;
import at.luzi.easy.billy.service.resource.ItemResource;
import at.luzi.easy.billy.service.resource.OrderResource;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderService {

	@Autowired
	private MongoOperations ops;

	@Autowired
	private OrderMapper mapper;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private ItemMapper itemMapper;

	public List<OrderResource> findAll() {

		log.info("findAll");

		List<Order> orders = ops.findAll(Order.class);

		return mapper.map(orders);
	}

	public void save(final OrderResource orderResource) {
		log.info("save start");

		Order order = mapper.map(orderResource);

		Query query = new Query();
		query.with(Sort.by(Direction.DESC, "number"));
		Order last = ops.findOne(query, Order.class);
		order.setNumber(last == null ? 1 : last.getNumber() + 1);
		order.setPriceTotal(orderResource.getItems().stream().map(ItemResource::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add));
		order.setItems(itemMapper.map(orderResource.getItems()));
		order.setUser(userMapper.map(orderResource.getUser()));

		ops.save(order);

	}

	public List<OrderResource> findByTable(final String table) {
		Query query = new Query();
		query.addCriteria(Criteria.where("table").is(table));
		List<Order> orders = ops.find(query, Order.class);
		return mapper.map(orders);
	}

	public List<OrderResource> findByUser(final String email) {
		Query query = new Query();
		query.addCriteria(Criteria.where("user.email").is(email));
		List<Order> orders = ops.find(query, Order.class);
		return mapper.map(orders);
	}

}
