package kr.ac.jejunu.repository;

import kr.ac.jejunu.model.Article;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by neo-202 on 2016-06-08.
 */
public interface ArticleRepository extends CrudRepository<Article, Integer>{

    @Query(value = "SELECT * FROM Article a ORDER BY a.date DESC", nativeQuery = true)
    List<Article> findAllOrderByDate();
}
