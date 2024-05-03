package app.gestion.banque.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@ControllerAdvice
public class FournisseurNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(FournisseurNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String fournisseurNotFoundHandler(FournisseurNotFoundException ex) {
        return ex.getMessage();
    }

}
