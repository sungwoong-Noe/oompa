package com.multi.oompadataarticle.domain.article.repo;

import com.multi.oompadataarticle.cmm.status.ArticleStatus;
import com.multi.oompadataarticle.domain.article.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {

    List<ArticleEntity> findByStatus(String status);
}
