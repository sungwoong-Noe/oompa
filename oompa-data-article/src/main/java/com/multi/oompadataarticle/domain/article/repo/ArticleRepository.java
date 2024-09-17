package com.multi.oompadataarticle.domain.article.repo;

import com.multi.oompadataarticle.domain.article.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {
}
