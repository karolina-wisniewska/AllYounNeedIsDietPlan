package pl.coderslab.allyouneedisdietplan.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = IsAdultValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsAdult {
  String message() default "{isAdult.error.message}";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
