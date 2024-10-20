package com.multi.oompadataarticle.domain.article.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QArticleEntity is a Querydsl query type for ArticleEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QArticleEntity extends EntityPathBase<ArticleEntity> {

    private static final long serialVersionUID = -1941390670L;

    public static final QArticleEntity articleEntity = new QArticleEntity("articleEntity");

    public final com.multi.oompadataarticle.cmm.jpa.QBaseEntity _super = new com.multi.oompadataarticle.cmm.jpa.QBaseEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final StringPath createdTime = _super.createdTime;

    //inherited
    public final BooleanPath delYn = _super.delYn;

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    //inherited
    public final StringPath modifiedTime = _super.modifiedTime;

    public final StringPath status = createString("status");

    public final StringPath title = createString("title");

    public QArticleEntity(String variable) {
        super(ArticleEntity.class, forVariable(variable));
    }

    public QArticleEntity(Path<? extends ArticleEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QArticleEntity(PathMetadata metadata) {
        super(ArticleEntity.class, metadata);
    }

}

