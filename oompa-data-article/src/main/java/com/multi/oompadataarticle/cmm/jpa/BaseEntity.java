package com.multi.oompadataarticle.cmm.jpa;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.val;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
public abstract class BaseEntity {

    @Column(name = "created_time", updatable = false)
    private String createdTime;

    @Column(name = "modified_time")
    private String modifiedTime;

    @Column(name = "del_yn")
    private boolean delYn;

    @PrePersist
    public void prePersist() {

        var format = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss");
        this.createdTime = LocalDateTime.now().format(format);
        this.delYn = false;
    }

    @PreUpdate
    public void preUpdate() {
        var format = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss");
        this.modifiedTime = LocalDateTime.now().format(format);
    }


    //삭제
    public void delete() {
        this.delYn = true;
    }
}
