package com.multi.oompadataarticle.domain.article.repo;

import com.multi.oompadataarticle.cmm.status.ArticleStatus;
import com.multi.oompadataarticle.domain.article.entity.ArticleEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@DataJpaTest
class ArticleRepositoryTest {

    @Autowired
    ArticleRepository articleRepository;


    @Test
    @DisplayName("article을 저장한다.")
    public void save() {

        //given
        ArticleEntity article = ArticleEntity.builder()
                .status(ArticleStatus.TEMP_SAVED)
                .title("article1")
                .content("<p>article content2</p>")
                .build();


        //when
        articleRepository.save(article);

        List<ArticleEntity> allArticles = articleRepository.findAll();

        //then
        assertThat(allArticles.size()).isEqualTo(1L);

    }
}