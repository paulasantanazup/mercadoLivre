package br.com.paula.mercadoLivre.validador;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UnicoValidator.class)
public @interface Unico {

    String message() default "Esse dado já está cadastrado no sistema!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String campo();

    Class<?> modelClass();
}
