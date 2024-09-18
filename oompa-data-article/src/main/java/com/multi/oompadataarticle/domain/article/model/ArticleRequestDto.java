package com.multi.oompadataarticle.domain.article.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ArticleRequestDto {

    private Long idx;

    private String title;

    private String content;


    @Builder
    public ArticleRequestDto(Long idx, String title, String content) {
        this.idx = idx;
        this.title = title;
        this.content = content;
    }
}
