package com.multi.oompaglobal.res;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto {

    private String code;

    private String message;

    public ResponseDto(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
