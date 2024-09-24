package com.multi.oompadataarticle.domain.article.service;

import com.multi.oompadataarticle.domain.article.model.ArticleReqDto;

public interface ArticleService {


    /**
     * 게시글 저장
     */
    Long create(ArticleReqDto reqDto);


    /**
     * 임시 저장
     */
    void temporarySave(ArticleReqDto requestDto);


    /**
     * 완전 저장
     */
    void completeSave(ArticleReqDto requestDto);










}
