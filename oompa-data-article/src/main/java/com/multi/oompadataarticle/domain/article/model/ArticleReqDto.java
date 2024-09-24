package com.multi.oompadataarticle.domain.article.model;

import com.multi.oompadataarticle.cmm.status.ArticleStatus;
import com.multi.oompadataarticle.domain.article.entity.ArticleEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ArticleReqDto {

    private Long idx;

    private String title;

    private String content;

    private ArticleStatus status;


    @Builder
    public ArticleReqDto(Long idx, String title, String content, ArticleStatus status) {
        this.idx = idx;
        this.title = title;
        this.content = content;
        this.status = status;
    }

    public ArticleEntity toEntity() {
        return ArticleEntity.builder()
                .idx(this.idx)
                .title(this.title)
                .content(this.content)
                .status(this.status)
                .build();
    }
}
