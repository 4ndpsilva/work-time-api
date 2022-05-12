package app.worktime.infrastructure.exception;

import app.worktime.infrastructure.exception.dto.ErrorResponseDTO;
import app.worktime.infrastructure.util.ConstantMSG;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.format.DateTimeParseException;
import java.util.List;

@RequiredArgsConstructor
@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    private final ResponseMessageCreator responseMessageCreator;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleExceptionInternal(ex, responseMessageCreator.getErrors(ex.getBindingResult()), headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<List<ErrorResponseDTO>> handleResourceNotFoundException(ResourceNotFoundException ex){
        return responseMessageCreator.error(ex.getCodeMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorResponseDTO>> handleBusinessException(BusinessException ex){
        return responseMessageCreator.error(ex.getCodeMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<List<ErrorResponseDTO>> handleDateFormat() {
        final BusinessException exception = new BusinessException(ConstantMSG.API_004);
        return responseMessageCreator.error(exception.getCodeMessage(), HttpStatus.BAD_REQUEST);
    }
}