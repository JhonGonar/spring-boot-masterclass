package com.example.demo.exception;

import com.example.demo.customer.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

//This class can handle more than one exception, might be a general purpose template (with few extra modif.)
@ControllerAdvice //this enables its usage all over the app. in all the controllers
public class ApiExceptionHandler {

    private final static Logger LOGGER =
            LoggerFactory.getLogger(ApiExceptionHandler.class);

    //we can embed and simplify on controller using modern: https://www.baeldung.com/exception-handling-for-rest-with-spring#responsestatusexception
    @ExceptionHandler(value = ApiRequestException.class)//must be equal to the argument received by method below
    public ResponseEntity<Object> handleApiRequestException(
            ApiRequestException apiRequestException //response entity it's the payload we return
    ){// here we build the exception with the attributes defined on ApiException.class
        ApiException apiException = new ApiException(
                apiRequestException.getMessage(),
                apiRequestException,
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(apiException,
                HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = NotFoundException.class)//must be equal to the argument received by method below
    public ResponseEntity<Object> handleApiRequestException(
            NotFoundException notFoundException
    ){
        ApiException apiException = new ApiException(
                notFoundException.getMessage(),
                notFoundException,
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(apiException,
                HttpStatus.NOT_FOUND);
    }
}

    /*
    * A more global implementation could be:
    * @ControllerAdvice
public class RestResponseEntityExceptionHandler
  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
      = { IllegalArgumentException.class, IllegalStateException.class })
    protected ResponseEntity<Object> handleConflict(
      RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "This should be application specific";
        return handleExceptionInternal(ex, bodyOfResponse,
          new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
} retrieved from: https://www.baeldung.com/exception-handling-for-rest-with-spring
    * */
