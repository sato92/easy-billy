package at.luzi.easy.billy.service.mapper;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import at.luzi.easy.billy.persistence.domain.Order;
import at.luzi.easy.billy.service.resource.OrderResource;

@Mapper(componentModel = "spring")
public interface OrderMapper {

	@Mapping(target = "items", ignore = true)
	@Mapping(target = "user", ignore = true)
	Order map(OrderResource order);

	OrderResource map(Order order);

	List<OrderResource> map(Collection<Order> orders);
}
