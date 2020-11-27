package br.com.ricas.controlleradvice;

import br.com.ricas.exceptions.FinanceException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ricardo.mello
 */
@RestControllerAdvice
public class FinanceExceptionHandler {

    @ExceptionHandler(FinanceException.class)
    public ResponseEntity<ApiResponseError> financeException(FinanceException ex) {
        return getResponseEntity(ex, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<ApiResponseError> getResponseEntity(RuntimeException ex, HttpStatus httpStatus) {
        ApiResponseError apiErrorResponse = new ApiResponseError(ex.getMessage());
        apiErrorResponse.addError(String.format("%s: %s", ex.getClass().getSimpleName(), ex.getMessage()));

        return new ResponseEntity<>(apiErrorResponse, httpStatus);
    }

    @Data
    @AllArgsConstructor
    static class ApiResponseError {

        private HttpStatus status = HttpStatus.BAD_REQUEST;
        private String message;
        private List<String> errors;

        public ApiResponseError() {
        }

        public ApiResponseError(String message) {
            this.message = message;
        }

        public void addError(String error) {
            if (errors == null)
                errors = new ArrayList<>();

            errors.add(error);
        }
    }
}