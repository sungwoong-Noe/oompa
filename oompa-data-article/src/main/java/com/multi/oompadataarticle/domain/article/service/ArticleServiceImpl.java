package com.multi.oompadataarticle.domain.article.service;

import com.multi.oompadataarticle.cmm.status.ArticleStatus;
import com.multi.oompadataarticle.domain.article.entity.ArticleEntity;
import com.multi.oompadataarticle.domain.article.model.ArticleReqDto;
import com.multi.oompadataarticle.domain.article.model.ArticleResDto;
import com.multi.oompadataarticle.domain.article.repo.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.multi.oompadataarticle.cmm.status.ArticleStatus.COMPLETE_SAVED;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;


    @Override
    @Transactional
    public Long create(ArticleReqDto reqDto) {

        ArticleEntity result = articleRepository.save(reqDto.toEntity());

        return result.getIdx();
    }


    @Override
    public List<ArticleResDto> retrieve() {


        List<ArticleEntity> articles = articleRepository.findByStatus(COMPLETE_SAVED.getStatus());

        return articles.stream().map(ArticleResDto::ofEntity).toList();

    }
}
