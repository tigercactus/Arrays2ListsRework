package pro.sky.demo.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value =HttpStatus.BAD_REQUEST)
public class IncorrectNameException extends RuntimeException {
}
