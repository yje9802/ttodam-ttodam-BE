package com.ttodampartners.ttodamttodam.global.error;

import com.ttodampartners.ttodamttodam.domain.chat.dto.response.StompExceptionResponse;
import com.ttodampartners.ttodamttodam.domain.chat.exception.StompException;
import com.ttodampartners.ttodamttodam.domain.keyword.exception.KeywordException;
import com.ttodampartners.ttodamttodam.domain.chat.dto.ChatExceptionResponse;
import com.ttodampartners.ttodamttodam.domain.chat.exception.ChatroomException;
import com.ttodampartners.ttodamttodam.domain.chat.exception.ChatroomStringException;
import com.ttodampartners.ttodamttodam.domain.user.exception.AwsException;
import com.ttodampartners.ttodamttodam.domain.user.exception.CoordinateException;
import com.ttodampartners.ttodamttodam.infra.email.exception.MailException;
import com.ttodampartners.ttodamttodam.domain.user.exception.UserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(UserException.class)
  public ResponseEntity<String> userExceptionHandle(UserException e) {
    log.error("에러코드: {}, 에러 메시지: {}", e.getErrorCode(), e.getErrorMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getErrorMessage());
  }

  @ExceptionHandler(MailException.class)
  public ResponseEntity<String> mailExceptionHandle(MailException e) {
    log.error("에러코드: {}, 에러 메시지: {}", e.getErrorCode(), e.getErrorMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getErrorMessage());
  }

  @ExceptionHandler(AwsException.class)
  public ResponseEntity<String> awsExceptionHandle(AwsException e) {
    log.error("에러코드: {}, 에러 메시지: {}", e.getErrorCode(), e.getErrorMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getErrorMessage());
  }

  @ExceptionHandler(CoordinateException.class)
  public ResponseEntity<String> coordinateExceptionHandle(CoordinateException e) {
    log.error("에러코드: {}, 에러 메시지: {}", e.getErrorCode(), e.getErrorMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getErrorMessage());
  }

  @ExceptionHandler(KeywordException.class)
  public ResponseEntity<String> keywordExceptionHandle(KeywordException e) {
    log.error("에러코드: {}, 에러 메시지: {}", e.getErrorCode(), e.getErrorMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getErrorMessage());
  }

  /*
    채팅방 관련 Exception 추가
  */
  @ExceptionHandler(ChatroomException.class)
  public ResponseEntity<ChatExceptionResponse> ChatroomExceptionHandler(ChatroomException e) {
    log.error("에러코드: {}, 에러 메시지: {}", e.getErrorCode(), e.getErrorMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getResponse());
  }

  @ExceptionHandler(ChatroomStringException.class)
  public ResponseEntity<String> ChatroomStringExceptionHandler(ChatroomStringException e) {
    log.error("에러코드: {}, 에러 메시지: {}", e.getErrorCode(), e.getErrorMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getErrorMessage());
  }

  /*
    Stomp 관련 Exception 추가
  */
  @ExceptionHandler(StompException.class)
  public ResponseEntity<ChatExceptionResponse> StompExceptionHandler(StompException e) {
    log.error("에러코드: {}, 에러 메시지: {}", e.getErrorCode(), e.getErrorMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getResponse());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<String> validationExceptionHandle(MethodArgumentNotValidException e) {
    String errorMessage = e.getBindingResult().getFieldError().getDefaultMessage();
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
  }
}