package com.multi.oompadataarticle.domain.article.service;

import com.multi.oompadataarticle.domain.article.model.ArticleRequestDto;

public interface ArticleService {

    /**
     * 임시 저장
     */
    void temporarySave(ArticleRequestDto requestDto);


    /**
     * 완전 저장
     */
    void completeSave(ArticleRequestDto requestDto);









}
