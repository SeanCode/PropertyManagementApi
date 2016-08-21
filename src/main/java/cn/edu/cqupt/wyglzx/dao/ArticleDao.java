package cn.edu.cqupt.wyglzx.dao;

import cn.edu.cqupt.wyglzx.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cc on 16/7/31.
 */
@Repository
public interface ArticleDao extends JpaRepository<ArticleEntity, Long> {

    @Query(value = "select * from article where type = :type and  weight >= 0 order by create_time DESC limit :offset,10", nativeQuery = true)
    List<ArticleEntity> getArticleListByTypeAndOffset(@Param("type") Integer type, @Param("offset") Integer offset);

    @Query(value = "select * from article where type > 20000 and type < 30000 and  weight >= 0 order by create_time DESC limit :offset,10", nativeQuery = true)
    List<ArticleEntity> getNewsListByOffset(@Param("offset") Integer offset);

    @Query(value = "select * from article where weight >= 0 order by create_time DESC limit 10", nativeQuery = true)
    List<ArticleEntity> getLatestArticles();

    @Query(value = "select count(*) from article where weight >= 0 and type = :type", nativeQuery = true)
    Integer getListAmountByType(@Param("type") Integer type);

    @Query(value = "select * from article where id = :id and type = :type and weight >= 0", nativeQuery = true)
    ArticleEntity getArticleByIdAndType(@Param("id") Long id, @Param("type") Integer type);

    @Query(value = "select * from article where create_time < :create_time and type = :type and weight >= 0 order by create_time DESC, id DESC limit 1", nativeQuery = true)
    ArticleEntity getArticlePrevious(@Param("create_time") Long createTime, @Param("type") Integer type);

    @Query(value = "select * from article where create_time > :create_time  and type = :type and weight >= 0 order by create_time ASC, id ASC limit 1", nativeQuery = true)
    ArticleEntity getArticleNext(@Param("create_time") Long createTime, @Param("type") Integer type);

}