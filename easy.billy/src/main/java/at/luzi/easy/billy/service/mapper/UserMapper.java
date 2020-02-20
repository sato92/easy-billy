package at.luzi.easy.billy.service.mapper;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;

import at.luzi.easy.billy.persistence.domain.User;
import at.luzi.easy.billy.service.resource.UserResource;

@Mapper(componentModel = "spring")
public interface UserMapper {

	User map(UserResource user);

	UserResource map(User user);

	List<UserResource> map(Collection<User> users);
}
