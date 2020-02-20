package at.luzi.easy.billy.service.mapper;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;

import at.luzi.easy.billy.persistence.domain.Item;
import at.luzi.easy.billy.service.resource.ItemResource;

@Mapper(componentModel = "spring")
public interface ItemMapper {

	Item map(ItemResource item);

	ItemResource map(Item item);

	List<ItemResource> map(Collection<Item> items);

	List<Item> map(List<ItemResource> items);

}
