package com.multi.oompadataarticle.domain.article.service;

import com.multi.oompadataarticle.domain.article.entity.ArticleEntity;
import com.multi.oompadataarticle.domain.article.model.ArticleReqDto;
import com.multi.oompadataarticle.domain.article.repo.ArticleRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(value = MockitoExtension.class)
public class ArticleServiceImplTest {


    @InjectMocks
    private ArticleServiceImpl articleService;

    @Mock
    private ArticleRepository articleRepository;


//    @Test
//    @DisplayName("게시글 - 임시 저장(새로 저장되는 경우)")
//    public void temporary_save() {
//        //given
//        ArticleReqDto requestDto = ArticleReqDto.builder()
//                .title("title_1")
//                .content("<p>content</p>")
//                .build();
//
//        ArticleEntity entity = ArticleEntity.builder()
//                .idx(1L)
//                .title(requestDto.getTitle())
//                .content(requestDto.getContent())
//                .build();
//
//
//        //expected
//        when(articleRepository.save(entity)).thenReturn(any());
//
//        Long articleIdx = articleService.create(requestDto);
//
//        Assertions.assertThat(articleIdx).isEqualTo(entity.getIdx());
//
//    }



}