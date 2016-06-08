package kr.ac.jejunu.repository;

import kr.ac.jejunu.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by neo-202 on 2016-06-08.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
}