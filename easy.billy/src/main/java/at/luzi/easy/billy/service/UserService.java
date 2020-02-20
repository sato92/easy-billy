package at.luzi.easy.billy.service;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import at.luzi.easy.billy.enums.ErrorCode;
import at.luzi.easy.billy.persistence.domain.User;
import at.luzi.easy.billy.rest.controller.exception.EbException;
import at.luzi.easy.billy.service.mapper.UserMapper;
import at.luzi.easy.billy.service.resource.UserResource;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private MongoOperations ops;

	@Autowired
	private UserMapper mapper;

	public List<UserResource> findAll() {
		log.info("findAll");
		return mapper.map(ops.findAll(User.class));
	}

	public void save(final UserResource user) {
		log.info("save start");

		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(user.getEmail()));
		if (CollectionUtils.isEmpty(ops.find(query, User.class))) {
			throw new EbException(ErrorCode.DUPLICATE_ENTRY);
		}

		ops.save(mapper.map(user));

		log.info("save end");

	}

}
