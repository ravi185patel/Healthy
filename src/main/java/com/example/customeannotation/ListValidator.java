package com.example.customeannotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ListValidatorI.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ListValidator {

    String message() default " list must not be null}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

