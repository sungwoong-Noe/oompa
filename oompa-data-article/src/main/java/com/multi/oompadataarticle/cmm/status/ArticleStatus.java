package com.multi.oompadataarticle.cmm.status;

import lombok.Getter;

@Getter
public enum ArticleStatus {

    COMPLETE_SAVED("complete_saved"),
    TEMP_SAVED("temp_saved")
    ;


    private final String status;

    ArticleStatus(String status) {
        this.status = status;
    }
}
