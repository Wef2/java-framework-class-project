package kr.ac.jejunu.repository;

import kr.ac.jejunu.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by neo-202 on 2016-06-08.
 */
public interface UserRepository extends CrudRepository<User, String> {

    User findByIdAndPassword(String id, String password);

}