package com.multi.oompaglobal.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;

import java.util.List;

@Getter
@NoArgsConstructor
public class ErrorResponseDto {

    private String errorCode;
    private String errorMessage;

    @Builder
    public ErrorResponseDto(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }


    public static ErrorResponseDto of(String errorCode, String errorMessage) {
        return ErrorResponseDto.builder()
                .errorCode(errorCode)
                .errorMessage(errorMessage)
                .build();
    }

    private static ErrorResponseDto ofBindingError(String errorCode, BindingResult bindingResult) {

        return ErrorResponseDto.builder()
                .errorCode(errorCode)
                .errorMessage(createBindingErrorMessage(bindingResult))
                .build();
    }


    // 필드 에러 메세지 생성 함수
    private static String createBindingErrorMessage(BindingResult bindingResult) {
        StringBuilder sb = new StringBuilder();
        //첫번째 에러 여부
        boolean isFirst = true;

        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            if (!isFirst) {
                sb.append(", ");
            } else {
                isFirst = false;
            }
            sb.append("[");
            sb.append(fieldError.getField());
            sb.append("]");
            sb.append(fieldError.getDefaultMessage());
        }

        return sb.toString();
    }

//    public static ErrorResponseDto of(String errorCode, BindingResult bindingResult) {
//        this(errorCode, bindingResult.getFieldErrors());
//    }
}
