package kr.ac.jejunu.repository;

import kr.ac.jejunu.model.Recommendation;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by neo-202 on 2016-06-08.
 */
public interface RecommendationRepository extends CrudRepository<Recommendation, Integer>{

    Recommendation findByArticleIdAndUserId(Integer article_id, String user_id);
}
