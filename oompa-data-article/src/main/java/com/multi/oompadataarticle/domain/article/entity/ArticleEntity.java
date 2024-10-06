package com.multi.oompadataarticle.domain.article.entity;

import com.multi.oompadataarticle.cmm.jpa.BaseEntity;
import com.multi.oompadataarticle.cmm.status.ArticleStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "article")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ArticleEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_idx")
    private Long idx;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "status")
    private ArticleStatus status;

    @Builder
    public ArticleEntity(Long idx, String title, String content, ArticleStatus status) {
        this.idx = idx;
        this.title = title;
        this.content = content;
        this.status = status;
    }


    public void articleUpdate(String title, String content, ArticleStatus status) {

        this.title = title;
        this.content = content;
        this.status = status;

    }
}
