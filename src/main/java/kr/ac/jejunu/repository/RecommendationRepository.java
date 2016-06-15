package kr.ac.jejunu.repository;

import kr.ac.jejunu.model.Recommendation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by neo-202 on 2016-06-08.
 */
public interface RecommendationRepository extends CrudRepository<Recommendation, Integer>{

    Recommendation findByArticleIdAndUserId(Integer article_id, String user_id);

    @Query(value = "UPDATE Recommendation r SET r.value = :value WHERE r.articleId = :articleId AND r.userId = :userId", nativeQuery = true)
    Recommendation update(@Param("articleId") Integer articleId, @Param("userId") String userId, @Param("value") boolean value);
}
