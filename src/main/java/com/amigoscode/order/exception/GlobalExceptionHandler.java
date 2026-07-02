package com.amigoscode.order.exception;

// TODO: 7 - Create a global exception handler:
//  - Annotate with @ControllerAdvice
//  - Add an @ExceptionHandler(OrderNotFoundException.class) method
//    that returns ResponseEntity<ApiError>
//  - Build an ApiError with the request path, exception message, 404 status, and current timestamp
//  Hint: inject HttpServletRequest to get the request path

// TODO: 8 - Add another @ExceptionHandler for MethodArgumentNotValidException:
//  - Extract field errors from the exception
//  - Build a message string with all field errors: "field: message; field: message"
//  - Return a 400 Bad Request response with ApiError
//  Hint: ex.getBindingResult().getFieldErrors()
public class GlobalExceptionHandler {

}
