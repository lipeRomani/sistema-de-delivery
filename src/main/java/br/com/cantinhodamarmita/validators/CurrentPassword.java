package br.com.cantinhodamarmita.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(value={
        ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy=CurrentPasswordValidator.class)
public @interface CurrentPassword {

    String message() default "{currentPassword.value.violation}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default { };

}
