package com.multi.oompadataarticle.domain.article.service;

import com.multi.oompadataarticle.domain.article.model.ArticleReqDto;
import com.multi.oompadataarticle.domain.article.model.ArticleResDto;

import java.util.List;

public interface ArticleService {


    /**
     * 게시글 저장
     */
    Long create(ArticleReqDto reqDto);

    List<ArticleResDto> retrieve();

}
