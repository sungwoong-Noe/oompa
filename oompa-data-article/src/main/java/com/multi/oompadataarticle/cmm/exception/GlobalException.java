package com.multi.oompadataarticle.cmm.exception;

import com.multi.oompaglobal.exception.ErrorCode;
import com.multi.oompaglobal.exception.ErrorResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    // 선언되지 않은 예외는 여기서 처리한다
    @ExceptionHandler(value = Exception.class)
    public ErrorResponseDto internalError(Exception e) {
        return ErrorResponseDto
                .of(ErrorCode.INTERNAL_SERVER_ERROR.getErrorCode(), ErrorCode.INTERNAL_SERVER_ERROR.getMessage());
    }

    // 요청 값의 검증이 실패했을 경우 여기서 예외를 처리한다.
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ErrorResponseDto methodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ErrorResponseDto
                .ofBindingError(ErrorCode.METHOD_ARGUMENT_NOT_VALID_EXCEPTION.getErrorCode(), e.getBindingResult());

    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ErrorResponseDto illegalArgumentException(IllegalArgumentException e) {

        return ErrorResponseDto.of(ErrorCode.INTERNAL_SERVER_ERROR.getErrorCode(), e.getMessage());

    }

}
