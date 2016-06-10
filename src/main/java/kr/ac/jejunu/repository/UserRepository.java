package kr.ac.jejunu.repository;

import kr.ac.jejunu.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by neo-202 on 2016-06-08.
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "SELECT * FROM User WHERE id = :id AND password = :password", nativeQuery = true)
    User findByIdAndPassword(@Param("id") String id, @Param("password") String password);

}