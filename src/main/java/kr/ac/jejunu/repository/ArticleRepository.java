package kr.ac.jejunu.repository;

import kr.ac.jejunu.model.Article;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by neo-202 on 2016-06-08.
 */
public interface ArticleRepository extends CrudRepository<Article, Integer>{
}
