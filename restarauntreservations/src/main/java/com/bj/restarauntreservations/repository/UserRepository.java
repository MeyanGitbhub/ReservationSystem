package com.bj.restarauntreservations.repository;
import org.springframework.data.repository.CrudRepository;

import com.bj.restarauntreservations.model.User;


public interface UserRepository extends CrudRepository<User, Integer> {

}
