package br.com.ibmec.projetocloud.ikaros.errorHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ValidationErrorResponse validationErrorHandler(MethodArgumentNotValidException e) {
        ValidationErrorResponse result = new ValidationErrorResponse();

        for (FieldError error : e.getBindingResult().getFieldErrors()) {
            result.addErrorValidation(error.getField(), error.getDefaultMessage());
        }

        return result;
    }

    @ExceptionHandler(MethodNotAllowedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ResponseBody
    public ValidationErrorResponse methodNotAllowedErrorHandler(MethodNotAllowedException e) {
        ValidationErrorResponse result = new ValidationErrorResponse();

        result.addErrorValidation("405 Method Not Allowed", "Método HTTP não permitido, verifique a rota da sua URL.");

        return result;
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ResponseBody
    public ResponseEntity<ValidationErrorResponse> handleMethodNotAllowedException(
            HttpRequestMethodNotSupportedException e) {
        ValidationErrorResponse response = new ValidationErrorResponse();
        response.addErrorValidation("405 Method Not Allowed",
                "Método HTTP não suportado, verifique a rota da sua URL.");

        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(response);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ResponseEntity<ValidationErrorResponse> handleNotFoundException(
            NoHandlerFoundException e) {
        ValidationErrorResponse response = new ValidationErrorResponse();
        response.addErrorValidation("404 Not Found",
                "A página ou recurso solicitado não foi encontrado, verifique a rota da sua URL.");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ResponseEntity<ValidationErrorResponse> handleHttpMessageNotReadableException(
            HttpMessageNotReadableException e) {
        ValidationErrorResponse response = new ValidationErrorResponse();
        response.addErrorValidation("400 Bad Request", "Requisição inválida, verifique os dados enviados.");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
