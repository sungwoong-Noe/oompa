package com.multi.oompadataarticle.domain.article.ctr;

import com.multi.oompadataarticle.cmm.status.ArticleStatus;
import com.multi.oompadataarticle.domain.article.entity.ArticleEntity;
import com.multi.oompadataarticle.domain.article.repo.ArticleRepository;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
class ArticleControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    EntityManager em;


    @Test
    @DisplayName("Article 저장 요청 - 임시 저장 상태")
    public void create() throws Exception {

        //given
        String articleForm = """
                {
                    "title": "article title",
                    "content": " content",
                    "status": "TEMP_SAVED"
                 }               
                """;

        //expected
        mvc.perform(post("/article")
                        .content(articleForm)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value(1L))
                .andDo(print());


        List<ArticleEntity> all = articleRepository.findAll();

        assertThat(all.size()).isEqualTo(1L);
    }

    @Test
    @DisplayName("Article 수정 요청")
    public void patch() throws Exception {

        //given

        ArticleEntity article = ArticleEntity.builder()
                .title("title")
                .content("content")
                .status(ArticleStatus.COMPLETE_SAVED)
                .build();

        articleRepository.saveAndFlush(article);

        em.clear();


        String articleForm = """
                {
                    "idx": "1",
                    "title": "update title",
                    "content": " content",
                    "status": "TEMP_SAVED"
                 }               
                """;


        mvc.perform(post("/article")
                        .content(articleForm)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value(1L))
                .andDo(print());


        ArticleEntity articleEntity = articleRepository.findById(1L).get();
        List<ArticleEntity> all = articleRepository.findAll();

        assertThat(articleEntity.getIdx()).isEqualTo(1L);
        assertThat(articleEntity.getTitle()).isEqualTo("update title");
        assertThat(all.size()).isEqualTo(1L);

    }
}