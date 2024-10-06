package com.multi.oompadataarticle.cmm.status;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public enum ArticleStatus {

    COMPLETE_SAVED("complete_saved"),
    TEMP_SAVED("temp_saved")
    ;

    private final String status;

    public static ArticleStatus of(String codeStr) {

        if (codeStr.isBlank()) {
            throw new IllegalArgumentException("");
        }

        for (ArticleStatus as : ArticleStatus.values()) {
            if (as.status.equals(codeStr)) {
                return as;
            }
        }


        throw new IllegalArgumentException("일치하는 게시글 상태값이 없습니다.");
    }

    ArticleStatus(String status) {
        this.status = status;
    }
}
