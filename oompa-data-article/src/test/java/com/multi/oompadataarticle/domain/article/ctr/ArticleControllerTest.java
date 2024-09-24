package com.multi.oompadataarticle.domain.article.ctr;

import com.multi.oompadataarticle.domain.article.entity.ArticleEntity;
import com.multi.oompadataarticle.domain.article.repo.ArticleRepository;
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
                        .accept(APPLICATION_JSON)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value(1L))
                .andDo(print());


        List<ArticleEntity> all = articleRepository.findAll();

        assertThat(all.size()).isEqualTo(1L);
    }



}