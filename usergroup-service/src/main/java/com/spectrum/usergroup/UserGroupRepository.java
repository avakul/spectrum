package com.spectrum.usergroup;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserGroupRepository extends MongoRepository<UserGroup, String> {

    public UserGroup findByName(String name);
    public List<UserGroup> findById(String id);

}