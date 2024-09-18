package com.multi.oompadataarticle.domain.article.service;

import com.multi.oompadataarticle.cmm.status.ArticleStatus;
import com.multi.oompadataarticle.domain.article.entity.ArticleEntity;
import com.multi.oompadataarticle.domain.article.model.ArticleRequestDto;
import com.multi.oompadataarticle.domain.article.repo.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;


    @Override
    @Transactional
    public void temporarySave(ArticleRequestDto requestDto) {

        log.info("게시글 임시 저장 요청 => {}", requestDto.getTitle());

        ArticleEntity articleEntity = articleRepository.findById(requestDto.getIdx())
                .orElse(
                        ArticleEntity.builder()
                                .title(requestDto.getTitle())
                                .content(requestDto.getContent())
                                .status(ArticleStatus.TEMP_SAVED)
                                .build()
                );

        articleRepository.save(articleEntity);

        log.info("게시글 임시 저장 완료 => {}", requestDto.getTitle());
    }

    @Override
    @Transactional
    public void completeSave(ArticleRequestDto requestDto) {

        log.info("게시글 완전 저장 요청 => {}", requestDto.getTitle());

        ArticleEntity articleEntity = articleRepository.findById(requestDto.getIdx())
                .orElse(
                    ArticleEntity.builder()
                            .title(requestDto.getTitle())
                            .content(requestDto.getContent())
                            .status(ArticleStatus.TEMP_SAVED)
                            .build()
                );


        if (articleEntity.getStatus().equals(ArticleStatus.TEMP_SAVED)) {
            articleEntity.articleUpdate(requestDto.getTitle(), requestDto.getContent(), ArticleStatus.COMPLETE_SAVED);
        }

        articleRepository.save(articleEntity);

        log.info("게시글 완전 저장 완료 => {}", requestDto.getTitle());
    }
}
