package com.multi.oompaglobal.res;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
public class ResponseDto<T> {

    private int code;

    private HttpStatus status;

    private T content;


    @Builder
    public ResponseDto(int code, HttpStatus status, T content) {
        this.code = code;
        this.status = status;
        this.content = content;
    }

    // 응답 형식
    public static <T> ResponseDto<T> of(T content) {

        return ResponseDto.<T>builder()
                .code(HttpStatus.OK.value())
                .status(HttpStatus.OK)
                .content(content)
                .build();

    }

}
