package com.multi.oompadataarticle.domain.article.model;

import com.multi.oompadataarticle.domain.article.entity.ArticleEntity;

public record ArticleResDto(Long idx,
                            String title,
                            String content) {




    public static ArticleResDto ofEntity(ArticleEntity entity) {

        return new ArticleResDto(
                entity.getIdx(),
                entity.getTitle(),
                entity.getContent()
        );
    }


}
